package ar.unq.po2.tp09.videojuego;

public class EstadoJueganDos implements Estado {
	
	public EstadoJueganDos() {
		System.out.println("Partida de 2 jugadores en curso");
	}

	@Override
	public void iniciar(Videojuego videojuego) {
		System.out.println("Partida de 2 jugadores en curso");
	}

	@Override
	public void finalizar(Videojuego videojuego) {
		System.out.println("Juego finalizado");
		videojuego.setEstado(new EstadoInicial());
	}

}
