package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import BancoDeDados.DaoPontoLeitura;
import BancoDeDados.DaoUsinada;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;


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
	private Historico historico;

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
		MotorTableModelUsinada table=new MotorTableModelUsinada(new DaoUsinada().retornaTodoBanco());
		table1 = new JTable();
		table1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				 int selected = table1.getSelectedRow();
				 historico=new Historico(selected+1);
				 historico.setVisible(true);
				 
			}
		});
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
//				DaoUsinada dao=new DaoUsinada();
//				table1.removeAll();
//				table1.setModel(new MotorTableModel(
//						dao.retornaIntervaloDeData(textField.getText(), textField_1.getText())));
			}
		});
		panel_1.add(btnBuscar);
		
		
		
	}

}
