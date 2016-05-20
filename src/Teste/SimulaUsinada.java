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
		
	Usinada usin=new Usinada();
		
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
	desligado.setUsinada(usin);
	vacuoIncial.setUsinada(usin);
	enchimento.setUsinada(usin);
	pressao.setUsinada(usin);
	retorno.setUsinada(usin);
	vacuoFinal.setUsinada(usin);
	abreUsina.setUsinada(usin);
	
	desligado.setStatus(new controlaUsinada().getOperacao(desligado));
	vacuoIncial.setStatus(new controlaUsinada().getOperacao(vacuoIncial));
	enchimento.setStatus(new controlaUsinada().getOperacao(enchimento));
	pressao.setStatus(new controlaUsinada().getOperacao(pressao));
	retorno.setStatus(new controlaUsinada().getOperacao(retorno));
	vacuoFinal.setStatus(new controlaUsinada().getOperacao(vacuoFinal));
	abreUsina.setStatus(new controlaUsinada().getOperacao(abreUsina));
	
	
	List<pontoDeLeitura> array=new ArrayList<>();
	array.add(desligado);
	array.add(vacuoIncial);
	array.add(enchimento);
	array.add(pressao);
	array.add(retorno);
	array.add(vacuoFinal);
	array.add(abreUsina);
	
	usin.setPontosDeLeituras(array);
	
	DaoUsinada u=new DaoUsinada();
	u.escreveUsinada(usin);
	

	
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
	
	
	}
}

