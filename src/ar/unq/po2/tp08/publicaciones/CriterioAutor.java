package ar.unq.po2.tp08.publicaciones;

import java.util.ArrayList;
import java.util.List;

public class CriterioAutor implements Criterio {
	
	private List<String> autores;

	public CriterioAutor(List<String> autores) {
		this.setAutores(autores);
	}

	private List<String> getAutores() {
		return autores;
	}

	private void setAutores(List<String> autores) {
		this.autores = autores;
	}

	@Override
	public Boolean esDeInteres(Articulo articulo) {
		List<String> autoresInteresantes = new ArrayList<String>(this.getAutores());
		return autoresInteresantes.retainAll(articulo.getAutores());
	}

}
