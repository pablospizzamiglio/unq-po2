package ar.unq.po2.tp08.publicaciones;

import java.util.List;

public class CriterioFiliacion extends CriterioListaValor {
	
	public CriterioFiliacion(List<String> filiaciones) {
		super(filiaciones);
	}

	@Override
	protected List<String> getAtributoDeInteres(Articulo articulo) {
		return articulo.getFiliaciones();
	}

}
