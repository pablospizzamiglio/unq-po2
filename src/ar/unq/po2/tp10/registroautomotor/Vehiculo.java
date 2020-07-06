package ar.unq.po2.tp10.registroautomotor;

import java.time.LocalDate;

public class Vehiculo {

	private Boolean esVehiculoPolicial;
	private LocalDate fechaFabricacion;	
	private String ciudadRadicacion; 
	
	public Vehiculo(Boolean esVehiculoPolicial, LocalDate fechaFabricacion, String ciudadRadicacion) {
		this.esVehiculoPolicial = esVehiculoPolicial;
		this.fechaFabricacion = fechaFabricacion;
		this.ciudadRadicacion = ciudadRadicacion;
	}

	public Boolean esVehiculoPolicial() {
		return esVehiculoPolicial;
	}

	public LocalDate getFechaFabricacion() {
		return fechaFabricacion;
	}

	public String ciudadRadicacion() {
		return ciudadRadicacion;
	}
	
	public Boolean tieneMasDeUnAnioDeAntiguedad(LocalDate fecha) {
		return fecha.minusYears(1).isAfter(this.getFechaFabricacion());
	}
	
	public Boolean estaRadicadoEn(String ubicacion) {
		return this.ciudadRadicacion().equalsIgnoreCase(ubicacion);
	}
	
	public Boolean debeRealizarVTV(LocalDate fecha) {
		return !this.esVehiculoPolicial() 
				&& this.estaRadicadoEn("Buenos Aires")
				&& this.tieneMasDeUnAnioDeAntiguedad(fecha);
	}

}
