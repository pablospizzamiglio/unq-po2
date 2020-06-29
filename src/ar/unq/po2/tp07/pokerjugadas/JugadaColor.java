package ar.unq.po2.tp07.pokerjugadas;

import java.util.List;

public class JugadaColor extends Jugada {

	public JugadaColor(List<Carta> mano) {
		super(mano);
	}

	@Override
	public Boolean ganaA(Jugada otra) {
		return otra.pierdeCon(this);
	}

	@Override
	protected Boolean pierdeCon(JugadaPoker otra) {
		return true;
	}

	@Override
	protected Boolean pierdeCon(JugadaColor otra) {
		return this.peso() < otra.peso();
	}

	@Override
	protected Boolean pierdeCon(JugadaTrio otra) {
		return false;
	}

	/**
	 * Calcula el peso de una jugada en base al valor de las carta que la componen.
	 * 
	 * @return el peso de la jugada
	 */
	@Override
	public Integer peso() {
		return this.getMano()
				.stream()
				.mapToInt(c -> c.getValor().ordinal())
				.sum();
	}

}
