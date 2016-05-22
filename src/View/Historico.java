package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import BancoDeDados.DaoPontoLeitura;
import BancoDeDados.DaoUsinada;
import Entity.pontoDeLeitura;
import viewModeloTabelas.MotorTableModelPontoDeLeitura;
import viewModeloTabelas.renderTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.List;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Historico extends JFrame {

	private JPanel contentPane;
	private JTable table1;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblDataInicial;
	private JLabel lblDataFinal;
	private JButton btnAtualizar;
	private JFormattedTextField formattedTextField;
	private JFormattedTextField formattedTextField_1;
	private JButton btnBuscar_1;
	private JScrollPane scrollPane ;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public Historico() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Historico.class.getResource("/IMG/MOTOR_LIGADO.png")));
		setTitle("Relat\u00F3rio de Leituras");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 952, 678);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panel.add(scrollPane);
		//cria modelo de tabela para tabela
		MotorTableModelPontoDeLeitura table=new MotorTableModelPontoDeLeitura(new DaoPontoLeitura().readAll());
		
		table1 = new JTable();
		table1.setDefaultRenderer(Object.class, new renderTable());
		table1.setModel(table);
	
		scrollPane.setViewportView(table1);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
			table1.removeAll();
			table1.setModel(new MotorTableModelPontoDeLeitura(new DaoPontoLeitura().readAll()));
			
			}
		});
		panel_1.add(btnAtualizar);
		
		lblDataInicial = new JLabel("Data inicial: ");
		panel_1.add(lblDataInicial);
		
		MaskFormatter formater = new MaskFormatter();
		MaskFormatter formater2 = new MaskFormatter();
		try {
			formater.setMask("##/##/####");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
		try {
			formater2.setMask("##/##/####");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		formattedTextField = new JFormattedTextField();
		formattedTextField.setColumns(8);
		formattedTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);  
		formater2.install(formattedTextField);
		panel_1.add(formattedTextField);
		
		lblDataFinal = new JLabel("Data Final:");
		panel_1.add(lblDataFinal);
		
		formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setColumns(8);
		formattedTextField_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		formater.install(formattedTextField_1);
		panel_1.add(formattedTextField_1);
	
		btnBuscar_1 = new JButton("Buscar");
		btnBuscar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DaoPontoLeitura dao=new DaoPontoLeitura();
				table1.removeAll();
				table1.setModel(new MotorTableModelPontoDeLeitura(
						dao.retornaIntervaloDeData(formattedTextField.getText(), formattedTextField_1.getText())));
				System.out.println(formattedTextField.getText()+"  "+ formattedTextField_1.getText());
			}
		});
		panel_1.add(btnBuscar_1);
		
		
		
	}
	public Historico(int codigo) {
		setTitle("Relat\u00F3rio de Leituras");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
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
		MotorTableModelPontoDeLeitura table=new MotorTableModelPontoDeLeitura(new DaoUsinada().retornaUsinadaCodigo(codigo).getPontosDeLeituras());
		table1 = new JTable();
		table1.setModel(table);
		
		scrollPane.setViewportView(table1);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		lblDataInicial = new JLabel("Data inicial: ");
		panel_1.add(lblDataInicial);
		
		btnBuscar_1 = new JButton("Buscar");
		btnBuscar_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				atualizaTabeleBanco();
			}
		});
		panel_1.add(btnBuscar_1);
		panel_1.setVisible(false);
		
		
	}
	
	public void atualizaTabeleBanco(){
		DaoPontoLeitura dao=new DaoPontoLeitura();
		table1.removeAll();
		table1.setModel(new MotorTableModelPontoDeLeitura(
				dao.readAll()));
		JScrollBar bar = scrollPane.getVerticalScrollBar();  
        bar.setValue(bar.getMaximum());  
	}
	
	

}
