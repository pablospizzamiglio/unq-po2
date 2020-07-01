package ar.unq.po2.tp08.cultivosalterados;

public abstract class Cultivo {
	
	private String tipo;
	
	public Cultivo(String tipo) {
		this.setTipo(tipo);
	}
	
	public String getTipo() {
		return tipo;
	}

	private void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public abstract Float getGanancia();

}
