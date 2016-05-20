package Teste;

import java.io.Serializable;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.OptimisticLockException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;

public class testeGenericDao<E> implements Serializable {

	
//	protected EntityManager entityManager;
	

	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("motor");
	protected EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

	public E insertBean(final E bean) throws Exception {
		try {
			EntityTransaction transaction = entityManager.getTransaction();
			// Begin the transaction
			transaction.begin();
			entityManager.persist(bean);
			entityManager.flush();
			return bean;
		} catch (IllegalStateException e) {
			throw new Exception(e.getMessage());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new Exception(e);
		} catch (TransactionRequiredException e) {
			e.printStackTrace();
			throw new Exception(e);
		} catch (EntityExistsException e) {
			e.printStackTrace();
			throw new Exception(e);
		} catch (OptimisticLockException e) {
			throw new Exception("Houve alteração por outro usuário.", e);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public E updateBean(final E bean) throws Exception {
		try {
			entityManager.merge(bean);
			entityManager.flush();
			return bean;
		} catch (IllegalStateException e) {
			throw new Exception(e);
		} catch (IllegalArgumentException e) {
			throw new Exception(e);
		} catch (TransactionRequiredException e) {
			throw new Exception(e);
		} catch (OptimisticLockException e) {
			throw new Exception("Houve alteração por outro usuário.", e);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public void removeBean(final Class<E> classType, final Serializable identifier) throws Exception {
		try {
			final E bean = getBean(classType, identifier);
			if (bean != null) {
				entityManager.remove(bean);
				entityManager.flush();
			} else {
				throw new Exception("Registro não encontrado para exclusão!");
			}
		} catch (IllegalStateException e) {
			throw new Exception(e.getMessage());
		} catch (IllegalArgumentException e) {
			throw new Exception(e.getMessage());
		} catch (TransactionRequiredException e) {
			throw new Exception(e.getMessage());
		} catch (PersistenceException e) {
			if (e.getMessage().contains("ConstraintViolationException")) {
				throw new Exception("Registro possui relação com outros registros e não pode ser excluído!");
			} else
				throw new Exception(e.getMessage());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public E getBean(final Class<E> classType, final Serializable identifier) throws Exception {
		try {
			return entityManager.find(classType, identifier);
		} catch (IllegalStateException e) {
			throw new Exception(e);
		} catch (IllegalArgumentException e) {
			throw new Exception(e);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public Query createNamedQuery(final String namedQuery) throws Exception {
		
		try {
			Query query=entityManager.createQuery(namedQuery);
			
			return query;
		} catch (IllegalStateException e) {
			throw new Exception(e);
		} catch (IllegalArgumentException e) {
			throw new Exception("Não foi possivel efetuar a consulta para esta namedQuery " + namedQuery, e);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}
}