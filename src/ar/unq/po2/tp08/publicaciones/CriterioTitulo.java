package ar.unq.po2.tp08.publicaciones;

public class CriterioTitulo extends CriterioValor {

	public CriterioTitulo(String titulo) {
		super(titulo);
	}
	
	@Override
	protected String getAtributoDeInteres(Articulo articulo) {
		return articulo.getTitulo();
	}

}
