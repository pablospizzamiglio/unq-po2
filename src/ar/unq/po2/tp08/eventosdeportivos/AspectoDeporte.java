package ar.unq.po2.tp08.eventosdeportivos;

import java.util.List;

public class AspectoDeporte implements Aspecto {
	
	private List<String> deportes;

	public AspectoDeporte(List<String> deportes) {
		this.setDeportes(deportes);
	}

	private List<String> getDeportes() {
		return deportes;
	}

	private void setDeportes(List<String> deportes) {
		this.deportes = deportes;
	}

	@Override
	public Boolean verificar(EventoDeportivo eventoDeportivo) {
		return this.getDeportes().contains(eventoDeportivo.getDeporte());
	}

}
