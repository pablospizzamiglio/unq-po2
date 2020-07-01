package ar.unq.po2.tp08.cultivosalterados;

public class CultivoSimple extends Cultivo {
	
	public Float ganancia;

	public CultivoSimple(String tipo, Float ganancia) {
		super(tipo);
		this.setGanancia(ganancia);
	}
	
	private void setGanancia(Float ganancia) {
		this.ganancia = ganancia;
	}

	@Override
	public Float getGanancia() {
		return this.ganancia;
	}

}
