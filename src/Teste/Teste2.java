package Teste;

import java.util.ArrayList;
import java.util.Date;

import BancoDeDados.DaoPontoLeitura;
import Entity.Usinada;
import Entity.pontoDeLeitura;

public class Teste2 {
	public static void main(String[] args) throws Exception {

		testePontoDeLeituraDAO dao=new testePontoDeLeituraDAO();
		pontoDeLeitura ponto=new pontoDeLeitura();
		DaoPontoLeitura pt=new DaoPontoLeitura();
		ponto.setPontoDeLeitura(new Date(),false,false,false,false,false,true);
//		ArrayList<pontoDeLeitura> dao2=(ArrayList<pontoDeLeitura>) dao.readAll();
		pt.escrevePontoLeitura(ponto);
		
	}

}
