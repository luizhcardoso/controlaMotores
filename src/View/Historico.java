package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import BancoDeDados.DaoPontoLeitura;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Historico extends JFrame {

	private JPanel contentPane;
	private JTable table1;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblDataInicial;
	private JLabel lblDataFinal;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnBuscar;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public Historico() {
		setTitle("Relat\u00F3rio de Leituras");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 952, 678);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		//cria modelo de tabela para tabela
		MotorTableModel table=new MotorTableModel(new DaoPontoLeitura().readAll());
		table1 = new JTable();
		table1.setModel(table);
		
		scrollPane.setViewportView(table1);
		
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
				DaoPontoLeitura dao=new DaoPontoLeitura();
				table1.removeAll();
				table1.setModel(new MotorTableModel(
						dao.retornaIntervaloDeData(textField.getText(), textField_1.getText())));
			}
		});
		panel_1.add(btnBuscar);
		
		
		
	}

}