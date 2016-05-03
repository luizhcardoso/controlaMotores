package View;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Entity.pontoDeLeitura;

public class MotorTableModel extends AbstractTableModel {

	private List<pontoDeLeitura> linhas;
	private String[] colunas = new String[]{
			"Codigo","Horario","Estado Motor1","Estado Motor2","Estado Motor3","Estado Motor4","Estado Motor5","Porta Usina"};


	public MotorTableModel() {
		linhas = new ArrayList<pontoDeLeitura>();
		
	}

	public MotorTableModel(List<pontoDeLeitura> lista) {
		linhas = new ArrayList<pontoDeLeitura>(lista);
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
		case 2:
			return String.class;
		case 3:
			return String.class;
		case 4:
			return String.class;
		case 5:
			return String.class;
		case 6:
			return String.class;
		case 7:
			return String.class;
		default:

			return null;
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public pontoDeLeitura getLinha(int indiceLinha) {
		if (indiceLinha < linhas.size()) {
			return linhas.get(indiceLinha);
		}
		return null;
	}

	public void addDados(pontoDeLeitura func) {
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

	public void addListaDePostos(List<pontoDeLeitura> funcs) {
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
		pontoDeLeitura dados = new pontoDeLeitura();
		dados=linhas.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return dados.getCodigo();
		case 1:
			return dados.getData();
		case 2:
			return dados.isMotorPressaoSkidA();
		case 3:
			return dados.isMotorPressaoSkidB();
		case 4:
			return dados.isMotorTransferenciaSkidA();
		case 5:
			return dados.isMotorTransferenciaSkidB();
		case 6:
			return dados.isMotorVacuo();
		case 7:
			return dados.isPortaUsina();
		default:
			return null;
			
		}
	}

}