package Controler;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.SocketMetadata;

import Entity.pontoDeLeitura;

public class controlaUsinada {

	private pontoDeLeitura AberturaDePorta;

	private pontoDeLeitura vacuoInicial;

	private pontoDeLeitura delay;

	private pontoDeLeitura enchimento;

	private pontoDeLeitura pressao;

	private pontoDeLeitura retorno;

	private pontoDeLeitura vacuoFinal;

	private pontoDeLeitura FechamentoDeporta;

	private String status;

	public String verificaProcessosUsinada(pontoDeLeitura ponto){
		//verifica fecha porta
		if(		FechamentoDeporta==null && 
				ponto.isMotorPressaoSkidA()==false &&
				ponto.isMotorPressaoSkidB()==false &&
				ponto.isMotorTransferenciaSkidA()==false &&
				ponto.isMotorTransferenciaSkidB()==false &&
				ponto.isMotorVacuo()==false &&
				ponto.isPortaUsina()==true){
			FechamentoDeporta=ponto;
			return "FechamentoDeporta";
		}else{//verifica delay
			if(		FechamentoDeporta!=null &&
					ponto.isMotorPressaoSkidA()==false &&
					ponto.isMotorPressaoSkidB()==false &&
					ponto.isMotorTransferenciaSkidA()==false &&
					ponto.isMotorTransferenciaSkidB()==false &&
					ponto.isMotorVacuo()==false &&
					ponto.isPortaUsina()==true){

				delay=ponto;
				return "delay";
			}else{
				//verifica vacuoInicial
				if(		vacuoInicial==null && 
						ponto.isMotorPressaoSkidA()==false &&
						ponto.isMotorPressaoSkidB()==false &&
						ponto.isMotorTransferenciaSkidA()==false &&
						ponto.isMotorTransferenciaSkidB()==false &&
						ponto.isMotorVacuo()==true &&
						ponto.isPortaUsina()==true){
					vacuoInicial=ponto;
					return "vacuoInicial";
				}else{
					//verifica Enchimento
					if(		enchimento==null && ponto.isMotorPressaoSkidA()==false &&
							ponto.isMotorPressaoSkidB()==false &&
							ponto.isMotorTransferenciaSkidA()==true ||
							ponto.isMotorTransferenciaSkidB()==true &&
							ponto.isMotorVacuo()==false &&
							ponto.isPortaUsina()==true){
						enchimento=ponto;
						return "enchimento";
					}else{

						//verifica pressao
						if(		ponto.isMotorPressaoSkidA()==true ||
								ponto.isMotorPressaoSkidB()==true &&
								ponto.isMotorTransferenciaSkidA()==false &&
								ponto.isMotorTransferenciaSkidB()==false &&
								ponto.isMotorVacuo()==false &&
								ponto.isPortaUsina()==true){
							pressao=ponto;
							return "pressao";
						}else{
							//verifica retorno
							if(		enchimento!=null && ponto.isMotorPressaoSkidA()==false &&
									ponto.isMotorPressaoSkidB()==false &&
									ponto.isMotorTransferenciaSkidA()==true ||
									ponto.isMotorTransferenciaSkidB()==true &&
									ponto.isMotorVacuo()==false &&
									ponto.isPortaUsina()==true){
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
										ponto.isPortaUsina()==true){
									vacuoInicial=ponto;
									return "vacuoInicial";
									}else{
										//verifica AberturaDePorta
										if(		ponto.isMotorPressaoSkidA()==false &&
												ponto.isMotorPressaoSkidB()==false &&
												ponto.isMotorTransferenciaSkidA()==false &&
												ponto.isMotorTransferenciaSkidB()==false &&
												ponto.isMotorVacuo()==false &&
												ponto.isPortaUsina()==false){

											AberturaDePorta=ponto;
											return"(AberturaDePorta)";
										}else{
											return "null";
										}
									}
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
		SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		 return fm.format(data);
	}
	public String formataHoraMinutosSegundos(Date data){
		SimpleDateFormat fm = new SimpleDateFormat("HH:mm:ss");
		 return fm.format(data);
	}
	
	
	
}
