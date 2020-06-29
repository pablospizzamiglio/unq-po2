package ar.unq.po2.tp07.pokerjugadas;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class JugadaPokerTest {

	Jugada jugadaA;
	Jugada jugadaB;
	// Cartas Jugada A
	@Mock Carta cartaA1;
	@Mock Carta cartaA2;
	@Mock Carta cartaA3;
	@Mock Carta cartaA4;
	@Mock Carta cartaA5;
	// Cartas Jugada B
	@Mock Carta cartaB1;
	@Mock Carta cartaB2;
	@Mock Carta cartaB3;
	@Mock Carta cartaB4;
	@Mock Carta cartaB5;
	// Manos
	List<Carta> manoA;
	List<Carta> manoB;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.manoA = List.of(this.cartaA1, this.cartaA2, this.cartaA3, this.cartaA4, this.cartaA5);
		this.manoB = List.of(this.cartaB1, this.cartaB2, this.cartaB3, this.cartaB4, this.cartaB5);
	}
	
	void testConstructor() {
		// set up
		this.jugadaA = new JugadaPoker(manoA);
		
		// verificación
		assertNotNull(this.jugadaA);
	}
	
	@Test
	void testPeso() {
		// set up
		this.manoA = this.configurarManoComoPokerAltoValor(this.cartaA1, this.cartaA2, this.cartaA3, this.cartaA4, this.cartaA5);
		this.jugadaA = new JugadaPoker(this.manoA);
		
		// SUT
		Integer peso = this.jugadaA.peso();
		
		// verificación
		assertEquals(13, peso);
	}
	
	@Test
	void testPokerGanaAColor() {
		// set up
		this.manoA = this.configurarManoComoPokerAltoValor(this.cartaA1, this.cartaA2, this.cartaA3, this.cartaA4, this.cartaA5);
		this.manoB = this.configurarManoComoColor(this.cartaB1, this.cartaB2, this.cartaB3, this.cartaB4, this.cartaB5);
		this.jugadaA = new JugadaPoker(this.manoA);
		this.jugadaB = new JugadaColor(this.manoB);
		
		// SUT 
		Boolean resultado = this.jugadaA.ganaA(this.jugadaB);
		
		// verificación
		assertTrue(resultado);
	}

	@Test
	void testPokerGanaATrio() {
		// set up
		this.manoA = this.configurarManoComoPokerAltoValor(this.cartaA1, this.cartaA2, this.cartaA3, this.cartaA4, this.cartaA5);
		this.manoB = this.configurarManoComoTrio(this.cartaB1, this.cartaB2, this.cartaB3, this.cartaB4, this.cartaB5);
		this.jugadaA = new JugadaPoker(this.manoA);
		this.jugadaB = new JugadaTrio(this.manoB);
		
		// SUT 
		Boolean resultado = this.jugadaA.ganaA(this.jugadaB);
		
		// verificación
		assertTrue(resultado);
	}
	
	@Test
	void testPokerAltoValorGanaAPokerBajoValor() {
		// set up
		this.manoA = this.configurarManoComoPokerAltoValor(this.cartaA1, this.cartaA2, this.cartaA3, this.cartaA4, this.cartaA5);
		this.manoB = this.configurarManoComoPokerBajoValor(this.cartaB1, this.cartaB2, this.cartaB3, this.cartaB4, this.cartaB5);
		this.jugadaA = new JugadaPoker(this.manoA);
		this.jugadaB = new JugadaPoker(this.manoB);
		
		// SUT 
		Boolean resultado = this.jugadaA.ganaA(this.jugadaB);
		
		// verificación
		assertTrue(resultado);
	}
	
	@Test
	void testPokerEmpate() {
		// set up
		this.manoA = this.configurarManoComoPokerAltoValor(this.cartaA1, this.cartaA2, this.cartaA3, this.cartaA4, this.cartaA5);
		this.manoB = this.configurarManoComoPokerAltoValor(this.cartaB1, this.cartaB2, this.cartaB3, this.cartaB4, this.cartaB5);
		this.jugadaA = new JugadaPoker(this.manoA);
		this.jugadaB = new JugadaPoker(this.manoB);
		
		// SUT 
		Boolean resultado = this.jugadaA.ganaA(this.jugadaB);
		
		// verificación
		assertFalse(resultado);
	}
	
	private List<Carta> configurarManoComoPokerBajoValor(Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5) {
		// As de Picas
		when(carta1.getPalo()).thenReturn(CartaPalo.PICA);
		when(carta1.getValor()).thenReturn(CartaValor.QUEEN);
		// As de Corazones
		when(carta2.getPalo()).thenReturn(CartaPalo.CORAZON);
		when(carta2.getValor()).thenReturn(CartaValor.QUEEN);
		// As de Diamantes
		when(carta3.getPalo()).thenReturn(CartaPalo.DIAMANTE);
		when(carta3.getValor()).thenReturn(CartaValor.QUEEN);
		// As de Tréboles
		when(carta4.getPalo()).thenReturn(CartaPalo.TREBOL);
		when(carta4.getValor()).thenReturn(CartaValor.QUEEN);
		// 2 de Corazones
		when(carta5.getPalo()).thenReturn(CartaPalo.CORAZON);
		when(carta5.getValor()).thenReturn(CartaValor.DOS);
		
		return List.of(carta1, carta2, carta3, carta4, carta5);
	}

	private List<Carta> configurarManoComoPokerAltoValor(Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5) {
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
		// Q de Corazones
		when(carta5.getPalo()).thenReturn(CartaPalo.CORAZON);
		when(carta5.getValor()).thenReturn(CartaValor.QUEEN);
		
		return List.of(carta1, carta2, carta3, carta4, carta5);
	}
	
	
	private List<Carta> configurarManoComoColor(Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5) {
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
		
		return List.of(carta1, carta2, carta3, carta4, carta5);
	}
	
	private List<Carta> configurarManoComoTrio(Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5) {
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
		
		return List.of(carta1, carta2, carta3, carta4, carta5);
	}

}
