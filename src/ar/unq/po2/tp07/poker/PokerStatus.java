package ar.unq.po2.tp07.poker;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PokerStatus {

	public PokerStatus() {
		// TODO Auto-generated constructor stub
	}

	public Boolean verificar(String carta1, String carta2, String carta3, String carta4, String carta5) {
		List<String> cartas = List.of(carta1, carta2, carta3, carta4, carta5);

		Map<String, Long> cantidadPorRango = cartas.stream()
				.map(c -> this.getRangoCarta(c))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		return Collections.max(cantidadPorRango.values()) == 4;
	}

	private String getRangoCarta(String carta) {
		return carta.substring(0, carta.length() - 1);
	}

}
