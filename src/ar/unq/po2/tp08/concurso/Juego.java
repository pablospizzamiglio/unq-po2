package ar.unq.po2.tp08.concurso;

import java.util.Collections;
import java.util.Map;

public class Juego extends Concurso {
	
	public Juego(Map<String, String> enunciados) {
		super(enunciados);
	}
	
	// primitive operation - especializada
	protected Boolean puedeParticipar(Participante participante) { 
		return !this.getPuntajes().containsKey(participante) 
				&& this.getPuntajes().size() < 5;
	}
	
	// primitive operation - especializada
	protected void notificarParticipantesIniciacionConcurso() {
		if (this.getPuntajes().size() == 5) { 
			this.getPuntajes().keySet().forEach(
					p -> p.recibirNotificacionAceptacion(this.getEnunciados().keySet())
			);
		}
	}
	
	// primitive operation - especializada
	protected Boolean puedeContestar(Participante participante) {
		return this.getPuntajes().size() == 5
				&& this.getPuntajes().containsKey(participante) 
				&& Collections.max(this.getPuntajes().values()) < 5;
	}
	
	// primitive operation - especializada
	protected Boolean esSolucionValida(String enunciado, String solucion) {
		return this.getEnunciados().containsKey(enunciado) 
				&& this.getEnunciados().get(enunciado).equalsIgnoreCase(solucion);
	}
	
	// primitive operation - especializada
	protected Boolean esGanador(Participante participante) {
		return this.getPuntajes().get(participante) == 5;
	}

}
