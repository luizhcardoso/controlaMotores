package Controler;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Entity.pontoDeLeitura;

public class controlaUsinada {

	public pontoDeLeitura getAberturaDePorta() {
		return AberturaDePorta;
	}

	public void setAberturaDePorta(pontoDeLeitura aberturaDePorta) {
		AberturaDePorta = aberturaDePorta;
	}

	public pontoDeLeitura getVacuoInicial() {
		return vacuoInicial;
	}

	public void setVacuoInicial(pontoDeLeitura vacuoInicial) {
		this.vacuoInicial = vacuoInicial;
	}

	public pontoDeLeitura getEnchimento() {
		return enchimento;
	}

	public void setEnchimento(pontoDeLeitura enchimento) {
		this.enchimento = enchimento;
	}

	public pontoDeLeitura getPressao() {
		return pressao;
	}

	public void setPressao(pontoDeLeitura pressao) {
		this.pressao = pressao;
	}

	public pontoDeLeitura getRetorno() {
		return retorno;
	}

	public void setRetorno(pontoDeLeitura retorno) {
		this.retorno = retorno;
	}

	public pontoDeLeitura getVacuoFinal() {
		return vacuoFinal;
	}

	public void setVacuoFinal(pontoDeLeitura vacuoFinal) {
		this.vacuoFinal = vacuoFinal;
	}

	public pontoDeLeitura getFechamentoDeporta() {
		return FechamentoDeporta;
	}

	public void setFechamentoDeporta(pontoDeLeitura fechamentoDeporta) {
		FechamentoDeporta = fechamentoDeporta;
	}


	private pontoDeLeitura AberturaDePorta;
	private pontoDeLeitura vacuoInicial;
	private pontoDeLeitura enchimento;
	private pontoDeLeitura pressao;
	private pontoDeLeitura retorno;
	private pontoDeLeitura vacuoFinal;
	private pontoDeLeitura FechamentoDeporta;
	private List<pontoDeLeitura> delay;

	public String verificaProcessosUsinada(pontoDeLeitura ponto){
		delay =new ArrayList<>();
		
		//verifica fecha porta

			if(		FechamentoDeporta==null && 
				ponto.isMotorPressaoSkidA()==false &&
				ponto.isMotorPressaoSkidB()==false &&
				ponto.isMotorTransferenciaSkidA()==false &&
				ponto.isMotorTransferenciaSkidB()==false &&
				ponto.isMotorVacuo()==false &&
				ponto.isPortaUsina()==false){
			FechamentoDeporta=ponto;
			return "FechamentoDeporta";
		}else{//verifica delay
			if(		FechamentoDeporta!=null &&
					ponto.isMotorPressaoSkidA()==false &&
					ponto.isMotorPressaoSkidB()==false &&
					ponto.isMotorTransferenciaSkidA()==false &&
					ponto.isMotorTransferenciaSkidB()==false &&
					ponto.isMotorVacuo()==false &&
					ponto.isPortaUsina()==false){

				delay.add(ponto);
				return "delay";
			}else{
				//verifica vacuoInicial
				if(		vacuoInicial==null && 
						ponto.isMotorPressaoSkidA()==false &&
						ponto.isMotorPressaoSkidB()==false &&
						ponto.isMotorTransferenciaSkidA()==false &&
						ponto.isMotorTransferenciaSkidB()==false &&
						ponto.isMotorVacuo()==true &&
						ponto.isPortaUsina()==false){
					vacuoInicial=ponto;
					return "vacuoInicial";
				}else{
					//verifica Enchimento
					if(		enchimento==null && ponto.isMotorPressaoSkidA()==false &&
							ponto.isMotorPressaoSkidB()==false &&
							ponto.isMotorTransferenciaSkidA()==true ||
							ponto.isMotorTransferenciaSkidB()==true &&
							ponto.isMotorVacuo()==false &&
							ponto.isPortaUsina()==false){
						enchimento=ponto;
						return "enchimento";
					}else{

						//verifica pressao
						if(		ponto.isMotorPressaoSkidA()==true ||
								ponto.isMotorPressaoSkidB()==true &&
								ponto.isMotorTransferenciaSkidA()==false &&
								ponto.isMotorTransferenciaSkidB()==false &&
								ponto.isMotorVacuo()==false &&
								ponto.isPortaUsina()==false){
							pressao=ponto;
							return "pressao";
						}else{
							//verifica retorno
							if(		enchimento!=null && ponto.isMotorPressaoSkidA()==false &&
									ponto.isMotorPressaoSkidB()==false &&
									ponto.isMotorTransferenciaSkidA()==true ||
									ponto.isMotorTransferenciaSkidB()==true &&
									ponto.isMotorVacuo()==false &&
									ponto.isPortaUsina()==false){
								retorno=ponto;
								return "retorno";
							}else{
								//verifica vacuoFinal
								if(		vacuoInicial!=null &&
										ponto.isMotorPressaoSkidA()==false &&
										ponto.isMotorPressaoSkidB()==false &&
										ponto.isMotorTransferenciaSkidA()==false &&
										ponto.isMotorTransferenciaSkidB()==false &&
										ponto.isMotorVacuo()==true &&
										ponto.isPortaUsina()==false){
									vacuoFinal=ponto;
									return "vacuoFinal";
									}else{
										//verifica AberturaDePorta
										if(		ponto.isMotorPressaoSkidA()==false &&
												ponto.isMotorPressaoSkidB()==false &&
												ponto.isMotorTransferenciaSkidA()==false &&
												ponto.isMotorTransferenciaSkidB()==false &&
												ponto.isMotorVacuo()==false &&
												ponto.isPortaUsina()==true){

											AberturaDePorta=ponto;
											return"AberturaDePorta";
										}else{
											delay.add(ponto);
											return "null";
										}}
									}
							}
						}
					}
				}
			}
		}	
		
		
		

	
	
	public Date calculaDiferencaDeHoras(Date data1,Date data2){
		Date txt=null; 
		DateFormat somaDiferenca =null;
		try{
			      // constr�i a primeira data
			      // vamos obter a diferen�a em semanas, dias, horas,
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
		SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		 return fm.format(data);
	}
	public String formataHoraMinutosSegundos(Date data){
		SimpleDateFormat fm = new SimpleDateFormat("HH:mm:ss");
		 return fm.format(data);
	}
	
	public List<pontoDeLeitura> retornaListaDeLeituras(){
		List<pontoDeLeitura> lista=new ArrayList<>();
		
		lista.add(getFechamentoDeporta());
		lista.add(getVacuoInicial());
		lista.add(getEnchimento());
		lista.add(getPressao());
		lista.add(getRetorno());
		lista.add(getVacuoFinal());
		lista.add(getAberturaDePorta());
		for (pontoDeLeitura a : delay) {
			lista.add(a);
		}
		
		return lista;
	}
	
}
