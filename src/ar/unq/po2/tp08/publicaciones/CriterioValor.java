package ar.unq.po2.tp08.publicaciones;

public abstract class CriterioValor implements Criterio {

	private String valor;
	
	public CriterioValor(String valor) {
		this.setValor(valor);
	}

	private String getValor() {
		return valor;
	}

	private void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public Boolean esDeInteres(Articulo articulo) {
		return this.getValor().equalsIgnoreCase(this.getAtributoDeInteres(articulo));
	}
	
	protected abstract String getAtributoDeInteres(Articulo articulo);
	
}
