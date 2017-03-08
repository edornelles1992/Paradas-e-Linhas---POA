package interface_grafica;

/**
 * @author Eduardo Dornelles
 * Classe do Menu Principal
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.AbstractAction;
import javax.swing.Action;

public class Menu extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton botao1 = new JButton("Para consultar as linhas de onibus de uma parada CLIQUE AQUI");
	private JLabel textoMenu = new JLabel("Escolha a Consulta desejada:");
	private final JButton botao2 = new JButton("Para consultar as paradas de uma linha de onibus CLIQUE AQUI");
	private final JButton botao3 = new JButton(
			"Para consultar linhas de onibus que passam em um grupo de paradas CLIQUE AQUI");

	public static void run() {
		try {
			Menu frame = new Menu();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Menu() {
		setTitle("Consulta de Onibus/Linhas de Porto Alegre");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null); // layout absolute

		botao1.setBounds(54, 55, 500, 42);
		contentPane.add(botao1);

		textoMenu.setFont(new Font("Arial", Font.PLAIN, 18));
		textoMenu.setBounds(175, 11, 244, 33);
		contentPane.add(textoMenu);
		botao2.setBounds(54, 136, 500, 42);

		contentPane.add(botao2);
		botao3.setBounds(30, 212, 553, 42);

		contentPane.add(botao3);

		botao1.addActionListener(this); // adicionar os botões para realizar
										// ações
		botao2.addActionListener(this);
		botao3.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botao1) {
			Menu_1.abreMenu();
		}
		if (e.getSource() == botao2) {
			Menu_2.abreMenu();

		}
		if (e.getSource() == botao3) {
			Menu_3.abreMenu();

		}

	}
}
