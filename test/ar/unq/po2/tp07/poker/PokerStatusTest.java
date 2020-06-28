package ar.unq.po2.tp07.poker;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PokerStatusTest {

	PokerStatus status;
	String carta1;
	String carta2;
	String carta3;
	String carta4;
	String carta5;

	@BeforeEach
	void setUp() throws Exception {
		this.status = new PokerStatus();
	}

	@Test
	void testCuatroCartasIgualesUnaDiferente() {
		// setup
		this.carta1 = "AP";
		this.carta2 = "AC";
		this.carta3 = "AD";
		this.carta4 = "AT";
		this.carta5 = "2C";

		// exercise
		Boolean esperado = this.status.verificar(this.carta1, this.carta2, this.carta3, this.carta4, this.carta5);

		// verify
		assertTrue(esperado);

		// teardown - no hay
	}

	@Test
	void testTodasCartasDiferentes() {
		// setup
		this.carta1 = "AP";
		this.carta2 = "2C";
		this.carta3 = "3D";
		this.carta4 = "4T";
		this.carta5 = "5C";

		// exercise
		Boolean esperado = this.status.verificar(this.carta1, this.carta2, this.carta3, this.carta4, this.carta5);

		// verify
		assertFalse(esperado);

		// teardown - no hay
	}

	@Test
	void testTresCartasIgualesDosDiferentes() {
		// setup
		this.carta1 = "AP";
		this.carta2 = "AC";
		this.carta3 = "AD";
		this.carta4 = "2T";
		this.carta5 = "3C";

		// exercise
		Boolean esperado = this.status.verificar(this.carta1, this.carta2, this.carta3, this.carta4, this.carta5);

		// verify
		assertFalse(esperado);

		// teardown - no hay
	}

}
