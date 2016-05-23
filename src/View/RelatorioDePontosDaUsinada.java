package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import BancoDeDados.DaoPontoLeitura;
import BancoDeDados.DaoUsinada;
import Controler.controlaUsinada;
import viewModeloTabelas.MotorTableModelPontoDeLeitura;
import viewModeloTabelas.MotorTableModelUsinada;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Font;


public class RelatorioDePontosDaUsinada extends JFrame {

	private JPanel contentPane;
	private JTable table1;
	private JPanel panel;
	private Historico historico;
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
	public RelatorioDePontosDaUsinada(int codigo) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RelatorioDePontosDaUsinada.class.getResource("/IMG/MOTOR_LIGADO.png")));
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
//		scrollPane.setMinimumSize(new Dimension(0, 32));
//		scrollPane.setPreferredSize(new Dimension(440, 2));
		panel.add(scrollPane);
		//cria modelo de tabela para tabela
		MotorTableModelPontoDeLeitura table=new MotorTableModelPontoDeLeitura(new DaoUsinada().retornaUsinadaCodigo(codigo).getPontosDeLeituras());
		
		table1 = new JTable();
		table1.setModel(table);
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		//define largura de colunas
		table1.getColumnModel().getColumn(0).setPreferredWidth(70);
		table1.getColumnModel().getColumn(1).setPreferredWidth(100);
		table1.getColumnModel().getColumn(2).setPreferredWidth(90);
		table1.getColumnModel().getColumn(3).setPreferredWidth(100);
		table1.getColumnModel().getColumn(4).setPreferredWidth(20);
		table1.getColumnModel().getColumn(5).setPreferredWidth(20);
		table1.getColumnModel().getColumn(6).setPreferredWidth(20);
		table1.getColumnModel().getColumn(7).setPreferredWidth(20);
		table1.getColumnModel().getColumn(8).setPreferredWidth(20);
		table1.getColumnModel().getColumn(9).setPreferredWidth(20);
		
		
		scrollPane.setViewportView(table1);
						
		long segundos=0;
		
		for(int i = 0 ; i < table.getRowCount() ; i++){  
		try{
			
			 SimpleDateFormat sdf = new SimpleDateFormat("HH:MM:SS");
			Date data1 = sdf.parse("00:23:34");
			System.out.println(""+table1.getValueAt(i, 3));
			 segundos += (data1.getTime() - 
					data1.getTime()) / 1000;
		}  catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		    
		     
		     textField_3.setText(new controlaUsinada().formataHoraMinutosSegundos(new controlaUsinada().calculadoraDeHoras(segundos)));
		
		
		panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(630, 10));
		panel_2.setMinimumSize(new Dimension(300, 10));
		contentPane.add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(null);
		
		JLabel lblTotalDeUsinada = new JLabel("Total de Pontos");
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
		
		JLabel lblTempoTrabalhado = new JLabel("Tempo Total");
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
	
}
