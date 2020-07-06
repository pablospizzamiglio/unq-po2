package ar.unq.po2.tp08.publicaciones;

public class CriterioLugarPublicacion extends CriterioValor {

	public CriterioLugarPublicacion(String lugarPublicacion) {
		super(lugarPublicacion);
	}

	@Override
	protected String getAtributoDeInteres(Articulo articulo) {
		return articulo.getLugarPublicacion();
	}


}

