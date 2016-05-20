package Controler;

import java.util.Timer;
import java.util.TimerTask;
import BancoDeDados.DaoPontoLeitura;
import Entity.pontoDeLeitura;
import View.TelaPrincipalMonitora;
import motor.LerDadosWeb;

public class TimerLeituraEGravacao {
		controlaUsinada controle=new controlaUsinada();
	    Timer timer;
	    static TelaPrincipalMonitora frame;
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
	              pontoDeLeitura ponto=ler.retornaPontoDeLeitura();
	              
	              // verifica qual operacao esta sendo realizada
	              daoPontoLeitura.gravaNoBancoVerificaAlteracaoDeEstado(ponto);  
	              frame.verificaEstado(ponto);
	       }
	        
	        public void stopTimer(){
	        timer.cancel();
	        }

	    }
	    
	    public static void main(String args[]) {
	    	TimerLeituraEGravacao t= new TimerLeituraEGravacao();
	    	frame=new TelaPrincipalMonitora();
	    	
	    }
}