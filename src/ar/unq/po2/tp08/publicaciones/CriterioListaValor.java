package ar.unq.po2.tp08.publicaciones;

import java.util.ArrayList;
import java.util.List;

public abstract class CriterioListaValor implements Criterio {
	
	private List<String> valores;
	
	public CriterioListaValor(List<String> valores) {
		this.setPalabrasClave(valores);
	}
	
	private List<String> getValores() {
		return valores;
	}

	private void setPalabrasClave(List<String> valores) {
		this.valores = valores;
	}

	@Override
	public Boolean esDeInteres(Articulo articulo) {
		List<String> valoresInteresantes = new ArrayList<String>(this.getValores());
		return valoresInteresantes.retainAll(this.getAtributoDeInteres(articulo));
	}
	
	protected abstract List<String> getAtributoDeInteres(Articulo articulo);
	
}
