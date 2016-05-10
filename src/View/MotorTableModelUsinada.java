package View;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Entity.Usinada;
import Entity.pontoDeLeitura;

public class MotorTableModelUsinada extends AbstractTableModel {

	private List<Usinada> linhas;
	private String[] colunas = new String[]{
		"Codigo","Status"};

	public MotorTableModelUsinada() {
		linhas = new ArrayList<Usinada>();
		
	}

	public MotorTableModelUsinada(List<Usinada> lista) {
		linhas = new ArrayList<Usinada>(lista);
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return linhas.size();
	}

	@Override
	public String getColumnName(int columnIndex) {

		return colunas[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {

		case 0:
			return String.class;
		case 1:
			return String.class;
		default:

			return null;
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public Usinada getLinha(int indiceLinha) {
		if (indiceLinha < linhas.size()) {
			return linhas.get(indiceLinha);
		}
		return null;
	}

	public void addDados(Usinada func) {
		linhas.add(func);

		int ultimoIndice = getRowCount() - 1;

		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}

	public void removeDados(int indiceLinha) {
		if (indiceLinha < linhas.size()) {
			linhas.remove(indiceLinha);
			fireTableRowsDeleted(indiceLinha, indiceLinha);
		}

	}

	public void addListaDePostos(List<Usinada> funcs) {
		int tamanhoAntigo = getRowCount();

		linhas.addAll(funcs);

		fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
	}

	public void limpar() {
		linhas.clear();
		fireTableDataChanged();
	}

	public boolean isEmpty() {
		return linhas.isEmpty();
	}

	public Object getObject(int index) {
		return linhas.get(index);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Usinada dados = new Usinada();
		dados=linhas.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return dados.getCodigo();
		case 1:
			return dados.getStatus();
//		case 2:
//			return dados.isMotorPressaoSkidA();
//		case 3:
//			return dados.isMotorPressaoSkidB();
//		case 4:
//			return dados.isMotorTransferenciaSkidA();
//		case 5:
//			return dados.isMotorTransferenciaSkidB();
//		case 6:
//			return dados.isMotorVacuo();
//		case 7:
//			return dados.isPortaUsina();
		default:
			return null;
			
		}
	}

}