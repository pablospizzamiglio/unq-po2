package ar.unq.po2.tp07.pokerjugadas;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PokerStatus {

	public PokerStatus() {
		// TODO Auto-generated constructor stub
	}

	public Jugada verificar(Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5) {
		List<Carta> mano = List.of(carta1, carta2, carta3, carta4, carta5);
		Jugada resultado = null;
		
		if (this.esPoker(mano)) {
			resultado = new JugadaPoker(mano);
		} else if (this.esTrio(mano)) {
			resultado = new JugadaTrio(mano);
		} else if (this.esColor(mano)) {
			resultado = new JugadaColor(mano);
		}

		return resultado;
	}
	
	private Boolean esPoker(List<Carta> mano) {
		Map<CartaValor, Long> cantidadPorValor = this.cantidadCartasPorValor(mano);
		return Collections.max(cantidadPorValor.values()) == 4; 
	}
	
	private Boolean esTrio(List<Carta> mano) {
		Map<CartaValor, Long> cantidadPorValor = this.cantidadCartasPorValor(mano);
		return Collections.max(cantidadPorValor.values()) == 3;
	}
	
	private Boolean esColor(List<Carta> mano) {
		Map<CartaPalo, Long> cantidadPorPalo = this.cantidadCartasPorPalo(mano);		
		return Collections.max(cantidadPorPalo.values()) == 5;
	}
	
	private Map<CartaValor, Long> cantidadCartasPorValor(List<Carta> mano) {
		return mano.stream()
				.collect(Collectors.groupingBy(Carta::getValor, Collectors.counting()));
	}
	
	private Map<CartaPalo, Long> cantidadCartasPorPalo(List<Carta> mano) {
		return mano.stream()
				.collect(Collectors.groupingBy(Carta::getPalo, Collectors.counting()));
	}

}
