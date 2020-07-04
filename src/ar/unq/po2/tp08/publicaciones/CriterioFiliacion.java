package ar.unq.po2.tp08.publicaciones;

import java.util.ArrayList;
import java.util.List;

public class CriterioFiliacion implements Criterio {
	
	private List<String> filiaciones;

	public CriterioFiliacion(List<String> filiaciones) {
		this.setFiliaciones(filiaciones);
	}

	private List<String> getFiliaciones() {
		return filiaciones;
	}

	private void setFiliaciones(List<String> filiaciones) {
		this.filiaciones = filiaciones;
	}

	@Override
	public Boolean esDeInteres(Articulo articulo) {
		List<String> filiacionesInteresantes = new ArrayList<String>(this.getFiliaciones());
		return filiacionesInteresantes.retainAll(articulo.getFiliaciones());
	}

}
