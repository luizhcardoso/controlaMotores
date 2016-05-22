package viewModeloTabelas;

	import java.awt.Color;  
	import java.awt.Component;  
	import javax.swing.JTable;  
	import javax.swing.table.DefaultTableCellRenderer;  

	  
	/** 
	 * @author Ronald Tetsuo Miura 
	 */  
	public class renderTable extends DefaultTableCellRenderer {  
	  
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	                 // Faz a verificação com o getValueAt()...
//	              comp.setBackground(getCor(row, isSelected));
	                          
	           
			
					
			return comp;
		}
		private Color getCor(int linha, boolean selecionada) {

            // linhas selecionadas são azuis
            if (selecionada) {
                return Color.getHSBColor(152, 251,152);
            }

            // linhas pares são amarelas e impares são verdes
            // isso vai criar um efeito zebrado
            if (linha % 2 == 0) {
            	return Color.getHSBColor(248, 248, 255);
            }
            return Color.getHSBColor(253, 245, 230);
        }
		
	}  

	
	
