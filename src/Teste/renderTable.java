package Teste;

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
	           if(row==0){
	        	   comp.setBackground(Color.green);
	                
	               
	           }
			
					
			return comp;
		}
	}  

	
	
