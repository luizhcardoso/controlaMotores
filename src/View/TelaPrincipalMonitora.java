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
import Telas.telaInicial;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	public TelaPrincipalMonitora(pontoDeLeitura ponto) {
		initialize();
		verificaEstado(ponto);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setTitle("Monitora Motores");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipalMonitora.class.getResource("/IMG/MOTOR_LIGADO.png")));
		setBounds(100, 100, 1234, 831);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		setVisible(true);
		
		
		Panel panel = new Panel();
		
		
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Tranferencia Motor A");
		lblNewLabel_1.setBounds(140, 156, 150, 20);
		panel.add(lblNewLabel_1);
		
		label = new JLabel("New label");
		label.setIcon(new ImageIcon("C:\\Users\\LUIZAO\\workspace\\MonitoraMotores\\resources\\IMG\\MOTOR_DESLIGADO.png"));
		label.setBounds(88, 144, 47, 44);
		panel.add(label);
		
		lblTranferenciaMotorB = new JLabel("Tranferencia Motor B");
		lblTranferenciaMotorB.setBounds(140, 108, 150, 20);
		panel.add(lblTranferenciaMotorB);
		
		label_2 = new JLabel("New label");
		label_2.setIcon(new ImageIcon("C:\\Users\\LUIZAO\\workspace\\MonitoraMotores\\resources\\IMG\\MOTOR_DESLIGADO.png"));
		label_2.setBounds(88, 96, 47, 44);
		panel.add(label_2);
		
		 lblMotorpressaoA_1 = new JLabel("Motor Pressao A");
		lblMotorpressaoA_1.setBounds(861, 207, 150, 20);
		panel.add(lblMotorpressaoA_1);
		
		 label_3 = new JLabel("New label");
		label_3.setIcon(new ImageIcon("C:\\Users\\LUIZAO\\workspace\\MonitoraMotores\\resources\\IMG\\MOTOR_DESLIGADO.png"));
		label_3.setBounds(809, 195, 47, 44);
		panel.add(label_3);
		
		 lblMotorpressaoA = new JLabel("Motor Pressao B");
		lblMotorpressaoA.setBounds(861, 159, 150, 20);
		panel.add(lblMotorpressaoA);
		
		 label_5 = new JLabel("New label");
		label_5.setIcon(new ImageIcon("C:\\Users\\LUIZAO\\workspace\\MonitoraMotores\\resources\\IMG\\MOTOR_DESLIGADO.png"));
		label_5.setBounds(809, 147, 47, 44);
		panel.add(label_5);
		
		 lblMotorVacuo = new JLabel("Motor Vacuo");
		lblMotorVacuo.setBackground(SystemColor.inactiveCaptionBorder);
		lblMotorVacuo.setBounds(206, 680, 150, 20);
		panel.add(lblMotorVacuo);
		
		 label_7 = new JLabel("New label");
		label_7.setIcon(new ImageIcon("C:\\Users\\LUIZAO\\workspace\\MonitoraMotores\\resources\\IMG\\MOTOR_DESLIGADO.png"));
		label_7.setBounds(157, 668, 47, 44);
		panel.add(label_7);
		
		 lblEstadoDaPorta = new JLabel("Porta Aberta");
		lblEstadoDaPorta.setBackground(Color.WHITE);
		lblEstadoDaPorta.setBounds(1020, 332, 150, 20);
		panel.add(lblEstadoDaPorta);
		
		 label_13 = new JLabel("New label");
		label_13.setBackground(Color.WHITE);
		label_13.setIcon(new ImageIcon(TelaPrincipalMonitora.class.getResource("/IMG/PORTA_ABERTA.png")));
		label_13.setBounds(963, 320, 47, 44);
		panel.add(label_13);
		
		 BackgraoundInicial = new JLabel("");
		BackgraoundInicial.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		BackgraoundInicial.setBounds(38, 96, 1159, 696);
		BackgraoundInicial.setBorder(new EmptyBorder(100, 0, 0, 0));
		BackgraoundInicial.setAlignmentX(Component.CENTER_ALIGNMENT);
		BackgraoundInicial.setIcon(new ImageIcon("C:\\Users\\LUIZAO\\workspace\\MonitoraMotores\\resources\\IMG\\usina2.png"));
		panel.add(BackgraoundInicial);
		
		 lblArduino = new JLabel("Arduino: ");
		lblArduino.setBounds(809, 27, 69, 20);
		panel.add(lblArduino);
		
		 lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaPrincipalMonitora.class.getResource("/IMG/on.png")));
		lblNewLabel.setBounds(879, 16, 36, 48);
		panel.add(lblNewLabel);
		
		 lblUltimaLeituraGravada = new JLabel("Ultima Leitura Gravada:");
		lblUltimaLeituraGravada.setBounds(809, 63, 173, 20);
		panel.add(lblUltimaLeituraGravada);
		
		 label_1 = new JLabel("...");
		label_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		label_1.setBounds(997, 63, 173, 20);
		panel.add(label_1);
		
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
		mnRelatrios.add(mntmRelatorioUsinada);
		
	}
	
	
	public void verificaEstado(pontoDeLeitura ponto){
		if(ponto.isMotorPressaoSkidA()){
			label_3.setIcon(new ImageIcon("C:\\Users\\LUIZAO\\workspace\\MonitoraMotores\\resources\\IMG\\MOTOR_LIGADO.png"));
		}else{
			label_3.setIcon(new ImageIcon("C:\\Users\\LUIZAO\\workspace\\MonitoraMotores\\resources\\IMG\\MOTOR_DESLIGADO.png"));
		}
		if(ponto.isMotorPressaoSkidB()){
			label_5.setIcon(new ImageIcon("C:\\Users\\LUIZAO\\workspace\\MonitoraMotores\\resources\\IMG\\MOTOR_LIGADO.png"));
		}else{
			label_5.setIcon(new ImageIcon("C:\\Users\\LUIZAO\\workspace\\MonitoraMotores\\resources\\IMG\\MOTOR_DESLIGADO.png"));
		}
		
		if(ponto.isMotorTransferenciaSkidA()){
			label.setIcon(new ImageIcon("C:\\Users\\LUIZAO\\workspace\\MonitoraMotores\\resources\\IMG\\MOTOR_LIGADO.png"));
		}else{
			label.setIcon(new ImageIcon("C:\\Users\\LUIZAO\\workspace\\MonitoraMotores\\resources\\IMG\\MOTOR_DESLIGADO.png"));
		}
		if(ponto.isMotorTransferenciaSkidB()){
			label_2.setIcon(new ImageIcon("C:\\Users\\LUIZAO\\workspace\\MonitoraMotores\\resources\\IMG\\MOTOR_LIGADO.png"));
		}else{
			label_2.setIcon(new ImageIcon("C:\\Users\\LUIZAO\\workspace\\MonitoraMotores\\resources\\IMG\\MOTOR_DESLIGADO.png"));
		}
		if(ponto.isMotorVacuo()){
			label_7.setIcon(new ImageIcon("C:\\Users\\LUIZAO\\workspace\\MonitoraMotores\\resources\\IMG\\MOTOR_LIGADO.png"));
		}else{
			label_7.setIcon(new ImageIcon("C:\\Users\\LUIZAO\\workspace\\MonitoraMotores\\resources\\IMG\\MOTOR_DESLIGADO.png"));
		}
		if(ponto.isPortaUsina()){
			label_13.setIcon(new ImageIcon("C:\\Users\\LUIZAO\\workspace\\MonitoraMotores\\resources\\IMG\\PORTA_ABERTA.png"));
		}else{
			label_13.setIcon(new ImageIcon("C:\\Users\\LUIZAO\\workspace\\MonitoraMotores\\resources\\IMG\\PORTA_FECHADA.png"));
		}
		label_1.setText(ponto.getData().toString());
		repaint();
		
			
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
	private JLabel BackgraoundInicial;
	private JLabel lblArduino;
	private JLabel lblNewLabel;
	private JLabel lblUltimaLeituraGravada;
	private JLabel label_1;
	private Historico telaHistorico;	
	}

