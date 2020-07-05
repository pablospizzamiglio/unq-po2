package ar.unq.po2.tp08.concurso;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Jugador extends Participante {

	public Jugador(String nombre, Concurso concurso) {
		super(nombre, concurso);
	}

	@Override
	public void recibirNotificacionAceptacion(Set<String> enunciados) {
		Map<String, Boolean> estadoPorEnunciado = new HashMap<String, Boolean>();
		enunciados.forEach(e -> estadoPorEnunciado.put(e, false));
		this.setEnunciados(estadoPorEnunciado);		
		this.setEstaListo(true);
	}

	@Override
	public void recibirNotificacionValidezSolucion(String enunciado, Boolean esValido) {
		this.getEnunciados().put(enunciado, esValido);
	}

	@Override
	public void recibirNotificacionEnunciadoResuelto(String nombre, String enunciado) {
		System.out.println("Concursante " + nombre + " resolvió el enunciado: " + enunciado);		
	}

	@Override
	public void recibirNotificacionGanador(String nombre) {
		System.out.println("Concursante " + nombre + " es el ganador!");
	}

}
