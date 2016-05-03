package Controler;

import java.util.ArrayList;
import java.util.List;

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
}
