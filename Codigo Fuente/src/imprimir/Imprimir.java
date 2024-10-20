/**
 * 
 */
package imprimir;

import java.util.Random;

import controlador.Controlador;
import palabras.Palabras;
import vista.Ventana;

/**
 * @author USUARIO
 *
 */
public class Imprimir {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Ventana vista = new Ventana();
		Palabras palabras = new Palabras();

		Controlador controlador = new Controlador(vista, palabras);

	}

}
