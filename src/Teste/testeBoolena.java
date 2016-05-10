package Teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;

import BancoDeDados.DaoPontoLeitura;
import Entity.pontoDeLeitura;
import View.TelaPrincipalMonitora;

public class testeBoolena {
public static void main(String[] args) throws ParseException {

//	DaoPontoLeitura daoPontoLeitura=new DaoPontoLeitura();
//	
//	SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy hh:mm:ss"); //você pode usar outras máscaras
//	String inicial="26/04/2016 00:00:59";
//	String fim="26/04/2016 23:59:59";
//	Date dataInicial=sdf1.parse(inicial);
//	Date dataFinal=sdf1.parse(fim);
//
//	
//	for(pontoDeLeitura b : daoPontoLeitura.retornaIntervaloDeData("26/04/2016 00:00:59", "26/04/2016 23:59:59")){
//	
//	System.out.println(b.toStringThis());
	pontoDeLeitura a=new pontoDeLeitura(new Date(), true, true, true, true, true, true);
	TelaPrincipalMonitora tela=new TelaPrincipalMonitora();
	tela.verificaEstado(a);
	tela.setVisible(true);
	}
}

