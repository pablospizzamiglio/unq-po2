package ar.unq.po2.tp07.pokercontinuacion;

import static org.junit.Assert.assertEquals;

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
	void testCuatroCartasMismoValorUnaDiferenteEsPoker() {
		// setup
		this.carta1 = "AP";
		this.carta2 = "AC";
		this.carta3 = "AD";
		this.carta4 = "AT";
		this.carta5 = "2C";

		// exercise
		String resultado = this.status.verificar(this.carta1, this.carta2, this.carta3, this.carta4, this.carta5);

		// verify
		assertEquals("Poker", resultado);

		// teardown - no hay
	}

	@Test
	void testTodasCartasMismoPaloEsColor() {
		// setup
		this.carta1 = "AP";
		this.carta2 = "2P";
		this.carta3 = "3P";
		this.carta4 = "4P";
		this.carta5 = "5P";

		// exercise
		String resultado = this.status.verificar(this.carta1, this.carta2, this.carta3, this.carta4, this.carta5);

		// verify
		assertEquals("Color", resultado);

		// teardown - no hay
	}

	@Test
	void testTresMismoValorDosDiferentesEsTrio() {
		// setup
		this.carta1 = "AP";
		this.carta2 = "AC";
		this.carta3 = "AD";
		this.carta4 = "2T";
		this.carta5 = "3C";

		// exercise
		String resultado = this.status.verificar(this.carta1, this.carta2, this.carta3, this.carta4, this.carta5);

		// verify
		assertEquals("Trío", resultado);

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
		String resultado = this.status.verificar(this.carta1, this.carta2, this.carta3, this.carta4, this.carta5);

		// verify
		assertEquals("", resultado);

		// teardown - no hay
	}
	
	@Test
	void testDosCartasMismoValorOtrasDosMismoValorYUnaDiferente() {
		// setup
		this.carta1 = "AP";
		this.carta2 = "AC";
		this.carta3 = "2D";
		this.carta4 = "2T";
		this.carta5 = "3C";

		// exercise
		String resultado = this.status.verificar(this.carta1, this.carta2, this.carta3, this.carta4, this.carta5);

		// verify
		assertEquals("", resultado);

		// teardown - no hay
	}

}
