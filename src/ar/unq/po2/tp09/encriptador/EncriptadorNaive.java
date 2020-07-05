package ar.unq.po2.tp09.encriptador;

public class EncriptadorNaive {
	
	private Encriptador encriptador;

	public EncriptadorNaive(Encriptador encriptador) {
		this.setEncriptador(encriptador);
	}

	private Encriptador getEncriptador() {
		return encriptador;
	}

	private void setEncriptador(Encriptador encriptador) {
		this.encriptador = encriptador;
	}
	
	public String encriptar(String texto) {
		return this.getEncriptador().encriptar(texto);
	}
	
	public String desencriptar(String texto) {
		return this.getEncriptador().desencriptar(texto);
	}

}
