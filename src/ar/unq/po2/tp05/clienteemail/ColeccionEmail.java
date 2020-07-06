package ar.unq.po2.tp05.clienteemail;

import java.util.Collection;

public interface ColeccionEmail {
	
	public void borrarCorreo(Correo correo);

	public int contarBorrados();

	public int contarInbox();

	public void eliminarBorrado(Correo correo);
	
	public void agregarTodos(Collection<Correo> correos);
	
	public void agregar(Correo correo);

}
