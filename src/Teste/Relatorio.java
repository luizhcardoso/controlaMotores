/*
 * Created by JFormDesigner on Wed Apr 27 18:35:39 BRT 2016
 */

package Teste;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import BancoDeDados.DaoPontoLeitura;
import viewModeloTabelas.MotorTableModelPontoDeLeitura;


/**
 * @author luiz  henirique manica cardoso
 */
public class Relatorio extends JFrame {
	
	public DaoPontoLeitura daoPontoLeitura;
	public Relatorio() {
		MotorTableModelPontoDeLeitura table=new MotorTableModelPontoDeLeitura(new DaoPontoLeitura().readAll());
		initComponents();
		table1.setModel((table));
		repaint();
	}

	private void button1MouseReleased(MouseEvent e) {
		daoPontoLeitura=new DaoPontoLeitura();
		table1.removeAll();
		table1.setModel(new MotorTableModelPontoDeLeitura(
				daoPontoLeitura.retornaIntervaloDeData(textField1.getText(), textField2.getText())));
		
		
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - luiz  henirique manica cardoso
		panel1 = new JPanel();
		scrollPane1 = new JScrollPane();
		table1 = new JTable();
		panel2 = new JPanel();
		label1 = new JLabel();
		textField1 = new JTextField();
		label2 = new JLabel();
		textField2 = new JTextField();
		button1 = new JButton();

		//======== this ========
		setTitle("Relatorio de Registros");
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//======== panel1 ========
		{

			// JFormDesigner evaluation mark
			panel1.setBorder(new javax.swing.border.CompoundBorder(
				new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
					"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
					javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
					java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

			panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));

			//======== scrollPane1 ========
			{
				scrollPane1.setViewportView(table1);
			}
			panel1.add(scrollPane1);
		}
		contentPane.add(panel1, BorderLayout.CENTER);

		//======== panel2 ========
		{
			panel2.setLayout(new GridLayout());

			//---- label1 ----
			label1.setText("Data Inicial");
			panel2.add(label1);

			//---- textField1 ----
			textField1.setColumns(15);
			textField1.setText("\"dd/MM/yyyy hh:mm:ss\"");
			panel2.add(textField1);

			//---- label2 ----
			label2.setText("Data Final");
			panel2.add(label2);

			//---- textField2 ----
			textField2.setColumns(15);
			textField2.setText("\"dd/MM/yyyy hh:mm:ss\"");
			panel2.add(textField2);

			//---- button1 ----
			button1.setText("Buscar");
			button1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					button1MouseReleased(e);
				}
			});
			panel2.add(button1);
		}
		contentPane.add(panel2, BorderLayout.NORTH);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - luiz  henirique manica cardoso
	private JPanel panel1;
	private JScrollPane scrollPane1;
	private JTable table1;
	private JPanel panel2;
	private JLabel label1;
	private JTextField textField1;
	private JLabel label2;
	private JTextField textField2;
	private JButton button1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
