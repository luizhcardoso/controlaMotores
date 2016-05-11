package Teste;

import java.util.ArrayList;
import java.util.List;

import BancoDeDados.DaoUsinada;
import Controler.controlaUsinada;
import Entity.Usinada;
import Entity.pontoDeLeitura;

public class Teste2 {
	public static void main(String[] args) {
		controlaUsinada control=new controlaUsinada();
		System.out.println(control.calculaDiferencaDeHoras());
		
	}

}
