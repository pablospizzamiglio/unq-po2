package ar.unq.po2.tp05.clienteemail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ConjuntoEmail implements ColeccionEmail {
	
	private List<Correo> inbox;
	private List<Correo> borrados;
	
	public ConjuntoEmail() {
		this.setInbox(new ArrayList<Correo>());
		this.setBorrados(new ArrayList<Correo>());
	}

	public List<Correo> getInbox() {
		return inbox;
	}

	private void setInbox(List<Correo> inbox) {
		this.inbox = inbox;
	}

	public List<Correo> getBorrados() {
		return borrados;
	}

	private void setBorrados(List<Correo> borrados) {
		this.borrados = borrados;
	}

	@Override
	public void borrarCorreo(Correo correo) {
		this.getInbox().remove(correo);
		this.getBorrados().add(correo);
	}

	@Override
	public int contarBorrados() {
		return this.getBorrados().size();
	}

	@Override
	public int contarInbox() {
		return this.getInbox().size();
	}

	@Override
	public void eliminarBorrado(Correo correo) {
		this.getBorrados().remove(correo);
	}

	@Override
	public void agregarTodos(Collection<Correo> correos) {
		this.getInbox().addAll(correos);		
	}

	@Override
	public void agregar(Correo correo) {
		this.getInbox().add(correo);		
	}

}
