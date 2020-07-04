package ar.unq.po2.tp08.publicaciones;

import java.util.ArrayList;
import java.util.List;

public class CriterioCompuesto implements Criterio {
	
	List<Criterio> criterios;

	public CriterioCompuesto() {
		this.setCriterios(new ArrayList<Criterio>());
	}

	public List<Criterio> getCriterios() {
		return criterios;
	}

	public void setCriterios(List<Criterio> criterios) {
		this.criterios = criterios;
	}
	
	public void agregarCriterio(Criterio criterio) {
		this.getCriterios().add(criterio);
	}
	
	public void removerCriterio(Criterio criterio) {
		this.getCriterios().remove(criterio);
	}

	@Override
	public Boolean esDeInteres(Articulo articulo) {
		return this.getCriterios().stream()
				.map(c -> c.esDeInteres(articulo))
				.reduce(Boolean.FALSE, Boolean::logicalOr);
	}

}
