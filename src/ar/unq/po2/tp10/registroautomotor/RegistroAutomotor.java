package ar.unq.po2.tp10.registroautomotor;

import java.time.LocalDate;

public class RegistroAutomotor {

	public Boolean debeRealizarVTV(Vehiculo vehiculo, LocalDate fecha) {
		return vehiculo.debeRealizarVTV(fecha);
	}

}
