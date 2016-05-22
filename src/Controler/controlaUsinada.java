package Controler;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Entity.pontoDeLeitura;

public class controlaUsinada {


	private pontoDeLeitura AberturaDePorta;
	private pontoDeLeitura vacuoInicial;
	private pontoDeLeitura enchimento;
	private pontoDeLeitura pressao;
	private pontoDeLeitura retorno;
	private pontoDeLeitura vacuoFinal;
	private pontoDeLeitura FechamentoDeporta;
	private pontoDeLeitura delay;
	private List<pontoDeLeitura> listaDeLeitura=new ArrayList<>();

	public void verificaProcessosUsinada(pontoDeLeitura ponto){

		//verifica fecha porta

		if(		FechamentoDeporta==null && 
				ponto.isMotorPressaoSkidA()==false &&
				ponto.isMotorPressaoSkidB()==false &&
				ponto.isMotorTransferenciaSkidA()==false &&
				ponto.isMotorTransferenciaSkidB()==false &&
				ponto.isMotorVacuo()==false &&
				ponto.isPortaUsina()==false){
			FechamentoDeporta=ponto;
			listaDeLeitura.add(FechamentoDeporta);
			
		}//verifica delay
		if(		FechamentoDeporta!=null &&
				ponto.isMotorPressaoSkidA()==false &&
				ponto.isMotorPressaoSkidB()==false &&
				ponto.isMotorTransferenciaSkidA()==false &&
				ponto.isMotorTransferenciaSkidB()==false &&
				ponto.isMotorVacuo()==false &&
				ponto.isPortaUsina()==false){
			delay=ponto;
			listaDeLeitura.add(delay);
		
		}
		//verifica vacuoInicial
		if(		vacuoInicial==null && 
				ponto.isMotorPressaoSkidA()==false &&
				ponto.isMotorPressaoSkidB()==false &&
				ponto.isMotorTransferenciaSkidA()==false &&
				ponto.isMotorTransferenciaSkidB()==false &&
				ponto.isMotorVacuo()==true &&
				ponto.isPortaUsina()==false){
			vacuoInicial=ponto;
			listaDeLeitura.add(vacuoInicial);
			
		}
		//verifica Enchimento
		if(		enchimento==null && ponto.isMotorPressaoSkidA()==false &&
				ponto.isMotorPressaoSkidB()==false &&
				ponto.isMotorTransferenciaSkidA()==true ||
				ponto.isMotorTransferenciaSkidB()==true &&
				ponto.isMotorVacuo()==false &&
				ponto.isPortaUsina()==false){
			enchimento=ponto;
			listaDeLeitura.add(enchimento);
			
		}

		//verifica pressao
		if(		ponto.isMotorPressaoSkidA()==true ||
				ponto.isMotorPressaoSkidB()==true &&
				ponto.isMotorTransferenciaSkidA()==false &&
				ponto.isMotorTransferenciaSkidB()==false &&
				ponto.isMotorVacuo()==false &&
				ponto.isPortaUsina()==false){
			pressao=ponto;
			listaDeLeitura.add(pressao);
			
		}
		//verifica retorno
		if(		enchimento!=null && ponto.isMotorPressaoSkidA()==false &&
				ponto.isMotorPressaoSkidB()==false &&
				ponto.isMotorTransferenciaSkidA()==true ||
				ponto.isMotorTransferenciaSkidB()==true &&
				ponto.isMotorVacuo()==false &&
				ponto.isPortaUsina()==false){
			retorno=ponto;
			listaDeLeitura.add(retorno);
			
		}
		//verifica vacuoFinal
		if(		vacuoInicial!=null &&
				ponto.isMotorPressaoSkidA()==false &&
				ponto.isMotorPressaoSkidB()==false &&
				ponto.isMotorTransferenciaSkidA()==false &&
				ponto.isMotorTransferenciaSkidB()==false &&
				ponto.isMotorVacuo()==true &&
				ponto.isPortaUsina()==false){
			vacuoFinal=ponto;
			listaDeLeitura.add(vacuoFinal);
			
		}
		//verifica AberturaDePorta
		if(		ponto.isMotorPressaoSkidA()==false &&
				ponto.isMotorPressaoSkidB()==false &&
				ponto.isMotorTransferenciaSkidA()==false &&
				ponto.isMotorTransferenciaSkidB()==false &&
				ponto.isMotorVacuo()==false &&
				ponto.isPortaUsina()==true){

			AberturaDePorta=ponto;
			listaDeLeitura.add(AberturaDePorta);
			
		}
		

		
	
	}


	public String getOperacao(pontoDeLeitura ponto){

		//verifica fecha porta

		if(		FechamentoDeporta==null && 
				ponto.isMotorPressaoSkidA()==false &&
				ponto.isMotorPressaoSkidB()==false &&
				ponto.isMotorTransferenciaSkidA()==false &&
				ponto.isMotorTransferenciaSkidB()==false &&
				ponto.isMotorVacuo()==false &&
				ponto.isPortaUsina()==false){

			return "FechamentoDeporta";
		}//verifica delay
		if(		FechamentoDeporta!=null &&
				ponto.isMotorPressaoSkidA()==false &&
				ponto.isMotorPressaoSkidB()==false &&
				ponto.isMotorTransferenciaSkidA()==false &&
				ponto.isMotorTransferenciaSkidB()==false &&
				ponto.isMotorVacuo()==false &&
				ponto.isPortaUsina()==false){
			return "delay";
		}
		//verifica vacuoInicial
		if(		vacuoInicial==null && 
				ponto.isMotorPressaoSkidA()==false &&
				ponto.isMotorPressaoSkidB()==false &&
				ponto.isMotorTransferenciaSkidA()==false &&
				ponto.isMotorTransferenciaSkidB()==false &&
				ponto.isMotorVacuo()==true &&
				ponto.isPortaUsina()==false){
			return "vacuoInicial";
		}
		//verifica Enchimento
		if(		enchimento==null && ponto.isMotorPressaoSkidA()==false &&
				ponto.isMotorPressaoSkidB()==false &&
				ponto.isMotorTransferenciaSkidA()==true ||
				ponto.isMotorTransferenciaSkidB()==true &&
				ponto.isMotorVacuo()==false &&
				ponto.isPortaUsina()==false){
			return "enchimento";
		}

		//verifica pressao
		if(		ponto.isMotorPressaoSkidA()==true ||
				ponto.isMotorPressaoSkidB()==true &&
				ponto.isMotorTransferenciaSkidA()==false &&
				ponto.isMotorTransferenciaSkidB()==false &&
				ponto.isMotorVacuo()==false &&
				ponto.isPortaUsina()==false){
			return "pressao";
		}
		//verifica retorno
		if(		enchimento!=null && ponto.isMotorPressaoSkidA()==false &&
				ponto.isMotorPressaoSkidB()==false &&
				ponto.isMotorTransferenciaSkidA()==true ||
				ponto.isMotorTransferenciaSkidB()==true &&
				ponto.isMotorVacuo()==false &&
				ponto.isPortaUsina()==false){
			return "retorno";
		}
		//verifica vacuoFinal
		if(		vacuoInicial!=null &&
				ponto.isMotorPressaoSkidA()==false &&
				ponto.isMotorPressaoSkidB()==false &&
				ponto.isMotorTransferenciaSkidA()==false &&
				ponto.isMotorTransferenciaSkidB()==false &&
				ponto.isMotorVacuo()==true &&
				ponto.isPortaUsina()==false){
			return "vacuoFinal";
		}
		//verifica AberturaDePorta
		if(		ponto.isMotorPressaoSkidA()==false &&
				ponto.isMotorPressaoSkidB()==false &&
				ponto.isMotorTransferenciaSkidA()==false &&
				ponto.isMotorTransferenciaSkidB()==false &&
				ponto.isMotorVacuo()==false &&
				ponto.isPortaUsina()==true){
			return"AberturaDePorta";
		}
		return "null";
	}

	public pontoDeLeitura getAberturaDePorta() {
		return AberturaDePorta;
	}

	public pontoDeLeitura getVacuoInicial() {
		return vacuoInicial;
	}

	public pontoDeLeitura getEnchimento() {
		return enchimento;
	}

	public pontoDeLeitura getPressao() {
		return pressao;
	}

	public pontoDeLeitura getRetorno() {
		return retorno;
	}

	public pontoDeLeitura getVacuoFinal() {
		return vacuoFinal;
	}

	public pontoDeLeitura getFechamentoDeporta() {
		return FechamentoDeporta;
	}
	public pontoDeLeitura getDelay() {
		return delay;
	}

	public List<pontoDeLeitura> getListaDeLeitura() {
		return listaDeLeitura;
	}


	public Date calculaDiferencaDeHoras(Date data1,Date data2){
		Date txt=null; 
		DateFormat somaDiferenca =null;
		try{
			// constrói a primeira data
			// vamos obter a diferença em semanas, dias, horas,
			// minutos e segundos
			long segundos = (data2.getTime() - 
					data1.getTime()) / 1000;
			//			      int semanas = (int)Math.floor(segundos / 604800);
			//			      segundos -= semanas * 604800;
			//			      int dias = (int)Math.floor(segundos / 86400);
			//			      segundos -= dias * 86400;
			int horas = (int)Math.floor(segundos / 3600);
			segundos -= horas * 3600;
			int minutos = (int)Math.floor(segundos / 60);
			segundos -= minutos * 60;

			somaDiferenca = new SimpleDateFormat("HH:mm:ss");
			txt = (Date)somaDiferenca.parse(horas+":"+minutos+":"+segundos);

			// exibe o resultado
			//			      txt=(horas +":"+ minutos +":"+segundos);
		}
		catch(ParseException e){
			e.printStackTrace();
		}


		return txt;
	}

	public String formataData(Date data){
		SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
		return fm.format(data);
	}
	public String formataDataSemSegundos(Date data){
		SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy [HH:mm]");
		return fm.format(data);
	}
	public String formataHoraMinutosSegundos(Date data){
		SimpleDateFormat fm = new SimpleDateFormat("HH:mm:ss");
		return fm.format(data);
	}
	public String formataApenasData(Date data){
		SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
		return fm.format(data);
	}


}
