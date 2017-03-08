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
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.List;

/**
 * @author Eduardo Dornelles Classe para o Menu da segunda consulta
 */
public class Menu_2 extends JFrame implements ActionListener {
	private Consultas con = new Consultas();
	private JPanel contentPane;
	private static Menu_2 frame = new Menu_2();
	private JTextField textField;
	private JButton botaoProcurar = new JButton("Procurar");
	private List display;
	private JButton botaoNomes = new JButton("Buscar Linhas");
	private List display2;

	public static void abreMenu() {
		try {

			frame.setVisible(true);
			frame = new Menu_2();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void fechaMenu() {
		try {

			frame.setVisible(false);
		} catch (Exception a) {
			a.printStackTrace();
		}
	}

	public Menu_2() {
		setTitle("Paradas de um Onibus");
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 466, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblescrvLinha = new JLabel("Escreva o nome da Linha:");
		lblescrvLinha.setFont(new Font("Arial", Font.PLAIN, 12));
		lblescrvLinha.setBounds(10, 23, 162, 29);
		contentPane.add(lblescrvLinha);

		textField = new JTextField();
		textField.setBounds(158, 28, 170, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		botaoProcurar.setBounds(335, 27, 89, 23);
		contentPane.add(botaoProcurar);

		display = new List();
		display.setBounds(10, 79, 195, 166);
		contentPane.add(display);

		botaoNomes.setBounds(10, 261, 136, 23);
		contentPane.add(botaoNomes);

		display2 = new List();
		display2.setBounds(255, 79, 195, 166);
		contentPane.add(display2);

		JLabel lblLinha1 = new JLabel("Linha 1");
		lblLinha1.setBounds(80, 63, 66, 14);
		contentPane.add(lblLinha1);

		JLabel lbllinha2 = new JLabel("Linha 2");
		lbllinha2.setBounds(335, 63, 66, 14);
		contentPane.add(lbllinha2);
		botaoProcurar.addActionListener(this);
		botaoNomes.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botaoProcurar) {
			try {
				if (textField.getText().equals("")) {
					throw new IllegalArgumentException();
				}

				display.removeAll();
				display2.removeAll();
				String nome = textField.getText();
				ArrayList<Integer> lista = null;
				ArrayList<Integer> lista2 = null;

				lista = con.paradas_linha1(nome);
				lista2 = con.paradas_linha2(nome);
				conv_string(lista, lista2);
				
			}  catch (IllegalArgumentException ex) {				
				JOptionPane.showMessageDialog(botaoProcurar, "Digite o nome da linha desejada!");
			}
			
			catch (IndexOutOfBoundsException ex) {
				display.removeAll();
				display2.removeAll();
				JOptionPane.showMessageDialog(botaoProcurar, "Linha Inexistente ou Fora de Circulação");
			}
			
			catch (NullPointerException ex) {
				display.removeAll();
				display2.removeAll();
				JOptionPane.showMessageDialog(botaoProcurar, "Linha Inexistente ou Fora de Circulação");
			}
			
			
			textField.setText("");
		}
		if (e.getSource() == botaoNomes) {
			Lista_nomes.abre_menu();
		}
	}

	public void conv_string(ArrayList<Integer> novo, ArrayList<Integer> novo2) { 
		// colocar na tela as lista de paradas dos dois sentidos (se houver).
		display.add(textField.getText() + ":");
		display2.add(textField.getText() + ":");
		for (int x : novo) {
			display.add(Integer.toString(x));
		}

		for (int y : novo2) {
			display2.add(Integer.toString(y));
		}
	}
}
