package ar.unq.po2.tp07.pokerjugadas;

public class Carta {
	
	private CartaPalo palo;
	private CartaValor valor;

	public Carta(CartaPalo palo, CartaValor valor) {
		this.setPalo(palo);
		this.setValor(valor);
	}

	public CartaPalo getPalo() {
		return palo;
	}

	private void setPalo(CartaPalo palo) {
		this.palo = palo;
	}

	public CartaValor getValor() {
		return valor;
	}
	
	private void setValor(CartaValor valor) {
		this.valor = valor;
	}

	public Boolean mismoPalo(Carta otraCarta) {
		return this.getPalo() == otraCarta.getPalo();
	}
	
	public Boolean esDeMayorValor(Carta otraCarta) {
		return this.getValor().ordinal() > otraCarta.getValor().ordinal();
	}	
	
}
