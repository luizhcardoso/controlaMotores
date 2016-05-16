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
	Usinada usina;
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
			//cria conexao bd
			DaoPontoLeitura daoPontoLeitura=new DaoPontoLeitura();
			//busca dados arduiono ip
			LerDadosWeb ler=new LerDadosWeb(); 
			//transforma leitura web em pt de leitura
			pontoDeLeitura ponto=ler.retornaPontoDeLeitura();

			//se possuir alteracao 
			if(controle==null){
				System.out.println("instanciou variaveis");
				controle=new controlaUsinada();
				usina=new Usinada();
			    frame.verificaEstado(ponto);
			}
				if(daoPontoLeitura.gravaNoBancoVerificaAlteracaoDeEstado(ponto)){
					frame.verificaEstado(ponto);
					ponto.setUsinada(usina);
					daoPontoLeitura.escrevePontoLeitura(ponto);
					controle.verificaProcessosUsinada(ponto);
				}
				if(controle.getAberturaDePorta()!=null && 
				   controle.getFechamentoDeporta()!=null){
					usina.setPontosDeLeituras(controle.retornaListaDeLeituras());
					DaoUsinada gravaUsinada=new DaoUsinada();
					gravaUsinada.escreveUsinada(usina);
					controle=null;
				}
			}

		

		public void stopTimer(){
			timer.cancel();
		}
	}

	public static void main(String args[]) {
		System.out.println("======teste============");
		frame=new TelaPrincipalMonitora();
		TimerLeituraEGravacaoTeste t= new TimerLeituraEGravacaoTeste();
		controlaUsinada controle=new controlaUsinada();

	}
}