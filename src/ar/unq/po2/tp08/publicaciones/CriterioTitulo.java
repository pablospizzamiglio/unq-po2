package ar.unq.po2.tp08.publicaciones;

public class CriterioTitulo implements Criterio {

	private String titulo;
	
	public CriterioTitulo(String titulo) {
		this.setTitulo(titulo);
	}

	private String getTitulo() {
		return titulo;
	}

	private void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public Boolean esDeInteres(Articulo articulo) {
		return this.getTitulo().equalsIgnoreCase(articulo.getTitulo());
	}

}
