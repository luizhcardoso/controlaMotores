package View;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Panel;
import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.border.EmptyBorder;
import Entity.pontoDeLeitura;
import viewModeloTabelas.MotorTabelaTelaInicial;
import viewModeloTabelas.renderTable;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.TitledBorder;

import BancoDeDados.DaoPontoLeitura;
import Controler.controlaUsinada;

import java.awt.Point;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaPrincipalMonitora2 extends JFrame{

	/**
	 * Launch the application.
	 */
	public TelaPrincipalMonitora2() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setTitle("Monitora Motores");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipalMonitora2.class.getResource("/IMG/MOTOR_LIGADO.png")));
		setBounds(0, 0, 1436, 771);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		setVisible(true);
		
		
		Panel panel = new Panel();
		panel.setBackground(Color.LIGHT_GRAY);
		
		
		getContentPane().add(panel);
		panel.setLayout(null);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1414, 31);
		panel.add(menuBar);
		
		JMenu mnRelatrios = new JMenu("Relat\u00F3rios");
		menuBar.add(mnRelatrios);
		
		JMenuItem mntmRelattioLeiturasData = new JMenuItem("Relat\u00F3tio Leituras Data");
		mntmRelattioLeiturasData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
			telaHistorico= new Historico();
			telaHistorico.setVisible(true);
			
				
			}
		});
		mnRelatrios.add(mntmRelattioLeiturasData);
		
		JMenuItem mntmRelatorioUsinada = new JMenuItem("Relatorio Usinada");
		mntmRelatorioUsinada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				telaUsinada=new RelatorioDeUsinada();
				telaUsinada.setVisible(true);
			}
		});
		mnRelatrios.add(mntmRelatorioUsinada);
		
		lblNewLabel_1 = new JLabel("Tranferencia Motor A");
		lblNewLabel_1.setEnabled(false);
		lblNewLabel_1.setFont(new Font("Malgun Gothic", Font.BOLD, 18));
		lblNewLabel_1.setIconTextGap(17);
		lblNewLabel_1.setBounds(65, 99, 188, 20);
		panel.add(lblNewLabel_1);
		
		label = new JLabel("New label");
		label.setEnabled(false);
		label.setIcon(new ImageIcon(TelaPrincipalMonitora2.class.getResource("/IMG/MOTOR_DESLIGADO.png")));
		label.setBounds(13, 89, 47, 44);
		panel.add(label);
		
		lblTranferenciaMotorB = new JLabel("Tranferencia Motor B");
		lblTranferenciaMotorB.setEnabled(false);
		lblTranferenciaMotorB.setFont(new Font("Malgun Gothic", Font.BOLD, 18));
		lblTranferenciaMotorB.setIconTextGap(17);
		lblTranferenciaMotorB.setBounds(65, 55, 188, 20);
		panel.add(lblTranferenciaMotorB);
		
		label_2 = new JLabel("New label");
		label_2.setEnabled(false);
		label_2.setIcon(new ImageIcon(TelaPrincipalMonitora2.class.getResource("/IMG/MOTOR_DESLIGADO.png")));
		label_2.setBounds(13, 45, 47, 44);
		panel.add(label_2);
		
		 lblMotorpressaoA_1 = new JLabel("Motor Pressao A");
		 lblMotorpressaoA_1.setEnabled(false);
		 lblMotorpressaoA_1.setFont(new Font("Malgun Gothic", Font.BOLD, 18));
		 lblMotorpressaoA_1.setIconTextGap(17);
		lblMotorpressaoA_1.setBounds(707, 135, 213, 20);
		panel.add(lblMotorpressaoA_1);
		
		 label_3 = new JLabel("New label");
		 label_3.setVerticalAlignment(SwingConstants.TOP);
		 label_3.setEnabled(false);
		label_3.setIcon(new ImageIcon(TelaPrincipalMonitora2.class.getResource("/IMG/MOTOR_DESLIGADO.png")));
		label_3.setBounds(655, 125, 47, 44);
		panel.add(label_3);
		
		 lblMotorpressaoA = new JLabel("Motor Pressao B");
		 lblMotorpressaoA.setEnabled(false);
		 lblMotorpressaoA.setFont(new Font("Malgun Gothic", Font.BOLD, 18));
		 lblMotorpressaoA.setIconTextGap(17);
		lblMotorpressaoA.setBounds(707, 92, 207, 20);
		panel.add(lblMotorpressaoA);
		
		 label_5 = new JLabel("New label");
		 label_5.setEnabled(false);
		label_5.setIcon(new ImageIcon(TelaPrincipalMonitora2.class.getResource("/IMG/MOTOR_DESLIGADO.png")));
		label_5.setBounds(655, 79, 47, 44);
		panel.add(label_5);
		
		 lblMotorVacuo = new JLabel("Motor Vacuo");
		 lblMotorVacuo.setEnabled(false);
		 lblMotorVacuo.setFont(new Font("Malgun Gothic", Font.BOLD, 18));
		 lblMotorVacuo.setIconTextGap(17);
		lblMotorVacuo.setBackground(SystemColor.inactiveCaptionBorder);
		lblMotorVacuo.setBounds(136, 523, 202, 20);
		panel.add(lblMotorVacuo);
		
		 label_7 = new JLabel("New label");
		 label_7.setEnabled(false);
		label_7.setIcon(new ImageIcon(TelaPrincipalMonitora2.class.getResource("/IMG/MOTOR_DESLIGADO.png")));
		label_7.setBounds(87, 513, 47, 44);
		panel.add(label_7);
		
		 lblEstadoDaPorta = new JLabel("Porta Fechada");
		 lblEstadoDaPorta.setEnabled(false);
		 lblEstadoDaPorta.setFont(new Font("Malgun Gothic", Font.BOLD, 18));
		 lblEstadoDaPorta.setIconTextGap(17);
		lblEstadoDaPorta.setBackground(Color.WHITE);
		lblEstadoDaPorta.setBounds(782, 221, 167, 20);
		panel.add(lblEstadoDaPorta);
		
		 label_13 = new JLabel("New label");
		 label_13.setEnabled(true);
		label_13.setBackground(Color.WHITE);
		label_13.setIcon(new ImageIcon(TelaPrincipalMonitora2.class.getResource("/IMG/PORTA_ABERTA.png")));
		label_13.setBounds(733, 212, 47, 44);
		panel.add(label_13);
		
		 lblArduino = new JLabel("Arduino: ");
		lblArduino.setBounds(829, 49, 69, 20);
		panel.add(lblArduino);
		
		 lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaPrincipalMonitora2.class.getResource("/IMG/on.png")));
		lblNewLabel.setBounds(913, 30, 36, 48);
		panel.add(lblNewLabel);
		
		lblUltimaLeituraGravada = new JLabel("Ultima Leitura Gravada:");
		lblUltimaLeituraGravada.setPreferredSize(new Dimension(30, 40));
		lblUltimaLeituraGravada.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblUltimaLeituraGravada.setBounds(13, 686, 343, 20);
		panel.add(lblUltimaLeituraGravada);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(0, 30, 949, 683);
		panel.add(label_4);
		label_4.setIcon(new ImageIcon("C:\\Users\\LUIZAO\\workspace\\MonitoraMotores\\resources\\IMG\\usina.png"));
		
		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(961, -3, -10, 676);
		panel.add(separator);
		
		scrollPane = new JScrollPane();
		panel.add(scrollPane);
		scrollPane.setBounds(950, 30, 466, 683);
		
		
		table = new JTable();
		table.setDefaultRenderer(Object.class, new renderTable());
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    
		MotorTabelaTelaInicial tableModel=new MotorTabelaTelaInicial(new DaoPontoLeitura().retornaPaginacao(40));
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(130);
		
		scrollPane.setViewportView(table);
		
		panel.add(scrollPane);
		
	}
	
	
	public void verificaEstado(pontoDeLeitura ponto){
		if(ponto.isMotorPressaoSkidA()){
			label_3.setIcon(new ImageIcon(TelaPrincipalMonitora2.class.getResource("/IMG/MOTOR_LIGADO.png")));
			label_3.setEnabled(true);
			label_3.repaint();
			lblMotorpressaoA_1.setEnabled(true);
			lblMotorpressaoA_1.setText("Motor Pressao A - LIGADO");
			lblMotorpressaoA_1.repaint();
		}else{
			label_3.setIcon(new ImageIcon(TelaPrincipalMonitora2.class.getResource("/IMG/MOTOR_DESLIGADO.png")));
			label_3.setEnabled(false);
			label_3.repaint();
			lblMotorpressaoA_1.setEnabled(false);
			lblMotorpressaoA_1.setText("Motor Pressao A - DESLIGADO");
			lblMotorpressaoA_1.repaint();
		}
		if(ponto.isMotorPressaoSkidB()){
			label_5.setIcon(new ImageIcon(TelaPrincipalMonitora2.class.getResource("/IMG/MOTOR_LIGADO.png")));
			label_5.setEnabled(true);
			label_5.repaint();
			lblMotorpressaoA.setEnabled(true);
			lblMotorpressaoA.setText("Motor Pressao B - LIGADO");
			lblMotorpressaoA.repaint();
		}else{
			label_5.setIcon(new ImageIcon(TelaPrincipalMonitora2.class.getResource("/IMG/MOTOR_DESLIGADO.png")));
			label_5.setEnabled(false);
			label_5.repaint();
			lblMotorpressaoA.setEnabled(false);
			lblMotorpressaoA.setText("Motor Pressao B - DESLIGADO");
			lblMotorpressaoA.repaint();
		}
		
		if(ponto.isMotorTransferenciaSkidA()){
			label.setIcon(new ImageIcon(TelaPrincipalMonitora2.class.getResource("/IMG/MOTOR_LIGADO.png")));
			lblNewLabel_1.setText("Motor Transferencia A - LIGADO");
			label.setEnabled(true);
			label.repaint();
			lblNewLabel_1.setEnabled(true);
		}else{
			label.setIcon(new ImageIcon(TelaPrincipalMonitora2.class.getResource("/IMG/MOTOR_DESLIGADO.png")));
			label.setEnabled(false);
			label.repaint();
			lblNewLabel_1.setEnabled(false);
			lblNewLabel_1.setText("Motor Transferencia A - DESLIGADO");
		}
		if(ponto.isMotorTransferenciaSkidB()){
			label_2.setIcon(new ImageIcon(TelaPrincipalMonitora2.class.getResource("/IMG/MOTOR_LIGADO.png")));
			label_2.setText("Motor Transferencia B LIGADO");
			label_2.setEnabled(true);
			label_2.repaint();
			lblTranferenciaMotorB.setEnabled(true);
		}else{
			label_2.setIcon(new ImageIcon(TelaPrincipalMonitora2.class.getResource("/IMG/MOTOR_DESLIGADO.png")));
			label_2.setEnabled(false);
			label_2.repaint();
			lblTranferenciaMotorB.setEnabled(false);
			lblTranferenciaMotorB.setText("Motor Transferencia B DESLIGADO");
			lblTranferenciaMotorB.repaint();
		}
		if(ponto.isMotorVacuo()){
			label_7.setIcon(new ImageIcon(TelaPrincipalMonitora2.class.getResource("/IMG/MOTOR_LIGADO.png")));
			label_7.setEnabled(true);
			label_7.repaint();
			lblMotorVacuo.setText("Motor Vacuo LIGADO");
			lblMotorVacuo.setEnabled(true);
			lblMotorVacuo.repaint();
		}else{
			label_7.setIcon(new ImageIcon(TelaPrincipalMonitora2.class.getResource("/IMG/MOTOR_DESLIGADO.png")));
			label_7.setEnabled(false);
			label_7.repaint();
			lblMotorVacuo.setText("Motor Vacuo DESLIGADO");
			lblMotorVacuo.setEnabled(false);
			lblMotorVacuo.repaint();
		}
		if(ponto.isPortaUsina()){
			
			label_13.setIcon(new ImageIcon(TelaPrincipalMonitora2.class.getResource("/IMG/PORTA_ABERTA.png")));
			label_13.setEnabled(true);
			label_13.repaint();
			lblEstadoDaPorta.setText("PORTA_ABERTA");
			lblEstadoDaPorta.setEnabled(true);
			lblEstadoDaPorta.repaint();
			
		}else{
			label_13.setIcon(new ImageIcon(TelaPrincipalMonitora2.class.getResource("/IMG/PORTA_FECHADA.png")));
			lblEstadoDaPorta.setText("PORTA_FECHADA");
			label_13.repaint();
			label_13.setEnabled(true);
			lblEstadoDaPorta.setEnabled(true);
			lblEstadoDaPorta.repaint();
					
		
		}
		lblUltimaLeituraGravada.setText("Ultima Leitura Gravada : "+ new controlaUsinada().formataData(ponto.getData()));
		lblUltimaLeituraGravada.repaint();
		
	}
	private JLabel lblNewLabel_1;
	private JLabel label;
	private JLabel lblTranferenciaMotorB;
	private JLabel label_2 ;
	private JLabel lblMotorpressaoA_1;
	private JLabel label_3 ;
	private JLabel lblMotorpressaoA;
	private JLabel label_5;
	private JLabel lblMotorVacuo;
	private JLabel label_13;
	private JLabel label_7;
	private JLabel lblEstadoDaPorta;
	private JLabel lblArduino;
	private JLabel lblNewLabel;
	private JLabel lblUltimaLeituraGravada;
	private Historico telaHistorico;	
	private RelatorioDeUsinada telaUsinada;
	private JSeparator separator;
	private JTable table;
	JScrollPane scrollPane;
	public void atualizaTabeleBanco(){
		DaoPontoLeitura dao=new DaoPontoLeitura();
		table.removeAll();
		MotorTabelaTelaInicial modelo=new MotorTabelaTelaInicial(
				dao.readAll());
		table.setModel(modelo);
		JScrollBar bar = scrollPane.getVerticalScrollBar();  
        bar.setValue(bar.getMaximum());  
	}
	public void atualizaTabelaPrinciapal(){
		DaoPontoLeitura dao=new DaoPontoLeitura();
		table.removeAll();
		MotorTabelaTelaInicial modelo=new MotorTabelaTelaInicial(
				dao.retornaPaginacao(40));
		table.setModel(modelo);
		JScrollBar bar = scrollPane.getVerticalScrollBar();  
        bar.setValue(bar.getMaximum());  
	}
}

