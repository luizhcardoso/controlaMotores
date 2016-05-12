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
import Teste.telaInicial;

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
import javax.swing.border.TitledBorder;

import Controler.controlaUsinada;

import java.awt.Point;

public class TelaPrincipalMonitora extends JFrame{

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaPrincipalMonitora window = new TelaPrincipalMonitora();
//					window.frmMonitoraMotores.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the application.
//	 */
	public TelaPrincipalMonitora() {
		initialize();
		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setTitle("Monitora Motores");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipalMonitora.class.getResource("/IMG/MOTOR_LIGADO.png")));
		setBounds(0, 0, 1295, 1020);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		setVisible(true);
		
		
		Panel panel = new Panel();
		panel.setBackground(Color.LIGHT_GRAY);
		
		
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Tranferencia Motor A");
		lblNewLabel_1.setEnabled(false);
		lblNewLabel_1.setFont(new Font("Malgun Gothic", Font.BOLD, 18));
		lblNewLabel_1.setIconTextGap(17);
		lblNewLabel_1.setBounds(118, 152, 231, 20);
		panel.add(lblNewLabel_1);
		
		label = new JLabel("New label");
		label.setEnabled(false);
		label.setIcon(new ImageIcon(TelaPrincipalMonitora.class.getResource("/IMG/MOTOR_DESLIGADO.png")));
		label.setBounds(66, 140, 47, 44);
		panel.add(label);
		
		lblTranferenciaMotorB = new JLabel("Tranferencia Motor B");
		lblTranferenciaMotorB.setEnabled(false);
		lblTranferenciaMotorB.setFont(new Font("Malgun Gothic", Font.BOLD, 18));
		lblTranferenciaMotorB.setIconTextGap(17);
		lblTranferenciaMotorB.setBounds(118, 104, 231, 20);
		panel.add(lblTranferenciaMotorB);
		
		label_2 = new JLabel("New label");
		label_2.setEnabled(false);
		label_2.setIcon(new ImageIcon(TelaPrincipalMonitora.class.getResource("/IMG/MOTOR_DESLIGADO.png")));
		label_2.setBounds(66, 95, 47, 44);
		panel.add(label_2);
		
		 lblMotorpressaoA_1 = new JLabel("Motor Pressao A");
		 lblMotorpressaoA_1.setEnabled(false);
		 lblMotorpressaoA_1.setFont(new Font("Malgun Gothic", Font.BOLD, 18));
		 lblMotorpressaoA_1.setIconTextGap(17);
		lblMotorpressaoA_1.setBounds(895, 197, 256, 20);
		panel.add(lblMotorpressaoA_1);
		
		 label_3 = new JLabel("New label");
		 label_3.setEnabled(false);
		label_3.setIcon(new ImageIcon(TelaPrincipalMonitora.class.getResource("/IMG/MOTOR_DESLIGADO.png")));
		label_3.setBounds(843, 185, 47, 44);
		panel.add(label_3);
		
		 lblMotorpressaoA = new JLabel("Motor Pressao B");
		 lblMotorpressaoA.setEnabled(false);
		 lblMotorpressaoA.setFont(new Font("Malgun Gothic", Font.BOLD, 18));
		 lblMotorpressaoA.setIconTextGap(17);
		lblMotorpressaoA.setBounds(895, 149, 256, 20);
		panel.add(lblMotorpressaoA);
		
		 label_5 = new JLabel("New label");
		 label_5.setEnabled(false);
		label_5.setIcon(new ImageIcon(TelaPrincipalMonitora.class.getResource("/IMG/MOTOR_DESLIGADO.png")));
		label_5.setBounds(843, 137, 47, 44);
		panel.add(label_5);
		
		 lblMotorVacuo = new JLabel("Motor Vacuo");
		 lblMotorVacuo.setEnabled(false);
		 lblMotorVacuo.setFont(new Font("Malgun Gothic", Font.BOLD, 18));
		 lblMotorVacuo.setIconTextGap(17);
		lblMotorVacuo.setBackground(SystemColor.inactiveCaptionBorder);
		lblMotorVacuo.setBounds(206, 677, 202, 20);
		panel.add(lblMotorVacuo);
		
		 label_7 = new JLabel("New label");
		 label_7.setEnabled(false);
		label_7.setIcon(new ImageIcon(TelaPrincipalMonitora.class.getResource("/IMG/MOTOR_DESLIGADO.png")));
		label_7.setBounds(151, 668, 47, 44);
		panel.add(label_7);
		
		 lblEstadoDaPorta = new JLabel("Porta Fechada");
		 lblEstadoDaPorta.setEnabled(false);
		 lblEstadoDaPorta.setFont(new Font("Malgun Gothic", Font.BOLD, 18));
		 lblEstadoDaPorta.setIconTextGap(17);
		lblEstadoDaPorta.setBackground(Color.WHITE);
		lblEstadoDaPorta.setBounds(984, 304, 207, 20);
		panel.add(lblEstadoDaPorta);
		
		 label_13 = new JLabel("New label");
		 label_13.setEnabled(true);
		label_13.setBackground(Color.WHITE);
		label_13.setIcon(new ImageIcon(TelaPrincipalMonitora.class.getResource("/IMG/PORTA_ABERTA.png")));
		label_13.setBounds(935, 295, 47, 44);
		panel.add(label_13);
		
		 lblArduino = new JLabel("Arduino: ");
		lblArduino.setBounds(1085, 27, 69, 20);
		panel.add(lblArduino);
		
		 lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaPrincipalMonitora.class.getResource("/IMG/on.png")));
		lblNewLabel.setBounds(1155, 16, 36, 48);
		panel.add(lblNewLabel);
		
		lblUltimaLeituraGravada = new JLabel("Ultima Leitura Gravada:");
		lblUltimaLeituraGravada.setPreferredSize(new Dimension(30, 40));
		lblUltimaLeituraGravada.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblUltimaLeituraGravada.setBounds(32, 27, 343, 20);
		panel.add(lblUltimaLeituraGravada);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(32, 65, 1179, 850);
		panel.add(label_4);
		label_4.setIcon(new ImageIcon((TelaPrincipalMonitora.class.getResource("/IMG/usina2.png"))));
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
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
		
	}
	
	
	public void verificaEstado(pontoDeLeitura ponto){
		if(ponto.isMotorPressaoSkidA()){
			label_3.setIcon(new ImageIcon(TelaPrincipalMonitora.class.getResource("/IMG/MOTOR_LIGADO.png")));
			label_3.setEnabled(true);
			label_3.repaint();
			lblMotorpressaoA_1.setEnabled(true);
			lblMotorpressaoA_1.setText("Motor Pressao A - LIGADO");
			lblMotorpressaoA_1.repaint();
		}else{
			label_3.setIcon(new ImageIcon(TelaPrincipalMonitora.class.getResource("/IMG/MOTOR_DESLIGADO.png")));
			label_3.setEnabled(false);
			label_3.repaint();
			lblMotorpressaoA_1.setEnabled(false);
			lblMotorpressaoA_1.setText("Motor Pressao A - DESLIGADO");
			lblMotorpressaoA_1.repaint();
		}
		if(ponto.isMotorPressaoSkidB()){
			label_5.setIcon(new ImageIcon(TelaPrincipalMonitora.class.getResource("/IMG/MOTOR_LIGADO.png")));
			label_5.setEnabled(true);
			label_5.repaint();
			lblMotorpressaoA.setEnabled(true);
			lblMotorpressaoA.setText("Motor Pressao B - LIGADO");
			lblMotorpressaoA.repaint();
		}else{
			label_5.setIcon(new ImageIcon(TelaPrincipalMonitora.class.getResource("/IMG/MOTOR_DESLIGADO.png")));
			label_5.setEnabled(false);
			label_5.repaint();
			lblMotorpressaoA.setEnabled(false);
			lblMotorpressaoA.setText("Motor Pressao B - DESLIGADO");
			lblMotorpressaoA.repaint();
		}
		
		if(ponto.isMotorTransferenciaSkidA()){
			label.setIcon(new ImageIcon(TelaPrincipalMonitora.class.getResource("/IMG/MOTOR_LIGADO.png")));
			lblNewLabel_1.setText("Motor Transferencia A - LIGADO");
			label.setEnabled(true);
			label.repaint();
			lblNewLabel_1.setEnabled(true);
		}else{
			label.setIcon(new ImageIcon(TelaPrincipalMonitora.class.getResource("/IMG/MOTOR_DESLIGADO.png")));
			label.setEnabled(false);
			label.repaint();
			lblNewLabel_1.setEnabled(false);
			lblNewLabel_1.setText("Motor Transferencia A - DESLIGADO");
		}
		if(ponto.isMotorTransferenciaSkidB()){
			label_2.setIcon(new ImageIcon(TelaPrincipalMonitora.class.getResource("/IMG/MOTOR_LIGADO.png")));
			label_2.setText("Motor Transferencia B LIGADO");
			label_2.setEnabled(true);
			label_2.repaint();
			lblTranferenciaMotorB.setEnabled(true);
		}else{
			label_2.setIcon(new ImageIcon(TelaPrincipalMonitora.class.getResource("/IMG/MOTOR_DESLIGADO.png")));
			label_2.setEnabled(false);
			label_2.repaint();
			lblTranferenciaMotorB.setEnabled(false);
			lblTranferenciaMotorB.setText("Motor Transferencia B DESLIGADO");
			lblTranferenciaMotorB.repaint();
		}
		if(ponto.isMotorVacuo()){
			label_7.setIcon(new ImageIcon(TelaPrincipalMonitora.class.getResource("/IMG/MOTOR_LIGADO.png")));
			label_7.setEnabled(true);
			label_7.repaint();
			lblMotorVacuo.setText("Motor Vacuo LIGADO");
			lblMotorVacuo.setEnabled(true);
			lblMotorVacuo.repaint();
		}else{
			label_7.setIcon(new ImageIcon(TelaPrincipalMonitora.class.getResource("/IMG/MOTOR_DESLIGADO.png")));
			label_7.setEnabled(false);
			label_7.repaint();
			lblMotorVacuo.setText("Motor Vacuo DESLIGADO");
			lblMotorVacuo.setEnabled(false);
			lblMotorVacuo.repaint();
		}
		if(ponto.isPortaUsina()){
			
			label_13.setIcon(new ImageIcon(TelaPrincipalMonitora.class.getResource("/IMG/PORTA_ABERTA.png")));
			label_13.setEnabled(true);
			label_13.repaint();
			lblEstadoDaPorta.setText("PORTA_ABERTA");
			lblEstadoDaPorta.setEnabled(true);
			lblEstadoDaPorta.repaint();
		}else{
			label_13.setIcon(new ImageIcon(TelaPrincipalMonitora.class.getResource("/IMG/PORTA_FECHADA.png")));
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
	}

