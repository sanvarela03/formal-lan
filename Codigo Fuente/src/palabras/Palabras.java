/**
 * 
 */
package palabras;

import java.util.ArrayList;

import utilidades.Utilidades;

/**
 * @author USUARIO
 *
 */
public class Palabras {
	/**
	 * Atributos
	 */
	public  ArrayList<String> alfabeto = new ArrayList<>();
	
	/**
	 * Metodos
	 */
	public  ArrayList<String> getAlfabeto() {
		return alfabeto;
	}


	public  void setAlfabeto(String simbolo) {
		alfabeto.add(simbolo);
	}
}
