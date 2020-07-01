package ar.unq.po2.tp08.cultivosalterados;

import java.util.ArrayList;
import java.util.List;

public class CultivoMixto extends Cultivo {
	
	List<Cultivo> cultivos;

	public CultivoMixto(String tipo) {
		super(tipo);
		this.setCultivos(new ArrayList<Cultivo>());
	}

	public List<Cultivo> getCultivos() {
		return cultivos;
	}
	
	private void setCultivos(List<Cultivo> cultivos) {
		this.cultivos = cultivos;
	}
	
	public void agregarCultivo(Cultivo cultivo) {
		if (this.puedeAgregar(cultivo)) {
			this.getCultivos().add(cultivo);
		}
	}
	
	private Boolean puedeAgregar(Cultivo cultivo) {
		Long numeroCultivosDelMismoTipo = this.getCultivos().stream()
				.filter(c -> c.getTipo() == cultivo.getTipo())
				.count();
		return this.getCultivos().size() < 4 && numeroCultivosDelMismoTipo < 3;
	}
	
	public void removerCultivo(Cultivo cultivo) {
		this.getCultivos().remove(cultivo);
	}
	
	@Override
	public Float getGanancia() {
		return this.getCultivos().stream()
				.map(c -> c.getGanancia() / 4)
				.reduce(0f, (a, b) -> a + b);
	}

}
