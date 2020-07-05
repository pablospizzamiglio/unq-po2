package ar.unq.po2.tp09.encriptador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EncriptadorNaiveTest {
	
	private EncriptadorNaive encriptadorNaive;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testConstructor() {
		// exercise
		this.encriptadorNaive = new EncriptadorNaive(new EncriptadorCambiaOrden());
		// verify
		assertNotNull(this.encriptadorNaive);
	}
	
	@Test
	void testEncriptarCambioPalabrasDeOrden() {
		// set up
		this.encriptadorNaive = new EncriptadorNaive(new EncriptadorCambiaOrden());
		// exercise
		String resultado = this.encriptadorNaive.encriptar("una cadena de texto");
		// verify
		assertEquals("de texto una cadena", resultado);
	}
	
	@Test
	void testDesencriptarCambioPalabrasDeOrden() {
		// set up
		this.encriptadorNaive = new EncriptadorNaive(new EncriptadorCambiaOrden());
		// exercise
		String resultado = this.encriptadorNaive.desencriptar("de texto una cadena");
		// verify
		assertEquals("una cadena de texto", resultado);
	}
	
	@Test
	void testEncriptarRotadorVocal() {
		// set up
		this.encriptadorNaive = new EncriptadorNaive(new EncriptadorRotadorVocal());
		// exercise
		String resultado = this.encriptadorNaive.encriptar("una cadena de texto");
		// verify
		assertEquals("ane cedine di tixtu", resultado);
	}
	
	@Test
	void testDesencriptarRotadorVocal() {
		// set up
		this.encriptadorNaive = new EncriptadorNaive(new EncriptadorRotadorVocal());
		// exercise
		String resultado = this.encriptadorNaive.desencriptar("ane cedine di tixtu");
		// verify
		assertEquals("una cadena de texto", resultado);
	}
	
	@Test
	void testEncriptarLetraPorNumero() {
		// set up
		this.encriptadorNaive = new EncriptadorNaive(new EncriptadorLetraPorNumero());
		// exercise
		String resultado = this.encriptadorNaive.encriptar("texto");
		// verify
		assertEquals("20,5,24,20,15", resultado);
	}
	
	@Test
	void testDesencriptarLetraPorNumero() {
		// set up
		this.encriptadorNaive = new EncriptadorNaive(new EncriptadorLetraPorNumero());
		// exercise
		String resultado = this.encriptadorNaive.desencriptar("20,5,24,20,15");
		// verify
		assertEquals("texto", resultado);
	}

}
