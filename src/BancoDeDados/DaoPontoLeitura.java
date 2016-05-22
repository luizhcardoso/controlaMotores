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
	public List<pontoDeLeitura> readAll() {

		List<pontoDeLeitura> pontoDeLeitura = null;

		// Create an EntityManager
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
//		EntityTransaction transaction = null;

		try {
			// Get a transaction
//			transaction = manager.getTransaction();
			// Begin the transaction
//			transaction.begin();

			// Get a List of Students
			 Query query=manager.createQuery("select c FROM pontoDeLeitura c");
			 pontoDeLeitura =query.getResultList();
			// Commit the transaction
//			transaction.commit();
		} catch (Exception ex) {
			// If there are any exceptions, roll back the changes
//			if (transaction != null) {
//				transaction.rollback();
//			}
			// Print the Exception
//			ex.printStackTrace();
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
			SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy"); //você pode usar outras máscaras
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
		try{
		Query query = manager.createQuery("from pontoDeLeitura where codigo=(select max(codigo) from pontoDeLeitura )");
		query.setMaxResults(1);
		pontoDeLeitura product = (pontoDeLeitura)query.getSingleResult();
		return product;
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
		return null;
	}
	
	public List<pontoDeLeitura> retornaPaginacao(int paginacao) {
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;
		Query query = manager.createQuery("select c FROM pontoDeLeitura c");
		query.setFirstResult(lerUltimaLinha().getCodigo()-paginacao);
		query.setMaxResults(paginacao);
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
		String imprime="====================================================\n";
		List<pontoDeLeitura> lista=readAll();
		for(pontoDeLeitura i : lista){
			imprime+=
					"Codigo ponto de Leitura:" +  i.getCodigo() +"\n"+
							"PortaUsina  " +  i.isPortaUsina()+"\n"+
							"MotorVacuo  " +  i.isMotorVacuo()+"\n"+
							"MotorPressaoSkidA  " +  i.isMotorPressaoSkidA()+"\n"+
							"MotorPressaoSkidB  " +  i.isMotorPressaoSkidB()+"\n"+
							"MotorTransferenciaSkidA  " +  i.isMotorTransferenciaSkidA()+"\n"+
							"MotorTransferenciaSkidB  " +  i.isMotorTransferenciaSkidB()+"\n"+
							"Data  " +  i.getData()+"\n"
							+ "___________________________________________________________\n";
		}

		return imprime;
	}
	public boolean gravaNoBancoVerificaAlteracaoDeEstado(pontoDeLeitura UltimoPonto){
		
		try{
			
			pontoDeLeitura pontoDoBanco=lerUltimaLinha();
		System.out.println("Ponto do Banco:  "+pontoDoBanco.toStringThis()+"\n"
				+ "Ponto gravar:  "+UltimoPonto.toStringThis());
		//grava no banco somente se o for diferente do ultimo registro
		if(
				pontoDoBanco.isMotorPressaoSkidA()      != UltimoPonto.isMotorPressaoSkidA() ||
				pontoDoBanco.isMotorPressaoSkidB()      != UltimoPonto.isMotorPressaoSkidB() ||
				pontoDoBanco.isMotorTransferenciaSkidA()!= UltimoPonto.isMotorTransferenciaSkidA()||
				pontoDoBanco.isMotorTransferenciaSkidB()!= UltimoPonto.isMotorTransferenciaSkidB()||
				pontoDoBanco.isMotorVacuo()				!= UltimoPonto.isMotorVacuo()||
				pontoDoBanco.isPortaUsina()				!= UltimoPonto.isPortaUsina()){
//				escrevePontoLeitura(UltimoPonto);  
			
			return true;
		}else{
			System.out.println("*Ponto de leitura Igual*");
			return false;
		}
		}catch (Exception ex) {
			// If there are any exceptions, roll back the changes
		
				escrevePontoLeitura(UltimoPonto);
			
			// Print the Exception
			ex.printStackTrace();
			return false;
		} 
		
	}
	}



