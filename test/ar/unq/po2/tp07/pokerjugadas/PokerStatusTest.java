package ar.unq.po2.tp07.pokerjugadas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class PokerStatusTest {

	PokerStatus status;
	// Cartas
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
		this.configurarManoComoPoker(this.carta1, this.carta2, this.carta3, this.carta4, this.carta5);

		// exercise
		Jugada resultado = this.status.verificar(this.carta1, this.carta2, this.carta3, this.carta4, this.carta5);

		// verify
		assertEquals(JugadaPoker.class, resultado.getClass());

		// teardown - no hay
	}

	@Test
	void testTodasCartasMismoPaloEsColor() {
		// set up
		this.configurarManoComoColor(this.carta1, this.carta2, this.carta3, this.carta4, this.carta5);

		// exercise
		Jugada resultado = this.status.verificar(this.carta1, this.carta2, this.carta3, this.carta4, this.carta5);

		// verify
		assertEquals(JugadaColor.class, resultado.getClass());

		// teardown - no hay
	}

	@Test
	void testTresMismoValorDosDiferentesEsTrio() {
		// set up
		this.configurarManoComoTrio(this.carta1, this.carta2, this.carta3, this.carta4, this.carta5);

		// exercise
		Jugada resultado = this.status.verificar(this.carta1, this.carta2, this.carta3, this.carta4, this.carta5);

		// verify
		assertEquals(JugadaTrio.class, resultado.getClass());

		// teardown - no hay
	}
	
	@Test
	void testTodasCartasDiferentes() {	
		// set up
		this.configurarManoTodasCartasDiferentes(this.carta1, this.carta2, this.carta3, this.carta4, this.carta5);
		
		// exercise
		Jugada resultado = this.status.verificar(this.carta1, this.carta2, this.carta3, this.carta4, this.carta5);

		// verify
		assertNull(resultado);

		// teardown - no hay
	}
	
	@Test
	void testDosCartasMismoValorOtrasDosMismoValorYUnaDiferente() {
		// set up
		this.configurarManoDosCartasMismoValorOtrasDosMismoValorYUnaDiferente(this.carta1, this.carta2, this.carta3, this.carta4, this.carta5);

		// exercise
		Jugada resultado = this.status.verificar(this.carta1, this.carta2, this.carta3, this.carta4, this.carta5);

		// verify
		assertNull(resultado);

		// teardown - no hay
	}
	
	private void configurarManoComoPoker(Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5) {
		// As de Picas
		when(carta1.getPalo()).thenReturn(CartaPalo.PICA);
		when(carta1.getValor()).thenReturn(CartaValor.AS);
		// As de Corazones
		when(carta2.getPalo()).thenReturn(CartaPalo.CORAZON);
		when(carta2.getValor()).thenReturn(CartaValor.AS);
		// As de Diamantes
		when(carta3.getPalo()).thenReturn(CartaPalo.DIAMANTE);
		when(carta3.getValor()).thenReturn(CartaValor.AS);
		// As de Tréboles
		when(carta4.getPalo()).thenReturn(CartaPalo.TREBOL);
		when(carta4.getValor()).thenReturn(CartaValor.AS);
		// 2 de Corazones
		when(carta5.getPalo()).thenReturn(CartaPalo.CORAZON);
		when(carta5.getValor()).thenReturn(CartaValor.DOS);
	}
	
	private void configurarManoComoColor(Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5) {
		// set up
		// As de Picas
		when(carta1.getPalo()).thenReturn(CartaPalo.PICA);
		when(carta1.getValor()).thenReturn(CartaValor.AS);
		// 2 de Picas
		when(carta2.getPalo()).thenReturn(CartaPalo.PICA);
		when(carta2.getValor()).thenReturn(CartaValor.DOS);
		// 3 de Picas
		when(carta3.getPalo()).thenReturn(CartaPalo.PICA);
		when(carta3.getValor()).thenReturn(CartaValor.TRES);
		// 4 de Picas
		when(carta4.getPalo()).thenReturn(CartaPalo.PICA);
		when(carta4.getValor()).thenReturn(CartaValor.CUATRO);
		// 5 de Picas
		when(carta5.getPalo()).thenReturn(CartaPalo.PICA);
		when(carta5.getValor()).thenReturn(CartaValor.CINCO);
	}
	
	private void configurarManoComoTrio(Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5) {
		// set up
		// 2 de Picas
		when(carta1.getPalo()).thenReturn(CartaPalo.PICA);
		when(carta1.getValor()).thenReturn(CartaValor.DOS);
		// 2 de Corazones
		when(carta2.getPalo()).thenReturn(CartaPalo.CORAZON);
		when(carta2.getValor()).thenReturn(CartaValor.DOS);
		// 2 de Diamantes
		when(carta3.getPalo()).thenReturn(CartaPalo.DIAMANTE);
		when(carta3.getValor()).thenReturn(CartaValor.DOS);
		// 3 de Tréboles
		when(carta4.getPalo()).thenReturn(CartaPalo.TREBOL);
		when(carta4.getValor()).thenReturn(CartaValor.TRES);
		// 4 de Corazones
		when(carta5.getPalo()).thenReturn(CartaPalo.CORAZON);
		when(carta5.getValor()).thenReturn(CartaValor.CUATRO);
	}
	
	private void configurarManoTodasCartasDiferentes(Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5) {
		// set up
		// 2 de Picas
		when(carta1.getPalo()).thenReturn(CartaPalo.PICA);
		when(carta1.getValor()).thenReturn(CartaValor.AS);
		// 2 de Corazones
		when(carta2.getPalo()).thenReturn(CartaPalo.CORAZON);
		when(carta2.getValor()).thenReturn(CartaValor.DOS);
		// 2 de Diamantes
		when(carta3.getPalo()).thenReturn(CartaPalo.DIAMANTE);
		when(carta3.getValor()).thenReturn(CartaValor.TRES);
		// 3 de Tréboles
		when(carta4.getPalo()).thenReturn(CartaPalo.TREBOL);
		when(carta4.getValor()).thenReturn(CartaValor.CUATRO);
		// 4 de Corazones
		when(carta5.getPalo()).thenReturn(CartaPalo.CORAZON);
		when(carta5.getValor()).thenReturn(CartaValor.CINCO);
	}
	
	private void configurarManoDosCartasMismoValorOtrasDosMismoValorYUnaDiferente(Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5) {
		// set up
		// 2 de Picas
		when(carta1.getPalo()).thenReturn(CartaPalo.PICA);
		when(carta1.getValor()).thenReturn(CartaValor.AS);
		// 2 de Corazones
		when(carta2.getPalo()).thenReturn(CartaPalo.CORAZON);
		when(carta2.getValor()).thenReturn(CartaValor.AS);
		// 2 de Diamantes
		when(carta3.getPalo()).thenReturn(CartaPalo.DIAMANTE);
		when(carta3.getValor()).thenReturn(CartaValor.DOS);
		// 3 de Tréboles
		when(carta4.getPalo()).thenReturn(CartaPalo.TREBOL);
		when(carta4.getValor()).thenReturn(CartaValor.DOS);
		// 4 de Corazones
		when(carta5.getPalo()).thenReturn(CartaPalo.CORAZON);
		when(carta5.getValor()).thenReturn(CartaValor.TRES);
	}

}
