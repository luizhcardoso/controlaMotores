package BancoDeDados;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import Entity.Usinada;
import Entity.pontoDeLeitura;

public class DaoUsinada implements Serializable {


	// Create an EntityManagerFactory when you start the application.
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("motor");

	public void escreveUsinada(Usinada usinada) {
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {

			// Get a transaction
			transaction = manager.getTransaction();

			// Begin the transaction
			transaction.begin();
			manager.persist(usinada);
			System.out.println("gravou");
			// Commit the transaction
			transaction.commit();
		} catch (Exception ex) {
			// If there are any exceptions, roll back the changes
			if (transaction != null) {
				transaction.rollback();
			}
			// Print the Exception
			ex.printStackTrace();
		} finally {
			// Close the EntityManager
			manager.close();
		}
	}

	/**
	 * Read all the Students.
	 * 
	 * @return a List of Students
	 */
	
	public List<Usinada> retornaTodoBanco() {

		List<Usinada> usinada = null;

		// Create an EntityManager
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			transaction = manager.getTransaction();
			transaction.begin();
			
			Query query= manager.createQuery("from Usinada u ");
			usinada=query.getResultList();

		} catch (Exception ex) {
			// If there are any exceptions, roll back the changes
			if (transaction != null) {
				transaction.rollback();
			}
			// Print the Exception
			ex.printStackTrace();
		} finally {
			// Close the EntityManager
			manager.close();
		}
		return usinada;
	}

	
	public Usinada retornaUsinadaCodigo(int codigo) {

		Usinada usinada = null;

		// Create an EntityManager
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			// Get a transaction
			transaction = manager.getTransaction();
			// Begin the transaction
			transaction.begin();

			// Get a List of Students
		
			
			usinada = manager.find(Usinada.class, codigo);

			// Commit the transaction
			transaction.commit();
		} catch (Exception ex) {
			// If there are any exceptions, roll back the changes
			if (transaction != null) {
				transaction.rollback();
			}
			// Print the Exception
			ex.printStackTrace();
		} finally {
			// Close the EntityManager
			manager.close();
		}
		return usinada;
	}

	public List<Usinada> retornaIntervaloDeData(String inicial,String fim) {

		List<Usinada> usinada = null;

		// Create an EntityManager
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy hh:mm:ss"); //você pode usar outras máscaras
			Date dataInicial=sdf1.parse(inicial);
			Date dataFinal=sdf1.parse(fim);
			transaction = manager.getTransaction();
			transaction.begin();

			Query query= manager.createQuery("FROM Usinada AS c WHERE c.data BETWEEN :stDate AND :edDate ");
			query.setParameter("stDate", dataInicial);
			query.setParameter("edDate", dataFinal);
			usinada=query.getResultList();

		} catch (Exception ex) {
			// If there are any exceptions, roll back the changes
			if (transaction != null) {
				transaction.rollback();
			}
			// Print the Exception
			ex.printStackTrace();
		} finally {
			// Close the EntityManager
			manager.close();
		}
		return usinada;
	}


	public Usinada lerUltimaLinha() {
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;
		Query query = manager.createQuery("from Usinada where codigo=(select max(codigo) from Usinada )");
		query.setMaxResults(1);
		Usinada product = (Usinada)query.getSingleResult();
		return product;
	}

	public List<Usinada> lerUltimasLinha(int paginacao) {
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;
		Query query = manager.createQuery("select c FROM Usinada c");
		query.setFirstResult(lerUltimaLinha().getCodigo()-20);
		query.setMaxResults(20);
		List<Usinada> cats = query.getResultList();
		return cats;
	}

	/**
	 * Delete the existing Student.
	 * 
	 * @param id
	 */
	public void delete(int codigo) {
		// Create an EntityManager
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			// Get a transaction
			transaction = manager.getTransaction();
			// Begin the transaction
			transaction.begin();

			// Get the Student object
			pontoDeLeitura pontoDeLeitura = manager.find(pontoDeLeitura.class, codigo);

			// Delete the student
			manager.remove(pontoDeLeitura);

			// Commit the transaction
			transaction.commit();
		} catch (Exception ex) {
			// If there are any exceptions, roll back the changes
			if (transaction != null) {
				transaction.rollback();
			}
			// Print the Exception
			ex.printStackTrace();
		} finally {
			// Close the EntityManager
			manager.close();
		}
	}

	/**
	 * Update the existing Student.
	 * 
	 * @param id
	 * @param name
	 * @param age
	 */
	public void upate(int codigo, Date date, 
			boolean pressaoSkidA, boolean pressaoSkidB, boolean transferenciaSkindA, 
			boolean transferenciaSkidB, boolean vacuo, boolean portaUsina) { {
				// Create an EntityManager
				EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
				EntityTransaction transaction = null;

				try {
					// Get a transaction
					transaction = manager.getTransaction();
					// Begin the transaction
					transaction.begin();

					// Get the Student object
					pontoDeLeitura pt = manager.find(pontoDeLeitura.class, codigo);

					// Change the values

					pt.setPortaUsina(portaUsina);
					pt.setMotorVacuo(vacuo);
					pt.setMotorPressaoSkidA(pressaoSkidA);
					pt.setMotorPressaoSkidB(pressaoSkidB);
					pt.setMotorTransferenciaSkidA(transferenciaSkindA);
					pt.setMotorTransferenciaSkidB(transferenciaSkidB);
					pt.setData(date);

					// Update the student
					manager.persist(pt);

					// Commit the transaction
					transaction.commit();
				} catch (Exception ex) {
					// If there are any exceptions, roll back the changes
					if (transaction != null) {
						transaction.rollback();
					}
					// Print the Exception
					ex.printStackTrace();
				} finally {
					// Close the EntityManager
					manager.close();
				}
			}
	}
	public String imprimeTodoBanco(){
		String imprime="=======================Usinadas================================\n";
		List<Usinada> usinada=retornaTodoBanco();
		for(Usinada b : usinada){
			imprime+="----------------------- Usinada Codigo : ["+b.getCodigo()+"]-------------------------------\n"+
					"Status  " +  b.getStatus()+"\n"+
					".................Dados usinada......................\n";

			 
			for(pontoDeLeitura i : b.getPontosDeLeituras()){
				imprime+=i.toStringThis();						
			}

			
		}
		return imprime;
	}
		//	public boolean verificaAlteracaoDeEstadoDosMotores(Usinada usinada){
		//		Usinada usinada=lerUltimaLinha();
		//		
		//		System.out.println("Usinada:  "+usinada.toStringThis()+"\n"
		//				+ "Ponto gravar:  "+UltimoPonto.toStringThis());
		//		
		//		if(
		//				usinada.isMotorPressaoSkidA()      != UltimoPonto.isMotorPressaoSkidA() ||
		//				usinada.isMotorPressaoSkidB()      != UltimoPonto.isMotorPressaoSkidB() ||
		//				usinada.isMotorTransferenciaSkidA()!= UltimoPonto.isMotorTransferenciaSkidA()||
		//				usinada.isMotorTransferenciaSkidB()!= UltimoPonto.isMotorTransferenciaSkidB()||
		//				usinada.isMotorVacuo()				!= UltimoPonto.isMotorVacuo()||
		//				usinada.isPortaUsina()				!= UltimoPonto.isPortaUsina()){
		//			escrevePontoLeitura(UltimoPonto);
		//			System.out.println("Gravou no banco!");
		//			return true;
		//		}else{
		//			System.out.println("Nao Gravou no banco!");
		//			return false;
		//		}
		//	}

	
	}
