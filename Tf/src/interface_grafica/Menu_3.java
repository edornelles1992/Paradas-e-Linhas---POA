package interface_grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

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
 * @author Eduardo Dornelles Classe para o Menu da terceira consulta
 */
public class Menu_3 extends JFrame implements ActionListener {

	private Consultas con = new Consultas();
	private JPanel contentPane;
	private static Menu_3 frame = new Menu_3();
	private JTextField textField;
	private JButton botaoAdicionar = new JButton("Adicionar");
	private List display_paradas = display_paradas = new List();
	private JLabel lblListaDeParadas;
	private ArrayList<Integer> lista_adiciona = new ArrayList<>();
	private List display_linhas;
	private JLabel lblListaDeLinhas;
	private JButton botaoVlinhas = new JButton("Verificar Linhas");
	private JButton botao_apagar_tudo;
	private JButton botao_paradas = new JButton("Buscar Parada");

	public static void abreMenu() {

		try {

			frame.setVisible(true);
			frame = new Menu_3();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void fechaMenu() {

		try {
			frame.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public Menu_3() {
		setTitle("Onibus de uma lista de paradas");
		setResizable(false); // construtor criação da janela
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 754, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblcodspar = new JLabel("Digite o c\u00F3digo da parada para adicionar:");
		lblcodspar.setFont(new Font("Arial", Font.PLAIN, 12));
		lblcodspar.setBounds(32, 23, 235, 23);
		contentPane.add(lblcodspar);

		textField = new JTextField();
		textField.setBounds(282, 25, 102, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		botaoAdicionar.setBounds(406, 24, 89, 23);
		contentPane.add(botaoAdicionar);

		display_paradas.setBounds(28, 90, 271, 289);
		contentPane.add(display_paradas);

		lblListaDeParadas = new JLabel("Lista de Paradas:");
		lblListaDeParadas.setBounds(108, 68, 114, 14);
		contentPane.add(lblListaDeParadas);

		display_linhas = new List();
		display_linhas.setBounds(446, 88, 271, 291);
		contentPane.add(display_linhas);

		lblListaDeLinhas = new JLabel("Lista de Linhas:");
		lblListaDeLinhas.setBounds(539, 68, 128, 14);
		contentPane.add(lblListaDeLinhas);

		botaoVlinhas.setBounds(310, 88, 125, 23);
		contentPane.add(botaoVlinhas);

		botao_apagar_tudo = new JButton("Apagar Tudo");

		botao_apagar_tudo.setBounds(310, 345, 125, 23);
		contentPane.add(botao_apagar_tudo);
		
		
		botao_paradas.setBounds(505, 24, 128, 23);
		contentPane.add(botao_paradas);
		botaoAdicionar.addActionListener(this);
		botaoVlinhas.addActionListener(this);
		botao_apagar_tudo.addActionListener(this);
		botao_paradas.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botaoAdicionar) {
			VerificaParada();
			textField.setText("");
		}
		if (e.getSource() == botaoVlinhas) {
			display_linhas.removeAll();
			MostraLinhas(); //chama metodo para buscar as linhas das paradas.

		}
		if (e.getSource() == botao_apagar_tudo) {
			display_paradas.removeAll();
			display_linhas.removeAll();
			lista_adiciona.clear();
			textField.setText("");
		}
		 if (e.getSource()==botao_paradas){
			 Lista_codigos.abre_menu();
		 }

	}

	public void VerificaParada() { // classe para validar o parametro passado
									// pelo textfield
	try{	String aux = textField.getText();		
		int cod = Integer.parseInt(aux);
		if (lista_adiciona.contains(cod)) { // validar se ja n foi adicionado ao
											// arraylist
			JOptionPane.showMessageDialog(botaoAdicionar, "Codigo já Adicionado!");

		} else if (con.temParada(cod)) { // validar se na lista existe essa
											// parada
			lista_adiciona.add(cod);
			display_paradas.add(aux);
		} else {
			JOptionPane.showMessageDialog(botaoAdicionar, "Parada Inexistente!");
		}
		} catch (NumberFormatException e){
			JOptionPane.showMessageDialog(botaoAdicionar, "Digite um código válido");
		}

	}

	public void MostraLinhas() { //metodo para pegar as linhas das paradas e botar na tela
		Map<Integer, ArrayList<String>> lista = con.onibus_paradas(lista_adiciona);

		Set<Map.Entry<Integer, ArrayList<String>>> set = lista.entrySet();
		for (Entry<Integer, ArrayList<String>> me : set) {
			String texto = new String();
			int codigo = me.getKey();			
				
				texto += "Parada " + Integer.toString(codigo) + ":";
				display_linhas.add(texto);
				if (me.getValue() == null||me.getValue().isEmpty()) {
					display_linhas.add("Nenhuma Linha passa nessa Parada (desativada)."); //OBS NEM TODAS PARADAS DOS ARQUIVOS POSSUEM LINHAS VINCULADAS
				} else {
					ArrayList<String> lista_linhas = me.getValue();
					
					for (String x:lista_linhas){
						display_linhas.add(x);
					}
						
					

			}
		}

	}

}
