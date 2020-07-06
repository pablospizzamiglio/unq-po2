package ar.unq.po2.tp08.publicaciones;

import java.util.List;

public class CriterioPalabraClave extends CriterioListaValor {
	
	public CriterioPalabraClave(List<String> palabrasClave) {
		super(palabrasClave);
	}

	@Override
	protected List<String> getAtributoDeInteres(Articulo articulo) {
		return articulo.getPalabrasClave();
	}

}
