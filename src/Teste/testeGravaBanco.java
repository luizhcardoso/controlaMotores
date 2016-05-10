package Teste;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.persistence.EntityManagerFactory;
import BancoDeDados.DaoPontoLeitura;
import BancoDeDados.DaoUsinada;
import Entity.Usinada;
import Entity.pontoDeLeitura;
import motor.LerDadosWeb;

public class testeGravaBanco {

	public static void main(String[] args) {
		
		final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
				.createEntityManagerFactory("motor");

			EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
			EntityTransaction transaction = null;

			

				// Get a transaction
				transaction = manager.getTransaction();

				// Begin the transaction
				transaction.begin();
				// Create a new  object
				
				pontoDeLeitura pt1=new pontoDeLeitura(new Date(),false,false,false,false,false,false);
				pontoDeLeitura pt2=new pontoDeLeitura(new Date(),true,false,false,false,false,true);
				pontoDeLeitura pt3=new pontoDeLeitura(new Date(),true,false,false,false,true,true);
				pontoDeLeitura pt4=new pontoDeLeitura(new Date(),true,false,false,true,false,true);
				pontoDeLeitura pt5=new pontoDeLeitura(new Date(),true,false,false,false,true,false);
				pontoDeLeitura pt6=new pontoDeLeitura(new Date(),true,false,false,false,true,false);
				pontoDeLeitura pt7=new pontoDeLeitura(new Date(),true,false,false,false,true,false);
				pontoDeLeitura pt8=new pontoDeLeitura(new Date(),true,false,false,false,true,false);
				
				String status="ok";
				List<pontoDeLeitura> pt=new ArrayList<pontoDeLeitura>();
				pt.add(pt1);
				pt.add(pt2);
				pt.add(pt3);
				pt.add(pt5);
				pt.add(pt8);
				Usinada usinada=new Usinada(pt,"de");
				Usinada usinada2=new Usinada(pt,"d");
				Usinada usinada3=new Usinada(pt,"d");
				manager.persist(usinada);	
				manager.persist(usinada2);	
				manager.persist(usinada3);	
			
				// Save the object
				transaction.commit();
				
		
		
		
//		
//		DaoUsinada usina=new DaoUsinada();
//		usina.escreveUsinada(pt, "oK");

//		System.out.println(ler.retornaPontoDeLeitura().toStringThis()+"\n-===========================-");
		
//		for(String a : ler.retornaDadosLeituraWeb()){
//			System.out.println(a);
//		}
		
//		DAO dao=new DAO();
//		
//		pontoDeLeitura novoPonto=new pontoDeLeitura(new Date(),true,false,false,false,false,true);
//		if(dao.verificaAlteracaoDeEstadoDosMotores(novoPonto)){
//			System.out.println("ALTERADO ! ESCREVE NO BANCO");
//			dao.escrevePontoLeitura(novoPonto);
//			
//		}else{
//			System.out.println("NAO ALTERACAO ! NAO ESCREVE NO BANCO");
//		}
				
//		JFrame frame=new telaInicial(novoPonto);
//		frame.setVisible(true);
		
		
		// Create an EntityManagerFactory when you start the application.
//		final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
//				.createEntityManagerFactory("motor");
//
//			EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
//			EntityTransaction transaction = null;
//
//			
//
//				// Get a transaction
//				transaction = manager.getTransaction();
//
//				// Begin the transaction
//				transaction.begin();
//				// Create a new  object
//				produto pt1 = new produto();
//				produto pt2 = new produto();
//				categoria ct=new categoria();
//				ct.setDescricao("Madeira");
//				categoria ct2=new categoria();
//				ct2.setDescricao("Carne");
//				
//				manager.persist(ct);
//				manager.persist(ct2);
//				// Save the student object
//				pt1.setDescricao("lapis");
//				pt2.setDescricao("ossos");
//				pt1.setCategoria(ct);
//				pt1.setCategoria(ct2);
//				
//				
//				manager.persist(pt1);
//				manager.persist(pt2);
//				transaction.commit();
//				System.out.println("gravou");
//		
		
		
		
			
		}
	}
	


