package Teste;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class Teste2 extends JFrame {


	public Teste2 ()
	{ 

		Container c = getContentPane();

		MaskFormatter formater = new MaskFormatter();
		JFormattedTextField field = new JFormattedTextField();
		field.setColumns(8);

		try {
			formater.setMask("##/##/####");
			formater.install(field);
		} 
		catch (ParseException pe) {
			pe.printStackTrace();
		}
		catch ( Exception ex ) {
			// process remaining Exceptions here
			ex.printStackTrace();

		}
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(field);
		c.setLayout(new BorderLayout());
		c.add(panel,BorderLayout.CENTER);

		setSize(500,500);
		show();


	}
	public static void main(String[] args) {
		new Teste2();
	}

}