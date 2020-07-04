package ar.unq.po2.tp08.publicaciones;

import java.util.ArrayList;
import java.util.List;

public class CriterioPalabraClave implements Criterio {
	
	private List<String> palabrasClave;

	public CriterioPalabraClave(List<String> palabrasClave) {
		this.setPalabrasClave(palabrasClave);
	}

	private List<String> getPalabrasClave() {
		return palabrasClave;
	}

	private void setPalabrasClave(List<String> autores) {
		this.palabrasClave = autores;
	}

	@Override
	public Boolean esDeInteres(Articulo articulo) {
		List<String> palabrasClavesInteresantes = new ArrayList<String>(this.getPalabrasClave());
		return palabrasClavesInteresantes.retainAll(articulo.getPalabrasClave());
	}

}
