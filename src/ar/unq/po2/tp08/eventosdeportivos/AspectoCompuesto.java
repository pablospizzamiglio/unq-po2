package ar.unq.po2.tp08.eventosdeportivos;

import java.util.ArrayList;
import java.util.List;

public class AspectoCompuesto implements Aspecto {
	
	List<Aspecto> aspectos;

	public AspectoCompuesto() {
		this.setAspectos(new ArrayList<Aspecto>());
	}

	public List<Aspecto> getAspectos() {
		return aspectos;
	}

	private void setAspectos(List<Aspecto> aspectos) {
		this.aspectos = aspectos;
	}
	
	public void agregarAspecto(Aspecto aspecto) {
		this.getAspectos().add(aspecto);
	}
	
	public void removerAspecto(Aspecto aspecto) {
		this.getAspectos().remove(aspecto);
	}

	@Override
	public Boolean verificar(EventoDeportivo eventoDeportivo) {
		return this.getAspectos().stream()
				.anyMatch(c -> c.verificar(eventoDeportivo));
	}

}
