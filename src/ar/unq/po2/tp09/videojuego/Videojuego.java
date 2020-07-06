package ar.unq.po2.tp09.videojuego;

public class Videojuego {
	
	private Integer fichas;
	private Estado estado;

	public Videojuego() {
		this.setFichas(0);
		this.setEstado(new EstadoInicial());
	}

	public Integer getFichas() {
		return fichas;
	}

	private void setFichas(Integer fichas) {
		this.fichas = fichas;
	}

	private Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public void iniciar() {
		this.getEstado().iniciar(this);
	}
	
	public void ingresarFicha() {
		this.setFichas(this.getFichas() + 1);
		System.out.println(this.getFichas() + " crédito(s)");
	}
	
	public void descontarFichas(Integer n) {
		if (this.getFichas() >= n) {
			this.setFichas(this.getFichas() - n);
		}
	}
	
	public void finalizar() {
		this.getEstado().finalizar(this);
	}

}
