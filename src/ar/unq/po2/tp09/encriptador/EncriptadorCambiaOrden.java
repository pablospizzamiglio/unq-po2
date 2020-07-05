package ar.unq.po2.tp09.encriptador;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EncriptadorCambiaOrden extends Encriptador {

	public EncriptadorCambiaOrden() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String encriptar(String texto) {
		List<String> palabras = Arrays.asList(texto.split(" ")); 
		Collections.rotate(palabras, palabras.size() / 2);
		return String.join(" ", palabras);
	}

	@Override
	public String desencriptar(String texto) {
		List<String> palabras = Arrays.asList(texto.split(" "));
		Collections.rotate(palabras, palabras.size() / -2);
		return String.join(" ", palabras);
	}

}
