package ar.unq.po2.tp09.encriptador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncriptadorLetraPorNumero extends Encriptador {

	public EncriptadorLetraPorNumero() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String encriptar(String texto) {
		List<String> numeros = new ArrayList<String>();
		char[] letras = texto.toCharArray();
		for (int i = 0; i < letras.length; i++) {
			char c = letras[i];
			numeros.add(this.cambiarPorNumero(c));
		}
		return String.join(",", numeros);
	}

	@Override
	public String desencriptar(String texto) {
		List<String> letras = new ArrayList<String>();
		List<String> numeros = Arrays.asList(texto.split(","));
		for (String numero : numeros) {
			letras.add(this.cambiarPorLetra(numero));			
		}
		return String.join("", letras);
	}
	
	private String cambiarPorNumero(char letra) {
		return Integer.valueOf(letra - 'a' + 1).toString();
	}
	
	private String cambiarPorLetra(String numero) {
		return String.valueOf(Character.toString(Integer.valueOf(numero) + 'a' - 1));
	}

}
