package ar.unq.po2.tp05.sistemabancario;

public class SolicitudCreditoPersonal extends Solicitud {

	public SolicitudCreditoPersonal(Cliente solicitante, Float monto, Integer plazoEnMeses) {
		super(solicitante, monto, plazoEnMeses);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean esAceptable() {
		return  this.estaElSueldoSolicitanteBajoElLimite() && this.estaLaCuotaMensualBajoElLimite();
	}
	
	private Boolean estaElSueldoSolicitanteBajoElLimite() {
		return this.getSolicitante().getSueldoNetoAnual() > 15000f;
	}
	
	private Boolean estaLaCuotaMensualBajoElLimite() {
		return this.cuotaMensual() < this.getSolicitante().getSueldoMensual() * 0.7f;
	}

}
