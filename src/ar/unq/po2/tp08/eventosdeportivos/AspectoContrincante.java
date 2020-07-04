package ar.unq.po2.tp08.eventosdeportivos;

import java.util.ArrayList;
import java.util.List;

public class AspectoContrincante implements Aspecto {
	
	private List<String> contrincantes;

	public AspectoContrincante(List<String> contrincantes) {
		this.setContrincantes(contrincantes);
	}

	private List<String> getContrincantes() {
		return contrincantes;
	}

	private void setContrincantes(List<String> contrincantes) {
		this.contrincantes = contrincantes;
	}

	@Override
	public Boolean verificar(EventoDeportivo eventoDeportivo) {
		List<String> contrincantesInteresantes = new ArrayList<String>(this.getContrincantes());
		return contrincantesInteresantes.retainAll(eventoDeportivo.getContrincantes());
	}

}
