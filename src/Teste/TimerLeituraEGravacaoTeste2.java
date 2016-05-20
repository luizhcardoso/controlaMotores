package Teste;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import BancoDeDados.DaoPontoLeitura;
import BancoDeDados.DaoUsinada;
import Controler.controlaUsinada;
import Entity.Usinada;
import Entity.pontoDeLeitura;
import View.TelaPrincipalMonitora;


public class TimerLeituraEGravacaoTeste2 {
	controlaUsinada controle;
	Usinada usinada;
	DaoUsinada daoUsina;
	DaoPontoLeitura daoPonto;
	int contador=0;
	Timer timer;
	static TelaPrincipalMonitora frame;
	public TimerLeituraEGravacaoTeste2() {

		timer = new Timer();
		timer.schedule(new RemindTask(),
				0,        //initial delay
				1*1000);  //subsequent rate
	}

	class RemindTask extends TimerTask {
		
	public void run() {
			

			// Begin the transaction
		
			System.out.println(contador);
			DaoPontoLeitura daoPontoLeitura=new DaoPontoLeitura();
//			DaoPontoLeitura daoPontoLeitura=new DaoPontoLeitura();
//			LerDadosWeb ler=new LerDadosWeb();
//			pontoDeLeitura ponto=ler.retornaPontoDeLeitura();
//			frame.verificaEstado(ponto);
//			data, PressaoSkidA, PressaoSkidB,	TrasferenciaSkidA , TransferenciaSkidB,Vacuo,portaUsina) 
			pontoDeLeitura ponto=new pontoDeLeitura();
			
			if(contador==0){//fecha porta
				ponto.setPontoDeLeitura(new Date(),false,false,false,false,false,false);
			}
			if(contador==1){// vacuo inicial
				ponto.setPontoDeLeitura(new Date(),false,false,false,false,true,false);
			}
			if(contador==2){//  delay
				ponto.setPontoDeLeitura(new Date(),false,false,false,false,false,false);
			}
			if(contador==3){//  delay
				ponto.setPontoDeLeitura(new Date(),false,false,false,false,false,false);
			}
			if(contador==4){//  enchimento
				ponto.setPontoDeLeitura(new Date(),false,false,true,false,false,false);
			}
			if(contador==5){//  pressao
				ponto.setPontoDeLeitura(new Date(),true,false,false,false,false,false);
			}
			if(contador==6){//  pressao
				ponto.setPontoDeLeitura(new Date(),true,false,false,false,false,false);
			}
			if(contador==7){//  retorno
				ponto.setPontoDeLeitura(new Date(),false,false,true,false,false,false);
			}
			if(contador==8){// vacuo final
				ponto.setPontoDeLeitura(new Date(),false,false,false,false,true,false);
			}
			if(contador==9){// abertura de porta
				ponto.setPontoDeLeitura(new Date(),false,false,false,false,false,false);
			}
			if(contador>9){
				ponto.setPontoDeLeitura(new Date(),false,false,false,false,false,true);
			}
			
			frame.verificaEstado(ponto);
			
			if(controle==null || usinada==null){
				daoUsina=new DaoUsinada();
				controle=new controlaUsinada();
				usinada=new Usinada();
				daoUsina.escreveUsinada(usinada);
				System.out.println("[Instanciou]");
			}
				ponto.setStatus(controle.getOperacao(ponto));
				ponto.setUsinada(usinada);
				controle.verificaProcessosUsinada(ponto);
				daoPontoLeitura=new DaoPontoLeitura();
					daoPontoLeitura.escrevePontoLeitura(ponto);
				  
				
				if(controle.getAberturaDePorta()!=null){ //aqui !
					System.out.println("Entoru na pressa agora !");
					contador=0;
					usinada.setPontosDeLeituras(controle.getListaDeLeitura());
					daoUsina.upate(usinada);
					controle=null;
					usinada=null;
					
			}
			contador++;
			
		}
	}



	public void stopTimer(){
		timer.cancel();
	}


	public static void main(String args[]) {
		frame=new TelaPrincipalMonitora();
		frame.setVisible(true);
		TimerLeituraEGravacaoTeste2 t= new TimerLeituraEGravacaoTeste2();

	}
}