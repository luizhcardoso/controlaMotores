package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import BancoDeDados.DaoPontoLeitura;
import BancoDeDados.DaoUsinada;
import viewModeloTabelas.MotorTableModelPontoDeLeitura;
import viewModeloTabelas.MotorTableModelUsinada;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Font;


public class RelatorioDeUsinada extends JFrame {

	private JPanel contentPane;
	private JTable table1;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblDataInicial;
	private JLabel lblDataFinal;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnBuscar;
	private RelatorioDePontosDaUsinada historico;
	private JPanel panel_2;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public RelatorioDeUsinada() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RelatorioDeUsinada.class.getResource("/IMG/MOTOR_LIGADO.png")));
		setTitle("Relat\u00F3rio de Leituras");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1160, 688);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setMinimumSize(new Dimension(0, 32));
		scrollPane.setPreferredSize(new Dimension(440, 2));
		panel.add(scrollPane);
		//cria modelo de tabela para tabela
		MotorTableModelUsinada table=new MotorTableModelUsinada(new DaoUsinada().readAll());
		table1 = new JTable();
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		
		table1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				 int selected = table1.getSelectedRow();
				if((table1.getValueAt(selected,2)!=null)){
				 historico=new RelatorioDePontosDaUsinada(selected+1);
				 historico.setVisible(true);
				}
			}
		
		});
		//seta modelo para table
		table1.setModel(table);
		//define largura de colunas
		table1.getColumnModel().getColumn(0).setPreferredWidth(70);
		table1.getColumnModel().getColumn(1).setPreferredWidth(100);
		table1.getColumnModel().getColumn(2).setPreferredWidth(90);
		table1.getColumnModel().getColumn(3).setPreferredWidth(200);
		
		scrollPane.setViewportView(table1);
		int soma=0;
		for(int i = 0 ; i < table.getColumnCount() ; i++){  
//		      System.out.println(((table1.getValueAt(i, 2))));// NO CASO VOCE USARIA O DE TABELA � BEM PARECIDO E FIXARIA O VALOR DA COLUNA   
		}  

		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		lblDataInicial = new JLabel("Data inicial: ");
		panel_1.add(lblDataInicial);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		lblDataFinal = new JLabel("Data Final:");
		panel_1.add(lblDataFinal);
		
		textField_1 = new JTextField();
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
//				DaoUsinada dao=new DaoUsinada();
//				table1.removeAll();
//				table1.setModel(new MotorTableModel(
//						dao.retornaIntervaloDeData(textField.getText(), textField_1.getText())));
			}
		});
		panel_1.add(btnBuscar);
		
		panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(630, 10));
		panel_2.setMinimumSize(new Dimension(300, 10));
		contentPane.add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(null);
		
		JLabel lblTotalDeUsinada = new JLabel("Total de Usinadas");
		lblTotalDeUsinada.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTotalDeUsinada.setBounds(40, 158, 172, 33);
		panel_2.add(lblTotalDeUsinada);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setEnabled(false);
		textField_2.setBounds(243, 163, 146, 26);
		textField_2.setText(""+table1.getRowCount());
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBounds(243, 114, 146, 26);
		panel_2.add(textField_3);
		
		JLabel lblTempoTrabalhado = new JLabel("Tempo Trabalhado");
		lblTempoTrabalhado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTempoTrabalhado.setBounds(40, 109, 185, 33);
		panel_2.add(lblTempoTrabalhado);
		
		JLabel lblTempoParada = new JLabel("Tempo Parada");
		lblTempoParada.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTempoParada.setBounds(40, 65, 185, 33);
		panel_2.add(lblTempoParada);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setColumns(10);
		textField_4.setBounds(243, 70, 146, 26);
		panel_2.add(textField_4);
		
		
		
	}
	public void atualizaTabeleBanco(){
		DaoPontoLeitura dao=new DaoPontoLeitura();
		table1.removeAll();
		table1.setModel(new MotorTableModelPontoDeLeitura(
				dao.retornaIntervaloDeData(textField.getText(), textField_1.getText())));
		
	}
}
