package ar.unq.po2.tp07.mockitocartapoker;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class PokerStatusTest {

	PokerStatus status;
	@Mock Carta carta1;
	@Mock Carta carta2;
	@Mock Carta carta3;
	@Mock Carta carta4;
	@Mock Carta carta5;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.status = new PokerStatus();
	}

	@Test
	void testCuatroCartasMismoValorUnaDiferenteEsPoker() {
		// set up
		// As de Picas
		when(this.carta1.getPalo()).thenReturn("P");
		when(this.carta1.getValor()).thenReturn(1);
		// As de Corazones
		when(this.carta2.getPalo()).thenReturn("C");
		when(this.carta2.getValor()).thenReturn(1);
		// As de Diamantes
		when(this.carta3.getPalo()).thenReturn("D");
		when(this.carta3.getValor()).thenReturn(1);
		// As de Tréboles
		when(this.carta4.getPalo()).thenReturn("T");
		when(this.carta4.getValor()).thenReturn(1);
		// Dos de Corazones
		when(this.carta5.getPalo()).thenReturn("C");
		when(this.carta5.getValor()).thenReturn(2);

		// exercise
		String resultado = this.status.verificar(this.carta1, this.carta2, this.carta3, this.carta4, this.carta5);

		// verify
		assertEquals("Poker", resultado);

		// teardown - no hay
	}

	@Test
	void testTodasCartasMismoPaloEsColor() {
		// set up
		// As de Picas
		when(this.carta1.getPalo()).thenReturn("P");
		when(this.carta1.getValor()).thenReturn(1);
		// Dos de Picas
		when(this.carta2.getPalo()).thenReturn("P");
		when(this.carta2.getValor()).thenReturn(2);
		// Tres de Picas
		when(this.carta3.getPalo()).thenReturn("P");
		when(this.carta3.getValor()).thenReturn(3);
		// Cuatro de Picas
		when(this.carta4.getPalo()).thenReturn("P");
		when(this.carta4.getValor()).thenReturn(4);
		// Cinco de Picas
		when(this.carta5.getPalo()).thenReturn("P");
		when(this.carta5.getValor()).thenReturn(5);

		// exercise
		String resultado = this.status.verificar(this.carta1, this.carta2, this.carta3, this.carta4, this.carta5);

		// verify
		assertEquals("Color", resultado);

		// teardown - no hay
	}

	@Test
	void testTresMismoValorDosDiferentesEsTrio() {
		// set up
		// As de Picas
		when(this.carta1.getPalo()).thenReturn("P");
		when(this.carta1.getValor()).thenReturn(1);
		// As de Corazones
		when(this.carta2.getPalo()).thenReturn("C");
		when(this.carta2.getValor()).thenReturn(1);
		// As de Diamantes
		when(this.carta3.getPalo()).thenReturn("D");
		when(this.carta3.getValor()).thenReturn(1);
		// Dos de Tréboles
		when(this.carta4.getPalo()).thenReturn("T");
		when(this.carta4.getValor()).thenReturn(2);
		// Tres de Corazones
		when(this.carta5.getPalo()).thenReturn("C");
		when(this.carta5.getValor()).thenReturn(3);

		// exercise
		String resultado = this.status.verificar(this.carta1, this.carta2, this.carta3, this.carta4, this.carta5);

		// verify
		assertEquals("Trío", resultado);

		// teardown - no hay
	}
	
	@Test
	void testTodasCartasDiferentes() {	
		// set up
		// As de Picas
		when(this.carta1.getPalo()).thenReturn("P");
		when(this.carta1.getValor()).thenReturn(1);
		// Dos de Corazones
		when(this.carta2.getPalo()).thenReturn("C");
		when(this.carta2.getValor()).thenReturn(2);
		// Tres de Diamantes
		when(this.carta3.getPalo()).thenReturn("D");
		when(this.carta3.getValor()).thenReturn(3);
		// Cuatro de Tréboles
		when(this.carta4.getPalo()).thenReturn("T");
		when(this.carta4.getValor()).thenReturn(4);
		// Cinco de Corazones
		when(this.carta5.getPalo()).thenReturn("C");
		when(this.carta5.getValor()).thenReturn(5);
		
		
		// exercise
		String resultado = this.status.verificar(this.carta1, this.carta2, this.carta3, this.carta4, this.carta5);

		// verify
		assertEquals("", resultado);

		// teardown - no hay
	}
	
	@Test
	void testDosCartasMismoValorOtrasDosMismoValorYUnaDiferente() {
		// set up
		// As de Picas
		when(this.carta1.getPalo()).thenReturn("P");
		when(this.carta1.getValor()).thenReturn(1);
		// As de Corazones
		when(this.carta2.getPalo()).thenReturn("C");
		when(this.carta2.getValor()).thenReturn(1);
		// Dos de Diamantes
		when(this.carta3.getPalo()).thenReturn("D");
		when(this.carta3.getValor()).thenReturn(2);
		// Dos de Tréboles
		when(this.carta4.getPalo()).thenReturn("T");
		when(this.carta4.getValor()).thenReturn(2);
		// Tres de Corazones
		when(this.carta5.getPalo()).thenReturn("C");
		when(this.carta5.getValor()).thenReturn(3);

		// exercise
		String resultado = this.status.verificar(this.carta1, this.carta2, this.carta3, this.carta4, this.carta5);

		// verify
		assertEquals("", resultado);

		// teardown - no hay
	}

}
