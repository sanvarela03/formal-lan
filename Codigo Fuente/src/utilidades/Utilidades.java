package utilidades;

import java.util.ArrayList;
import java.util.List;

public class Utilidades {
	
	
	public static List<String> calcularPalabra(List<String> alfabeto, int longitudMaxima) {

		List<String> palabras = crearListaDePalabras(alfabeto);

		int longitudAlfabeto = palabras.size();
		int indiceInicial = 0;
		int indiceFinal = palabras.size();
		int longitudActualMaxima = 0;
		do {
			for (int i = indiceInicial; i < indiceFinal; i++) {
				for (int j = 0; j < longitudAlfabeto; j++) {
					palabras.add(palabras.get(i) + palabras.get(j));
				}
			}
			indiceInicial = indiceFinal;
			indiceFinal = palabras.size();

			longitudActualMaxima = palabras.get(palabras.size() - 1).length();
		} while (longitudActualMaxima != longitudMaxima);

		return palabras;
	}
	private static List<String> crearListaDePalabras(List<String> alfabeto) {
		ArrayList<String> palabras = new ArrayList<>();
		for (String a : alfabeto) {
			palabras.add(a);
		}
		return palabras;
	}
	
	public static int contarPalabrasEsperadas(ArrayList<String> alfabeto, Integer longitudMaxima) {

		double cardinalDelAlfabeto = alfabeto.size();
		Double palabrasEsperadas = 0.0;
		
		for (int i = 1; i <= longitudMaxima; i++) {
			palabrasEsperadas = palabrasEsperadas + Math.pow(cardinalDelAlfabeto, i);
		}

		return palabrasEsperadas.intValue();
	}
}
