package ar.unq.po2.tp09.encriptador;


public class EncriptadorRotadorVocal extends Encriptador {
	
	private char[] vocales;

	public EncriptadorRotadorVocal() {
		this.vocales = "aeiou".toCharArray();
	}

	@Override
	public String encriptar(String texto) {
		char[] letras = texto.toCharArray();
		for (int i = 0; i < letras.length; i++) {
			char c = letras[i];
			if (this.esVocal(c)) {
				letras[i] = this.siguienteVocal(c);
			}
		}
		return String.join("", String.valueOf(letras));
	}

	@Override
	public String desencriptar(String texto) {
		char[] letras = texto.toCharArray();
		for (int i = 0; i < letras.length; i++) {
			char c = letras[i];
			if (this.esVocal(c)) {
				letras[i] = this.anteriorVocal(c);
			}
		}
		return String.join("", String.valueOf(letras));
	}
	
	private Boolean esVocal(char letra) {
		return String.valueOf(this.vocales).contains(String.valueOf(Character.toLowerCase(letra)));
	}
	
	private char siguienteVocal(char vocal) {
		Integer indice = String.valueOf(this.vocales).indexOf(Character.toLowerCase(vocal));

		if (indice == this.vocales.length - 1) {
			indice = 0;
		} else {
			indice++;
		}
		
		char siguienteVocal = this.vocales[indice];
		if (Character.isUpperCase(vocal)) {
			siguienteVocal = Character.toUpperCase(siguienteVocal);
		}
		return siguienteVocal;
	}
	
	private char anteriorVocal(char vocal) {
		Integer indice = String.valueOf(this.vocales).indexOf(Character.toLowerCase(vocal));

		if (indice == 0) {
			indice = this.vocales.length - 1;
		} else {
			indice--;
		}
		
		char anteriorVocal = this.vocales[indice];
		if (Character.isUpperCase(vocal)) {
			anteriorVocal = Character.toUpperCase(anteriorVocal);
		}
		return anteriorVocal;
	}

}
;