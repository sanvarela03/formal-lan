package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import palabras.Palabras;
import utilidades.Utilidades;
import vista.Ventana;

public class Controlador {
	/**
	 * 
	 * @param vista
	 * @param palabras
	 */
	public Controlador(Ventana vista, Palabras palabras) {
		this.vista = vista;
		this.palabras = palabras;
		juntarVistaConModelo();
	}

	/**
	 * Atributos
	 */

	private Ventana vista;
	private Palabras palabras;

	/**
	 * Métodos
	 */
	public void juntarVistaConModelo() {

		agregarSimbolosAlAlfabeto();
		quitarSimbolosAlAlfabeto();
		generarPalabras();

	}

	private void generarPalabras() {
		ActionListener oyente = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (vista.getLongitudMaximaCampoDeTexto().getText().equals("")) {
					vista.getMensajeDeErrorEtiqueta().setText("* se debe especificar la longitud");
				} else {
					crearModeloTabla();
				}
			}

		};
		KeyListener eventoTeclado = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				vista.getMensajeDeErrorEtiqueta().setText("");
			}
		};
		vista.getLongitudMaximaCampoDeTexto().addKeyListener(eventoTeclado);
		vista.getBotonGenerarPalabras().addActionListener(oyente);
	}

	private void crearModeloTabla() {

		DefaultTableModel modelo = new DefaultTableModel();

		modelo.addColumn("Posicion");
		modelo.addColumn("Palabra");

		int i = 0;
		for (String p : Utilidades.calcularPalabra(palabras.getAlfabeto(),
				Integer.parseInt(vista.getLongitudMaximaCampoDeTexto().getText()))) {
			Vector<String> v = new Vector<>();
			v.add("" + i);
			v.add(p);
			modelo.addRow(v);
			i++;
		}

		vista.getTablaPalabras().setModel(modelo);

		vista.getNumeroTotalDePalabrasEtiqueta().setText("" + Utilidades.contarPalabrasEsperadas(palabras.getAlfabeto(),
				Integer.parseInt(vista.getLongitudMaximaCampoDeTexto().getText())));
	}

	private void quitarSimbolosAlAlfabeto() {
		ActionListener oyente = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				palabras.getAlfabeto().remove(palabras.getAlfabeto().size() - 1);
				vista.getContenidoAlfabetoEtiqueta().setText(obtenerAlfabetoOrdenado());
			}

		};

		vista.getBotonQuitarSimbolo().addActionListener(oyente);
	}

	private void agregarSimbolosAlAlfabeto() {

		agregarConBoton();
		agregarConTeclado();

	}

	private void agregarConTeclado() {
		KeyListener eventoTeclado = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyChar() == '\n') {
					palabras.setAlfabeto(vista.getSimboloCampoDeTexto().getText());

					vista.getContenidoAlfabetoEtiqueta().setText(obtenerAlfabetoOrdenado());
					vista.getSimboloCampoDeTexto().setText("");

				}
			}
		};

		vista.getSimboloCampoDeTexto().addKeyListener(eventoTeclado);

	}

	private void agregarConBoton() {
		ActionListener oyente = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				palabras.setAlfabeto(vista.getSimboloCampoDeTexto().getText());

				vista.getContenidoAlfabetoEtiqueta().setText(obtenerAlfabetoOrdenado());
				vista.getSimboloCampoDeTexto().setText("");
			}

		};

		vista.getBotonAgregarSimbolo().addActionListener(oyente);

	}

	private String obtenerAlfabetoOrdenado() {
		String alfabeto = "";

		for (String a : palabras.getAlfabeto()) {
			if (alfabeto.equals("")) {
				alfabeto = a;
			} else {
				alfabeto = alfabeto + ", " + a;
			}
		}
		return "{" + alfabeto + "}";
	}
}
