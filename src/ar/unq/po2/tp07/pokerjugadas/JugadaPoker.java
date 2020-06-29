package ar.unq.po2.tp07.pokerjugadas;

import java.util.List;

public class JugadaPoker extends Jugada {

	public JugadaPoker(List<Carta> mano) {
		super(mano);
	}

	@Override
	public Boolean ganaA(Jugada otra) {
		return otra.pierdeCon(this);
	}

	@Override
	protected Boolean pierdeCon(JugadaPoker otra) {
		return this.peso() < otra.peso();
	}

	@Override
	protected Boolean pierdeCon(JugadaColor otra) {
		return false;
	}

	@Override
	protected Boolean pierdeCon(JugadaTrio otra) {
		return false;
	}


}
