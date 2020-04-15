package ar.unq.po2.tp2;

public class ConceptoRetencionPorcentual extends Concepto {

	public ConceptoRetencionPorcentual(String descripcion, Float valor) {
		super(descripcion, valor);
	}

	@Override
	public Float aplicar(Float monto) {
		return monto * this.getValor();
	}
	

}
