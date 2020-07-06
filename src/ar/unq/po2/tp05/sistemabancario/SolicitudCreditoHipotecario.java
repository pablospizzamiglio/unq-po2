package ar.unq.po2.tp05.sistemabancario;

public class SolicitudCreditoHipotecario extends Solicitud {
	
	private Propiedad propiedad;

	public SolicitudCreditoHipotecario(Cliente solicitante, Float monto, Integer plazoEnMeses, Propiedad propiedad) {
		super(solicitante, monto, plazoEnMeses);
		this.setPropiedad(propiedad);
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}

	@Override
	public Boolean esAceptable() {
		return this.estaLaCuotaMensualBajoElLimite()
				&& this.estaElMontoTotalBajoElLimiteDelValorFiscalDeLaPropiedad()
				&& this.estaLaEdadDelSolicitanteBajoElLimiteAntesDeTerminarDePagar();
	}
	
	private Boolean estaLaCuotaMensualBajoElLimite() {
		return this.cuotaMensual() < this.getSolicitante().getSueldoMensual() * 0.5f;
	}
	
	private Boolean estaElMontoTotalBajoElLimiteDelValorFiscalDeLaPropiedad() {
		return this.getMonto() < this.getPropiedad().getValorFiscal() * 0.7f;
	}

	private Boolean estaLaEdadDelSolicitanteBajoElLimiteAntesDeTerminarDePagar() {
		return (this.getSolicitante().getEdad() + this.getPlazoEnMeses() / 12) < 65;
	}
}
