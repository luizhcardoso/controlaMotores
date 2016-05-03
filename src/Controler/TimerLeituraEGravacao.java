package Controler;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import BancoDeDados.DaoPontoLeitura;
import Entity.pontoDeLeitura;
import Telas.telaInicial;
import View.TelaPrincipalMonitora;
import motor.LerDadosWeb;

public class TimerLeituraEGravacao {
	
	    Timer timer;
	    TelaPrincipalMonitora frame;
	    public TimerLeituraEGravacao() {
	        
	        timer = new Timer();
	        timer.schedule(new RemindTask(),
	                       0,        //initial delay
	                       10*1000);  //subsequent rate
	        
	         }

	    class RemindTask extends TimerTask {
	        
	        public void run() {
	              DaoPontoLeitura daoPontoLeitura=new DaoPontoLeitura();
	              LerDadosWeb ler=new LerDadosWeb();
	              System.out.println(ler.LerDadosWeb());
	              pontoDeLeitura ponto=ler.retornaPontoDeLeitura();
	              daoPontoLeitura.verificaAlteracaoDeEstadoDosMotores(ponto);
	              frame=new TelaPrincipalMonitora(ponto);
	             
	              
	              
	        }
	        
	        public void stopTimer(){
	        timer.cancel();
	        }

	    }
	    
	    public static void main(String args[]) {
	    	TimerLeituraEGravacao t= new TimerLeituraEGravacao();
	    	
	    	System.out.println("Task scheduled.");
	    }
}