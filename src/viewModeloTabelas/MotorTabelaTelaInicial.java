package viewModeloTabelas;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import Controler.controlaUsinada;
import Entity.pontoDeLeitura;

public class MotorTabelaTelaInicial extends AbstractTableModel {

	private List<pontoDeLeitura> linhas;
	private String[] colunas = new String[]{
			"Codigo","Descricao","Horario Inicial","Duracao"};
	public MotorTabelaTelaInicial() {
		linhas = new ArrayList<pontoDeLeitura>();
		
	}

	public MotorTabelaTelaInicial(List<pontoDeLeitura> lista) {
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
		controlaUsinada controle=new controlaUsinada();
		pontoDeLeitura dados = new pontoDeLeitura();
		dados=linhas.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return dados.getCodigo();
		case 1:
			return dados.getStatus();
		case 2:
			return controle.formataData(dados.getData());
		case 3:
			if(rowIndex!=(linhas.size()-1)){
				
				return controle.formataHoraMinutosSegundos((controle.calculaDiferencaDeHoras(linhas.get(rowIndex).getData(), linhas.get(rowIndex+1).getData())));
				
			}else{
				return "~"+controle.formataHoraMinutosSegundos((
						controle.calculaDiferencaDeHoras(
								linhas.get(rowIndex).getData(),new Date())))+"~";
			}
		default:
			return null;
			
		}
	}

	

}