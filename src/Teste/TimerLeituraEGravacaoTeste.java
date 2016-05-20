package Teste;

import java.util.Timer;
import java.util.TimerTask;
import BancoDeDados.DaoPontoLeitura;
import BancoDeDados.DaoUsinada;
import Controler.controlaUsinada;
import Entity.Usinada;
import Entity.pontoDeLeitura;
import View.TelaPrincipalMonitora;
import motor.LerDadosWeb;

public class TimerLeituraEGravacaoTeste {
	controlaUsinada controle;
	Usinada usinada;
	DaoUsinada daoUsina;
	DaoPontoLeitura daoPonto;
	int contador=0;
	Timer timer;
	static TelaPrincipalMonitora frame;
	public TimerLeituraEGravacaoTeste() {

		timer = new Timer();
		timer.schedule(new RemindTask(),
				0,        //initial delay
				10*1000);  //subsequent rate
	}

	class RemindTask extends TimerTask {

		public void run() {
			System.out.println(contador);
			DaoPontoLeitura daoPontoLeitura=new DaoPontoLeitura();
			LerDadosWeb ler=new LerDadosWeb();
			pontoDeLeitura ponto=ler.retornaPontoDeLeitura();
			frame.verificaEstado(ponto);

			if(controle==null || usinada==null){
				daoUsina=new DaoUsinada();
				controle=new controlaUsinada();
				usinada=new Usinada();
				daoUsina.escreveUsinada(usinada);
				System.out.println("[Instanciou]");
			}
			if(daoPontoLeitura.gravaNoBancoVerificaAlteracaoDeEstado(ponto)){
			ponto.setStatus(controle.getOperacao(ponto));
			ponto.setUsinada(usinada);
			controle.verificaProcessosUsinada(ponto);
			daoPontoLeitura=new DaoPontoLeitura();
			daoPontoLeitura.escrevePontoLeitura(ponto);
			System.out.println(ponto.toStringThis());
			}
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

		public void stopTimer(){
			timer.cancel();
		}
	}

	public static void main(String args[]) {
		System.out.println("[===========  teste ============[");
		frame=new TelaPrincipalMonitora();
		TimerLeituraEGravacaoTeste t= new TimerLeituraEGravacaoTeste();
		frame.setVisible(true);
		

	}
}