package ar.unq.po2.tp08.concurso;

import java.util.HashMap;
import java.util.Map;

public abstract class Concurso {

	private Map<String, String> enunciados;
	private Map<Participante, Integer> puntajes;

	public Concurso(Map<String, String> enunciados) {
		this.setEnunciados(enunciados);
		this.setPuntajes(new HashMap<Participante, Integer>());
	}

	protected Map<String, String> getEnunciados() {
		return enunciados;
	}

	private void setEnunciados(Map<String, String> enunciados) {
		this.enunciados = enunciados;
	}

	protected Map<Participante, Integer> getPuntajes() {
		return puntajes;
	}

	private void setPuntajes(Map<Participante, Integer> puntajes) {
		this.puntajes = puntajes;
	}
	
	// template method
	public void solicitarParticipacion(Participante participante) {
		if (this.puedeParticipar(participante)) {
			this.getPuntajes().put(participante, 0);
			this.notificarParticipantesIniciacionConcurso();
		} else {
			System.out.println("No hay más cupos o ya está inscripto");
		}
	}
	
	// primitive operation
	protected abstract Boolean puedeParticipar(Participante participante);
	
	// primitive operation
	protected abstract void notificarParticipantesIniciacionConcurso();
	
	// template method
	public void recibirSolucionEnunciado(Participante participante, String enunciado, String solucion) {
		if (this.puedeContestar(participante)) {
			Boolean esSolucionValida = this.esSolucionValida(enunciado, solucion);
			participante.recibirNotificacionValidezSolucion(enunciado, esSolucionValida);
			
			if (esSolucionValida) {
				this.notificarParticipantesEnunciadoResuelto(participante, enunciado);
				this.getPuntajes().merge(participante, 1, Integer::sum);
				if (this.esGanador(participante)) {
					this.notificarParticipantesGanador(participante);
				}
			}
		} else {
			System.out.println("La partida no inició, ya finalizó o usted no es un participante válido");
		}
		
	}
	
	// primitive operation
	protected abstract Boolean puedeContestar(Participante participante);
	
	// primitive operation
	protected abstract Boolean esSolucionValida(String enunciado, String solucion);
	
	// primitive operation
	protected abstract Boolean esGanador(Participante participante);
	
	// hook method
	protected void notificarParticipantesEnunciadoResuelto(Participante participante, String enunciado) {
		this.getPuntajes().keySet().stream()
			.forEach(p -> p.recibirNotificacionEnunciadoResuelto(participante.getNombre(), enunciado));
	}
	
	// hook method
	protected void notificarParticipantesGanador(Participante participante) {
		this.getPuntajes().keySet().stream()
			.forEach(p -> p.recibirNotificacionGanador(participante.getNombre()));
	}

}
