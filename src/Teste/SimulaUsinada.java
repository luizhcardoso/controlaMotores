package Teste;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import BancoDeDados.DaoPontoLeitura;
import BancoDeDados.DaoUsinada;
import Controler.controlaUsinada;
import Entity.Usinada;
import Entity.pontoDeLeitura;

public class SimulaUsinada {
	public static void main(String[] args) {
		

	pontoDeLeitura desligado=new pontoDeLeitura(
			new Date(),
			false,
			false,
			false,
			false,
			false,
			false);
//	try {
//	      Thread.sleep(1000);
//	     } catch (Exception e) {}
	
	pontoDeLeitura fechaPorta=new pontoDeLeitura(
			new Date(),
			false,
			false,
			false,
			false,
			false,
			true);
	pontoDeLeitura vacuoIncial=new pontoDeLeitura(
			new Date(),
			false,
			false,
			true,
			false,
			false,
			true);
	pontoDeLeitura enchimento=new pontoDeLeitura(
			new Date(),
			false,
			false,
			false,
			false,
			true,
			true);
	pontoDeLeitura pressao=new pontoDeLeitura(
			new Date(),
			true,
			false,
			false,
			false,
			false,
			true);
	pontoDeLeitura retorno=new pontoDeLeitura(
			new Date(),
			false,
			false,
			false,
			true,
			false,
			true);
	pontoDeLeitura vacuoFinal=new pontoDeLeitura(
			new Date(),
			false,
			false,
			true,
			false,
			false,
			true);
	pontoDeLeitura abreUsina=new pontoDeLeitura(
			new Date(),
			false,
			false,
			false,
			false,
			false,
			false);
	
	List<pontoDeLeitura> usina=new ArrayList<>();
	usina.add(desligado);
	usina.add(vacuoIncial);
	usina.add(enchimento);
	usina.add(pressao);
	usina.add(retorno);
	usina.add(vacuoFinal);
	usina.add(abreUsina);
	
//	controlaUsinada controla=new controlaUsinada();
//	System.out.println(controla.verificaProcessosUsinada(desligado));
//	System.out.println(controla.verificaProcessosUsinada(vacuoIncial));
//	System.out.println(controla.verificaProcessosUsinada(enchimento));
//	System.out.println(controla.verificaProcessosUsinada(pressao));
//	System.out.println(controla.verificaProcessosUsinada(retorno));
//	System.out.println(controla.verificaProcessosUsinada(vacuoFinal));
//	System.out.println(controla.verificaProcessosUsinada(abreUsina));
//	
//	
	
	DaoUsinada usinada=new DaoUsinada();
	usinada.escreveUsinada(usina,"teste2");
	
	System.out.println(usinada.imprimeTodoBanco());
	List<Usinada> a=usinada.readAll();
	for (Usinada i : a) {
		System.out.println(i.getCodigo());
//		System.out.println(i.getPontosDeLeituras());
	}
	DaoPontoLeitura ponto=new DaoPontoLeitura();

	
	
	
	
//	System.out.println(usinada.imprimeTodoBanco());
	
	
	}
}

