package ar.unq.po2.tp09.videojuego;

public class EstadoInicial implements Estado {

	public EstadoInicial() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void iniciar(Videojuego videojuego) {
		if (videojuego.getFichas() == 0) {
			System.out.println("Ingresa una ficha");
		} else if (videojuego.getFichas() == 1) {
			videojuego.descontarFichas(1);
			videojuego.setEstado(new EstadoJuegaUno());
		} else if (videojuego.getFichas() == 2) {
			videojuego.descontarFichas(2);
			videojuego.setEstado(new EstadoJueganDos());
		}
	}

	@Override
	public void finalizar(Videojuego videojuego) {
		// No puede finalizar un juego que no comenzó
	}

}
