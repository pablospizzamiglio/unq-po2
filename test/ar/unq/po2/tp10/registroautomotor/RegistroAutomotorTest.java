package ar.unq.po2.tp10.registroautomotor;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

public class RegistroAutomotorTest {
	
	@Test
	public void testVehiculosQueDebenRealizarVtv() {
		RegistroAutomotor registroAutomotor = new RegistroAutomotor();
		Vehiculo vehiculoPolicial = new Vehiculo(true, LocalDate.of(2018, 1, 1), "Buenos Aires");
		Vehiculo vehiculoReciente = new Vehiculo(false, LocalDate.of(2018, 1, 1), "Buenos Aires");
		Vehiculo vehiculoLaPlata = new Vehiculo(false, LocalDate.of(2018, 1, 1), "La Plata");
		Vehiculo vechiculoCumpleVtv = new Vehiculo(false, LocalDate.of(2018, 1, 1), "Buenos Aires");
		
		assertFalse("Vehículos policiales no realizan VTV", registroAutomotor.debeRealizarVTV(vehiculoPolicial, LocalDate.of(2019, 10, 10)));
		assertFalse("Vehículos con antigüedad menor a un año no realizan VTV", registroAutomotor.debeRealizarVTV(vehiculoReciente, LocalDate.of(2018, 11, 10)));
		assertFalse("Vehículos no radicados en Buenos Aires no realizan VTV", registroAutomotor.debeRealizarVTV(vehiculoLaPlata, LocalDate.of(2019, 10, 10)));
		assertTrue(registroAutomotor.debeRealizarVTV(vechiculoCumpleVtv, LocalDate.of(2019, 10, 10)));
	}
	
}
