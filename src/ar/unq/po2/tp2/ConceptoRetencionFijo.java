package ar.unq.po2.tp2;

public class ConceptoRetencionFijo extends Concepto {

	public ConceptoRetencionFijo(String descripcion, Float valor) {
		super(descripcion, valor);
	}

	@Override
	public Float aplicar(Float monto) {
		return monto - this.getValor();
	}

}
