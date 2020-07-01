package ar.unq.po2.tp08.cultivos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ar.unq.po2.tp08.cultivosalterados.Cultivo;
import ar.unq.po2.tp08.cultivosalterados.CultivoMixto;

class CultivoMixtoTest {
	
	private @Mock Cultivo cultivo1;
	private @Mock Cultivo cultivo2;
	private @Mock Cultivo cultivo3;
	private @Mock Cultivo cultivo4;
	private CultivoMixto mixto1;
	private CultivoMixto mixto2;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mixto1 = new CultivoMixto("Mixto1");
		this.mixto2 = new CultivoMixto("Mixto2");
	}

	@Test
	void testConstructor() {
		// verificación
		assertNotNull(this.mixto1);
	}
	
	@Test
	void testGetTipo() {
		// SUT
		String resultado = this.mixto1.getTipo();
		// verificación
		assertEquals("Mixto1", resultado);
	}
	
	@Test
	void testAgregarCultivo() {
		// set up
		this.configurarCultivoSimple(this.cultivo1, "Soja", 500f);
		// SUT
		this.mixto1.agregarCultivo(this.cultivo1);
		// verificación
		assertEquals(1, this.mixto1.getCultivos().size());
	}
	
	@Test
	void testAgregarCultivoTrataDeSimularUnCultivoSimpleYNoLoPermite() {
		// set up
		this.configurarCultivoSimple(this.cultivo1, "Soja", 500f);
		this.configurarCultivoSimple(this.cultivo2, "Soja", 500f);
		this.configurarCultivoSimple(this.cultivo3, "Soja", 500f);
		this.configurarCultivoSimple(this.cultivo4, "Soja", 500f);
		// set up mixto1
		this.mixto1.agregarCultivo(this.cultivo1);
		this.mixto1.agregarCultivo(this.cultivo2);
		this.mixto1.agregarCultivo(this.cultivo3);
		// SUT
		this.mixto1.agregarCultivo(this.cultivo4);
		// verificación
		assertEquals(3, this.mixto1.getCultivos().size());
	}
	
	@Test
	void testGetGanancia2Soja2Trigo() {
		// set up
		this.configurarCultivoSimple(this.cultivo1, "Soja", 500f);
		this.configurarCultivoSimple(this.cultivo2, "Soja", 500f);
		this.configurarCultivoSimple(this.cultivo3, "Trigo", 300f);
		this.configurarCultivoSimple(this.cultivo4, "Trigo", 300f);
		this.mixto1.agregarCultivo(this.cultivo1);
		this.mixto1.agregarCultivo(this.cultivo2);
		this.mixto1.agregarCultivo(this.cultivo3);
		this.mixto1.agregarCultivo(this.cultivo4);
		// SUT
		Float resultado = this.mixto1.getGanancia();
		// verificación
		assertEquals(400f, resultado);
	}
	
	@Test
	void testGetGanancia1Soja3Trigo() {
		// set up
		this.configurarCultivoSimple(this.cultivo1, "Soja", 500f);
		this.configurarCultivoSimple(this.cultivo2, "Trigo", 300f);
		this.configurarCultivoSimple(this.cultivo3, "Trigo", 300f);
		this.configurarCultivoSimple(this.cultivo4, "Trigo", 300f);
		this.mixto1.agregarCultivo(this.cultivo1);
		this.mixto1.agregarCultivo(this.cultivo2);
		this.mixto1.agregarCultivo(this.cultivo3);
		this.mixto1.agregarCultivo(this.cultivo4);
		// SUT
		Float resultado = this.mixto1.getGanancia();
		// verificación
		assertEquals(350f, resultado);
	}
	
	@Test
	void testGetGanancia1Soja2Trigo1Mixto() {
		// set up
		this.configurarCultivoSimple(this.cultivo1, "Soja", 500f);
		this.configurarCultivoSimple(this.cultivo2, "Trigo", 300f);
		this.configurarCultivoSimple(this.cultivo3, "Trigo", 300f);
		this.configurarCultivoSimple(this.cultivo4, "Trigo", 300f);
		// set up mixto2
		this.mixto2.agregarCultivo(this.cultivo1);
		this.mixto2.agregarCultivo(this.cultivo2);
		this.mixto2.agregarCultivo(this.cultivo3);
		this.mixto2.agregarCultivo(this.cultivo4);
		// set up mixto1 con mixto2
		this.mixto1.agregarCultivo(this.cultivo1);
		this.mixto1.agregarCultivo(this.cultivo2);
		this.mixto1.agregarCultivo(this.cultivo3);
		this.mixto1.agregarCultivo(this.mixto2);
		// SUT
		Float resultado = this.mixto1.getGanancia();
		// verificación
		assertEquals(362.5f, resultado);
	}
		
	private void configurarCultivoSimple(Cultivo cultivo, String nombre, Float ganancia) {
		when(cultivo.getTipo()).thenReturn(nombre);
		when(cultivo.getGanancia()).thenReturn(ganancia);
	}

}
