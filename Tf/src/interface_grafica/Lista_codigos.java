package interface_grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tf.Consultas;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
/** 
 * @author Eduardo Dornelles
 * Classe para Listar os códigos dentro do Menu_1 e
 * Menu_3 ao apertar o botão "buscar codigos"
 */
public class Lista_codigos extends JFrame implements ActionListener{
	
    private Consultas con = new Consultas();
	private JPanel contentPane;
	private static Lista_codigos frame = new Lista_codigos();
	private JButton botaoVoltar = new JButton("Voltar");
	private List Lista_codigos = new List();
		
			public static void abre_menu() {
				try {
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			public static void fecha_menu(){
				try {				
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}		
	

	
	public Lista_codigos() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 280, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		Lista_codigos.setBounds(10, 10, 244, 261);
		contentPane.add(Lista_codigos);
		
		
		botaoVoltar.setBounds(90, 281, 89, 23);
		contentPane.add(botaoVoltar);
		botaoVoltar.addActionListener(this);
		listar();
		
		
	}

	public void listar(){ //adicionar ao painel a lista de codigos
		ArrayList<String> lista = con.mostrar_codigos();		
		for (String x:lista){
			Lista_codigos.add(x);			
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==botaoVoltar){
			fecha_menu();	
		}
		
	}
	
	

}
