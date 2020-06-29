package ar.unq.po2.tp07.pokerjugadas;

import java.util.List;

public class JugadaTrio extends Jugada {

	public JugadaTrio(List<Carta> mano) {
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
		return true;
	}

	@Override
	protected Boolean pierdeCon(JugadaTrio otra) {
		return this.peso() < otra.peso();
	}

}
