package ar.unq.po2.tp08.publicaciones;

public class CriterioTipo implements Criterio {

	private String tipo;
	
	public CriterioTipo(String tipo) {
		this.setTipo(tipo);
	}

	private String getTipo() {
		return tipo;
	}

	private void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public Boolean esDeInteres(Articulo articulo) {
		return this.getTipo().equalsIgnoreCase(articulo.getTipo());
	}

}
