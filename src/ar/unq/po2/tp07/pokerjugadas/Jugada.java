package ar.unq.po2.tp07.pokerjugadas;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Jugada {
	
	private List<Carta> mano;
	
	public Jugada(List<Carta> mano) {
		this.setMano(mano);
	}

	public List<Carta> getMano() {
		return mano;
	}

	public void setMano(List<Carta> mano) {
		this.mano = mano;
	}

	public abstract Boolean ganaA(Jugada otra);
	
	protected abstract Boolean pierdeCon(JugadaPoker otra);
	
	protected abstract Boolean pierdeCon(JugadaColor otra);
	
	protected abstract Boolean pierdeCon(JugadaTrio otra);
	
	/**
	 * Calcula el peso de una jugada en base al valor de la carta que aparece más veces 
	 * en la misma.
	 * 
	 * Esta forma de cálculo sirve para el Poker y el Trío. Otros tipos de jugada pueden
	 * redefinir este método para obtener resultados diferentes.
	 * 
	 * @return el peso de la jugada
	 */
	protected Integer peso() {
		return this.getMano().stream()
                .collect(Collectors.groupingBy(Carta::getValor, Collectors.counting()))
                .entrySet().stream()
                .max((a, b) -> a.getValue().compareTo(b.getValue()))
                .get()
                .getKey()
                .ordinal(); 
	}

}
