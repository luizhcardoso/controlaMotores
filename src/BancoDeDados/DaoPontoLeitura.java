package BancoDeDados;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Entity.pontoDeLeitura;

import javax.persistence.EntityManagerFactory;

public class DaoPontoLeitura {


	// Create an EntityManagerFactory when you start the application.
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("motor");

	public void escrevePontoLeitura(Date date, 
			boolean pressaoSkidA, boolean pressaoSkidB, boolean transferenciaSkindA, 
			boolean transferenciaSkidB, boolean vacuo, boolean portaUsina) {
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {

			// Get a transaction
			transaction = manager.getTransaction();

			// Begin the transaction
			transaction.begin();
			// Create a new  object
			pontoDeLeitura pt = new pontoDeLeitura();
			pt.setPortaUsina(portaUsina);
			pt.setMotorVacuo(vacuo);
			pt.setMotorPressaoSkidA(pressaoSkidA);
			pt.setMotorPressaoSkidB(pressaoSkidB);
			pt.setMotorTransferenciaSkidA(transferenciaSkindA);
			pt.setMotorTransferenciaSkidB(transferenciaSkidB);
			pt.setData(date);

			// Save the student object
			manager.persist(pt);
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
	
	public void escrevePontoLeitura(pontoDeLeitura ponto) {
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {

			// Get a transaction
			transaction = manager.getTransaction();

			// Begin the transaction
			transaction.begin();
			manager.persist(ponto);
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
	public List readAll() {

		List<pontoDeLeitura> pontoDeLeitura = null;

		// Create an EntityManager
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			// Get a transaction
			transaction = manager.getTransaction();
			// Begin the transaction
			transaction.begin();

			// Get a List of Students
			List<pontoDeLeitura> list= manager.createQuery("select c FROM pontoDeLeitura c",
					pontoDeLeitura.class).getResultList();

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
		return pontoDeLeitura;
	}
	
	public List<pontoDeLeitura> retornaIntervaloDeData(String inicial,String fim) {

		List<pontoDeLeitura> pontoDeLeitura = null;

		// Create an EntityManager
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy hh:mm:ss"); //você pode usar outras máscaras
			Date dataInicial=sdf1.parse(inicial);
			Date dataFinal=sdf1.parse(fim);
			transaction = manager.getTransaction();
			transaction.begin();
			
			Query query= manager.createQuery("FROM pontoDeLeitura AS c WHERE c.data BETWEEN :stDate AND :edDate ");
			query.setParameter("stDate", dataInicial);
			query.setParameter("edDate", dataFinal);
			pontoDeLeitura=query.getResultList();
					
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
		return pontoDeLeitura;
	}

	@SuppressWarnings("unchecked")
	public pontoDeLeitura lerUltimaLinha() {
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;
		Query query = manager.createQuery("from pontoDeLeitura where codigo=(select max(codigo) from pontoDeLeitura )");
		query.setMaxResults(1);
		pontoDeLeitura product = (pontoDeLeitura)query.getSingleResult();
		return product;
		      }
	
	public List<pontoDeLeitura> lerUltimasLinha(int paginacao) {
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;
		Query query = manager.createQuery("select c FROM pontoDeLeitura c");
		query.setFirstResult(lerUltimaLinha().getCodigo()-20);
		query.setMaxResults(20);
		List<pontoDeLeitura> cats = query.getResultList();
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
		String imprime="====================================================";
		List<pontoDeLeitura> lista=readAll();
		for(pontoDeLeitura i : lista){
			imprime+=
					"Codigo " +  i.getCodigo() +"\n"+
							"PortaUsina  " +  i.isPortaUsina()+"\n"+
							"MotorVacuo  " +  i.isMotorVacuo()+"\n"+
							"MotorPressaoSkidA  " +  i.isMotorPressaoSkidA()+"\n"+
							"MotorPressaoSkidB  " +  i.isMotorPressaoSkidB()+"\n"+
							"MotorTransferenciaSkidA  " +  i.isMotorTransferenciaSkidA()+"\n"+
							"MotorTransferenciaSkidB  " +  i.isMotorTransferenciaSkidB()+"\n"+
							"Data  " +  i.getData()+"\n"
							+ "___________________________________________________________";
		}

		return imprime;
	}
	public boolean verificaAlteracaoDeEstadoDosMotores(pontoDeLeitura UltimoPonto){
		pontoDeLeitura pontoDoBanco=lerUltimaLinha();
		
		System.out.println("Ponto do Banco:  "+pontoDoBanco.toStringThis()+"\n"
				+ "Ponto gravar:  "+UltimoPonto.toStringThis());
		
		if(
				pontoDoBanco.isMotorPressaoSkidA()      != UltimoPonto.isMotorPressaoSkidA() ||
				pontoDoBanco.isMotorPressaoSkidB()      != UltimoPonto.isMotorPressaoSkidB() ||
				pontoDoBanco.isMotorTransferenciaSkidA()!= UltimoPonto.isMotorTransferenciaSkidA()||
				pontoDoBanco.isMotorTransferenciaSkidB()!= UltimoPonto.isMotorTransferenciaSkidB()||
				pontoDoBanco.isMotorVacuo()				!= UltimoPonto.isMotorVacuo()||
				pontoDoBanco.isPortaUsina()				!= UltimoPonto.isPortaUsina()){
			escrevePontoLeitura(UltimoPonto);
			System.out.println("Gravou no banco!");
			return true;
		}else{
			System.out.println("Nao Gravou no banco!");
			return false;
		}
	}


}
