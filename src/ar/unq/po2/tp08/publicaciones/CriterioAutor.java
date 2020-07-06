package ar.unq.po2.tp08.publicaciones;

import java.util.List;

public class CriterioAutor extends CriterioListaValor {
	
	public CriterioAutor(List<String> autores) {
		super(autores);
	}

	@Override
	protected List<String> getAtributoDeInteres(Articulo articulo) {
		return articulo.getAutores();
	}

}
