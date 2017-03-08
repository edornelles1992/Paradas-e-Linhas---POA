package interface_grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tf.Consultas;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import java.awt.List;

/**
 * @author Eduardo Dornelles 
 * Classe para o Menu da primeira consulta
 */

public class Menu_1 extends JFrame implements ActionListener {
	private Consultas con = new Consultas();
	private JPanel contentPane;
	private static Menu_1 frame = new Menu_1();
	private JTextField textField;
	private JButton botaoProcurar = new JButton("Procurar");
	private List display = new List();
	private JButton botao_listar = new JButton("Buscar c\u00F3digos");

	public static void abreMenu() { // abre o menu
		try {
			 
			frame.setVisible(true);
			frame = new Menu_1();
		
		} catch (Exception a) {
			a.printStackTrace();
		}
	}

	public static void fechaMenu() {
		try {
			
			frame.setVisible(false);
		} catch (Exception a) {
			a.printStackTrace();
		}
	}

	public Menu_1() {
		setTitle("Linhas de Onibus de uma Parada");
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		setBounds(100, 100, 448, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEscrevaOCdigo = new JLabel("Escreva o código da parada:");
		lblEscrevaOCdigo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEscrevaOCdigo.setBounds(10, 23, 162, 29);
		contentPane.add(lblEscrevaOCdigo);

		textField = new JTextField();
		textField.setBounds(180, 28, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		botaoProcurar.setBounds(286, 27, 96, 23);
		contentPane.add(botaoProcurar);

		display.setBounds(10, 58, 424, 174);
		contentPane.add(display);
		botao_listar.setBounds(10, 238, 128, 23);
		
		contentPane.add(botao_listar);
		botaoProcurar.addActionListener(this);
		botao_listar.addActionListener(this);
				
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botaoProcurar) {			
			
			 display.removeAll();
			 String codigo = textField.getText();
			try {
				
				int cod = Integer.parseInt(codigo);
				
					ArrayList<String> lista = con.linhas_parada(cod);	
						
					conv_string(lista);}
			 catch (NullPointerException ex) {
				 textField.setText("");
				 display.removeAll();
				JOptionPane.showMessageDialog(botaoProcurar, "Parada Inexistente Ou sem linhas ativas (desativada).");

			} catch (Exception ex) {
				textField.setText("");
				 display.removeAll();
				JOptionPane.showMessageDialog(botaoProcurar, "Digita o código da parada! OBS: apenas numeros");
			}
			
		} if (e.getSource() == botao_listar){ //abrir a lista de codigo de paradas disponiveis.
			Lista_codigos.abre_menu();
		}
	}

	public void conv_string(ArrayList<String> novo) { // adiciona as linha no display		
			display.add("Parada "+textField.getText()+":");			
			if (novo.get(0)==null){
				display.add("PARADA DESATIVADA"); // mostrar na tela caso não exista nenhuma linha passando nessa parada.
		}
			else {
		for (String x:novo){
			display.add(x);
	}
			}	
	}
}
