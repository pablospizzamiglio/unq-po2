package ar.unq.po2.tp07.pokercontinuacion;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PokerStatus {

	public PokerStatus() {
		// TODO Auto-generated constructor stub
	}

	public String verificar(String carta1, String carta2, String carta3, String carta4, String carta5) {
		List<String> cartas = List.of(carta1, carta2, carta3, carta4, carta5);
		String resultado = "";
		
		if (this.esPoker(cartas)) {
			resultado = "Poker";
		} else if (this.esTrio(cartas)) {
			resultado = "Trío";
		} else if (this.esColor(cartas)) {
			resultado = "Color";
		}

		return resultado;
	}

	private String getValorCarta(String carta) {
		return carta.substring(0, carta.length() - 1);
	}
	
	private String getPaloCarta(String carta) {
		return carta.substring(carta.length() - 1);
	}
	
	private Boolean esPoker(List<String> cartas) {
		Map<String, Long> cantidadPorValor = this.cantidadCartasPorValor(cartas);
		return Collections.max(cantidadPorValor.values()) == 4; 
	}
	
	private Boolean esTrio(List<String> cartas) {
		Map<String, Long> cantidadPorValor = this.cantidadCartasPorValor(cartas);
		return Collections.max(cantidadPorValor.values()) == 3;
	}
	
	private Boolean esColor(List<String> cartas) {
		Map<String, Long> cantidadPorPalo = this.cantidadCartasPorPalo(cartas);		
		return Collections.max(cantidadPorPalo.values()) == 5;
	}
	
	private Map<String, Long> cantidadCartasPorValor(List<String> cartas) {
		return cartas.stream()
				.map(c -> this.getValorCarta(c))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}
	
	private Map<String, Long> cantidadCartasPorPalo(List<String> cartas) {
		return cartas.stream()
				.map(c -> this.getPaloCarta(c))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}

}
