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

import java.awt.List;
import javax.swing.JButton;
/** 
 * @author Eduardo Dornelles
 * Classe para Listar os nomes das linhas
 * dentro do Menu_2 ao apertar o botão "buscar nomes"
 */
public class Lista_nomes extends JFrame implements ActionListener {

	private JPanel contentPane;
	private Consultas con = new Consultas();
	private static Lista_nomes frame = new Lista_nomes();
	private JButton botao_voltar = new JButton("Voltar");
	private List list_nomes = new List();
	
	public static void abre_menu() {
		try {

			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void fecha_menu() {
		try {

			frame.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public Lista_nomes() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 280, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		list_nomes.setBounds(10, 10, 244, 267);
		contentPane.add(list_nomes);
		
		
		botao_voltar.setBounds(90, 283, 89, 23);
		contentPane.add(botao_voltar);
		botao_voltar.addActionListener(this);
		listar();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==botao_voltar){
			fecha_menu();
		}
		
	}
	
	public void listar() { //listar no painel as linhas (string)
		ArrayList<String> lista = con.mostrar_nomes();
		for(String x:lista){
			list_nomes.add(x);
			
		}
	}

}
