package ar.unq.po2.tp09.videojuego;

public class EstadoJuegaUno implements Estado {
	
	public EstadoJuegaUno() {
		System.out.println("Partida de 1 jugador en curso");
	}

	@Override
	public void iniciar(Videojuego videojuego) {
		System.out.println("Partida de 1 jugador en curso");
	}

	@Override
	public void finalizar(Videojuego videojuego) {
		System.out.println("Juego finalizado");
		videojuego.setEstado(new EstadoInicial());
	}

}
