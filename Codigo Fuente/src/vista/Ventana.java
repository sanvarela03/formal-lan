package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTextField simboloCampoDeTexto;
	private JTextField longitudMaximaCampoDeTexto;
	private JLabel longitudMaximaEtiqueta;
	private JButton botonQuitarSimbolo;
	private JButton botonGenerarPalabras;
	private JLabel alfabetoEtiqueta;
	private JLabel contenidoAlfabetoEtiqueta;
	private JLabel simboloEtiqueta;
	private JButton botonAgregarSimbolo;
	private JLabel mensajeDeErrorEtiqueta;
	private JPanel panel2;
	private JLabel numeroTotalDePalabrasEtiqueta;
	private JLabel totalPalabrasEtiqueta;

	// Tabla

	private JTable tablaPalabras;

	/**
	 * Launch the application.
	 */

	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setTitle("Santiago Varela Daza\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel1 = new JPanel();
		panel1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel1.setBackground(Color.WHITE);
		panel1.setForeground(Color.WHITE);
		panel1.setBounds(5, 5, 419, 157);
		contentPane.add(panel1);
		panel1.setLayout(null);

		simboloEtiqueta = new JLabel("Simbolo:");
		simboloEtiqueta.setBounds(10, 11, 56, 14);
		panel1.add(simboloEtiqueta);

		simboloCampoDeTexto = new JTextField();
		simboloCampoDeTexto.setBounds(67, 8, 86, 20);
		panel1.add(simboloCampoDeTexto);
		simboloCampoDeTexto.setColumns(10);

		alfabetoEtiqueta = new JLabel("Alfabeto: ");
		alfabetoEtiqueta.setBounds(10, 51, 56, 14);
		panel1.add(alfabetoEtiqueta);

		contenidoAlfabetoEtiqueta = new JLabel("{ }");
		contenidoAlfabetoEtiqueta.setBounds(120, 51, 289, 14);
		panel1.add(contenidoAlfabetoEtiqueta);

		longitudMaximaEtiqueta = new JLabel("Longitud Maxima:");
		longitudMaximaEtiqueta.setBounds(10, 91, 104, 14);
		panel1.add(longitudMaximaEtiqueta);

		longitudMaximaCampoDeTexto = new JTextField();
		longitudMaximaCampoDeTexto.setBounds(130, 88, 56, 20);
		panel1.add(longitudMaximaCampoDeTexto);
		longitudMaximaCampoDeTexto.setColumns(10);

		botonAgregarSimbolo = new JButton("+");
		botonAgregarSimbolo.setToolTipText("Agrega un simbolo al alfabeto (Enter)\r\n");
		botonAgregarSimbolo.setBounds(163, 7, 46, 23);
		panel1.add(botonAgregarSimbolo);

		botonQuitarSimbolo = new JButton("-");
		botonQuitarSimbolo.setToolTipText("Quita el ultimo simbolo agregado");
		botonQuitarSimbolo.setBounds(67, 47, 40, 23);
		panel1.add(botonQuitarSimbolo);

		botonGenerarPalabras = new JButton("Generar palabras\r\n");
		botonGenerarPalabras.setToolTipText("Genera todas las palabras con el alfabeto previo");
		botonGenerarPalabras.setBounds(268, 119, 141, 23);
		panel1.add(botonGenerarPalabras);

		mensajeDeErrorEtiqueta = new JLabel("*");
		mensajeDeErrorEtiqueta.setBounds(196, 91, 213, 14);
		panel1.add(mensajeDeErrorEtiqueta);

		panel2 = new JPanel();
		panel2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel2.setBackground(Color.WHITE);
		panel2.setBounds(5, 174, 419, 276);
		contentPane.add(panel2);
		panel2.setLayout(null);

		totalPalabrasEtiqueta = new JLabel("Total palabras:\r\n");
		totalPalabrasEtiqueta.setBounds(10, 251, 89, 14);
		panel2.add(totalPalabrasEtiqueta);

		numeroTotalDePalabrasEtiqueta = new JLabel("#");
		numeroTotalDePalabrasEtiqueta.setBounds(108, 251, 46, 14);
		panel2.add(numeroTotalDePalabrasEtiqueta);

		tablaPalabras = new JTable();
		tablaPalabras.setForeground(Color.BLACK);
		tablaPalabras.setBounds(10, 11, 399, 211);

		panel2.add(tablaPalabras);
		JScrollPane scroll = new JScrollPane(tablaPalabras, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		int x = tablaPalabras.getX();
		int y = tablaPalabras.getY();
		int width = tablaPalabras.getWidth();
		int height = tablaPalabras.getHeight();

		scroll.setBounds(x, y, width, height);
		panel2.add(scroll);

		setVisible(true);
	}

	public JLabel getLongitudMaximaEtiqueta() {
		return longitudMaximaEtiqueta;
	}

	public JButton getBotonQuitarSimbolo() {
		return botonQuitarSimbolo;
	}

	public JButton getBotonGenerarPalabras() {
		return botonGenerarPalabras;
	}

	public JTextField getSimboloCampoDeTexto() {
		return simboloCampoDeTexto;
	}

	public JLabel getAlfabetoEtiqueta() {
		return alfabetoEtiqueta;
	}

	public JLabel getContenidoAlfabetoEtiqueta() {
		return contenidoAlfabetoEtiqueta;
	}

	public JLabel getSimboloEtiqueta() {
		return simboloEtiqueta;
	}

	public JButton getBotonAgregarSimbolo() {
		return botonAgregarSimbolo;
	}

	public JLabel getMensajeDeErrorEtiqueta() {
		return mensajeDeErrorEtiqueta;
	}

	public JTextField getLongitudMaximaCampoDeTexto() {
		return longitudMaximaCampoDeTexto;
	}

	public JPanel getPanel2() {
		return panel2;
	}

	public JLabel getNumeroTotalDePalabrasEtiqueta() {
		return numeroTotalDePalabrasEtiqueta;
	}

	public JLabel getTotalPalabrasEtiqueta() {
		return totalPalabrasEtiqueta;
	}

	public JTable getTablaPalabras() {
		return tablaPalabras;
	}

	public void setTablaPalabras(JTable tablaPalabras) {
		this.tablaPalabras = tablaPalabras;
	}
	
	
}
