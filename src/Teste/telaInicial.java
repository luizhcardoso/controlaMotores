/*
 * Created by JFormDesigner on Tue Apr 19 00:13:39 BRT 2016
 */

package Teste;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Entity.pontoDeLeitura;
import info.clearthought.layout.*;

/**
 * @author luiz  henirique manica cardoso
 */
public class telaInicial extends JFrame {
	public telaInicial() {
		initComponents();
		
	}
	public telaInicial(pontoDeLeitura ponto) {
		initComponents();
		verificaEstado(ponto);
	}

	private void menuItem1MouseReleased(MouseEvent e) {
		JFrame frameRelatorio=new Relatorio();
		frameRelatorio.setSize(640, 480);
		frameRelatorio.setLocationRelativeTo(null);
		frameRelatorio.setVisible(true);
        
	}
	
	public void verificaEstado(pontoDeLeitura ponto){
		if(ponto.isMotorPressaoSkidA()){
			label3.setIcon(new ImageIcon("C:\\Users\\LUIZAO\\workspace\\MonitoraMotores\\resources\\img\\MOTOR_LIGADO.png"));
		}else{
			label3.setIcon(new ImageIcon("C:\\Users\\LUIZAO\\workspace\\MonitoraMotores\\resources\\img\\MOTOR_DESLIGADO.png"));
		}
		if(ponto.isMotorPressaoSkidB()){
			label4.setIcon(new ImageIcon("C:\\Users\\LUIZAO\\workspace\\MonitoraMotores\\resources\\img\\MOTOR_LIGADO.png"));
		}else{
			label4.setIcon(new ImageIcon("C:\\Users\\LUIZAO\\workspace\\MonitoraMotores\\resources\\img\\MOTOR_DESLIGADO.png"));
		}
		
		if(ponto.isMotorTransferenciaSkidA()){
			label6.setIcon(new ImageIcon("C:\\Users\\LUIZAO\\workspace\\MonitoraMotores\\resources\\img\\MOTOR_LIGADO.png"));
		}else{
			label6.setIcon(new ImageIcon("C:\\Users\\LUIZAO\\workspace\\MonitoraMotores\\resources\\img\\MOTOR_DESLIGADO.png"));
		}
		if(ponto.isMotorTransferenciaSkidB()){
			label8.setIcon(new ImageIcon("C:\\Users\\LUIZAO\\workspace\\MonitoraMotores\\resources\\img\\MOTOR_LIGADO.png"));
		}else{
			label8.setIcon(new ImageIcon("C:\\Users\\LUIZAO\\workspace\\MonitoraMotores\\resources\\img\\MOTOR_DESLIGADO.png"));
		}
		if(ponto.isMotorVacuo()){
			label10.setIcon(new ImageIcon("C:\\Users\\LUIZAO\\workspace\\MonitoraMotores\\resources\\img\\MOTOR_LIGADO.png"));
		}else{
			label10.setIcon(new ImageIcon("C:\\Users\\LUIZAO\\workspace\\MonitoraMotores\\resources\\img\\MOTOR_DESLIGADO.png"));
		}
		if(ponto.isPortaUsina()){
			label13.setIcon(new ImageIcon("C:\\Users\\LUIZAO\\workspace\\MonitoraMotores\\resources\\img\\PORTA_ABERTA.png"));
		}else{
			label13.setIcon(new ImageIcon("C:\\Users\\LUIZAO\\workspace\\MonitoraMotores\\resources\\img\\PORTA_FECHADA.png"));
		}
		label16.setText(ponto.getData().toString());
		repaint();
		
			
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - luiz  henirique manica cardoso
		menuBar1 = new JMenuBar();
		menu1 = new JMenu();
		menuItem1 = new JMenuItem();
		label1 = new JLabel();
		label3 = new JLabel();
		label2 = new JLabel();
		label4 = new JLabel();
		label5 = new JLabel();
		label6 = new JLabel();
		label9 = new JLabel();
		label8 = new JLabel();
		label11 = new JLabel();
		label10 = new JLabel();
		label12 = new JLabel();
		label13 = new JLabel();
		label14 = new JLabel();
		label15 = new JLabel();
		label7 = new JLabel();
		label16 = new JLabel();

		//======== this ========
		setTitle("Monitora Motores Tratasul");
		Container contentPane = getContentPane();
		contentPane.setLayout(new TableLayout(new double[][] {
			{TableLayout.FILL, TableLayout.FILL},
			{TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, 49, 53}}));

		//======== menuBar1 ========
		{

			//======== menu1 ========
			{
				menu1.setText("Menu");

				//---- menuItem1 ----
				menuItem1.setText("Hist\u00f3rico de Opera\u00e7\u00f5es");
				menuItem1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent e) {
						menuItem1MouseReleased(e);
					}
				});
				menu1.add(menuItem1);
			}
			menuBar1.add(menu1);
		}
		setJMenuBar(menuBar1);

		//---- label1 ----
		label1.setText("Estado Motor Pressao A");
		contentPane.add(label1, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//---- label3 ----
		label3.setIcon(new ImageIcon("C:\\Users\\LUIZAO\\workspace\\MonitoraMotores\\resources\\img\\MOTOR_DESLIGADO.png"));
		contentPane.add(label3, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.CENTER, TableLayoutConstraints.FULL));

		//---- label2 ----
		label2.setText("Estado Motor Pressao B");
		contentPane.add(label2, new TableLayoutConstraints(0, 1, 0, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//---- label4 ----
		label4.setIcon(new ImageIcon("C:\\Users\\LUIZAO\\workspace\\MonitoraMotores\\resources\\img\\MOTOR_DESLIGADO.png"));
		contentPane.add(label4, new TableLayoutConstraints(1, 1, 1, 1, TableLayoutConstraints.CENTER, TableLayoutConstraints.FULL));

		//---- label5 ----
		label5.setText("Estado Motor Transfer\u00eancia A");
		contentPane.add(label5, new TableLayoutConstraints(0, 2, 0, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//---- label6 ----
		label6.setIcon(new ImageIcon("C:\\Users\\LUIZAO\\workspace\\MonitoraMotores\\resources\\img\\MOTOR_DESLIGADO.png"));
		contentPane.add(label6, new TableLayoutConstraints(1, 2, 1, 2, TableLayoutConstraints.CENTER, TableLayoutConstraints.FULL));

		//---- label9 ----
		label9.setText("Estado Motor V\u00e1cuo");
		contentPane.add(label9, new TableLayoutConstraints(0, 3, 0, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//---- label8 ----
		label8.setIcon(new ImageIcon("C:\\Users\\LUIZAO\\workspace\\MonitoraMotores\\resources\\img\\MOTOR_DESLIGADO.png"));
		contentPane.add(label8, new TableLayoutConstraints(1, 3, 1, 3, TableLayoutConstraints.CENTER, TableLayoutConstraints.FULL));

		//---- label11 ----
		label11.setText("Estado Motor Transfer\u00eancia B");
		contentPane.add(label11, new TableLayoutConstraints(0, 4, 0, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//---- label10 ----
		label10.setIcon(new ImageIcon("C:\\Users\\LUIZAO\\workspace\\MonitoraMotores\\resources\\img\\MOTOR_DESLIGADO.png"));
		contentPane.add(label10, new TableLayoutConstraints(1, 4, 1, 4, TableLayoutConstraints.CENTER, TableLayoutConstraints.FULL));

		//---- label12 ----
		label12.setText("Estado Porta da Usina");
		contentPane.add(label12, new TableLayoutConstraints(0, 5, 0, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//---- label13 ----
		label13.setIcon(new ImageIcon("C:\\Users\\LUIZAO\\workspace\\MonitoraMotores\\resources\\IMG\\PORTA_FECHADA.png"));
		contentPane.add(label13, new TableLayoutConstraints(1, 5, 1, 5, TableLayoutConstraints.CENTER, TableLayoutConstraints.FULL));

		//---- label14 ----
		label14.setText("Leitura Arduino");
		contentPane.add(label14, new TableLayoutConstraints(0, 7, 0, 7, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//---- label15 ----
		label15.setIcon(new ImageIcon("C:\\Users\\LUIZAO\\workspace\\MonitoraMotores\\resources\\img\\on.png"));
		contentPane.add(label15, new TableLayoutConstraints(1, 7, 1, 7, TableLayoutConstraints.CENTER, TableLayoutConstraints.FULL));

		//---- label7 ----
		label7.setText("Ultima Leitura Banco:");
		contentPane.add(label7, new TableLayoutConstraints(0, 8, 0, 8, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
		contentPane.add(label16, new TableLayoutConstraints(1, 8, 1, 8, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - luiz  henirique manica cardoso
	private JMenuBar menuBar1;
	private JMenu menu1;
	private JMenuItem menuItem1;
	private JLabel label1;
	private JLabel label3;
	private JLabel label2;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label9;
	private JLabel label8;
	private JLabel label11;
	private JLabel label10;
	private JLabel label12;
	private JLabel label13;
	private JLabel label14;
	private JLabel label15;
	private JLabel label7;
	private JLabel label16;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
