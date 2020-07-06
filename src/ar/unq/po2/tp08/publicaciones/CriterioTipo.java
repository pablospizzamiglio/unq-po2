package ar.unq.po2.tp08.publicaciones;

public class CriterioTipo extends CriterioValor {
	
	public CriterioTipo(String tipo) {
		super(tipo);
	}
	
	@Override
	protected String getAtributoDeInteres(Articulo articulo) {
		return articulo.getTipo();
	}

}
