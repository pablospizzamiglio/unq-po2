package ar.unq.po2.tp05.clienteemail;

import java.util.List;

public interface Almacenamiento {
	
	public List<Correo> recibirNuevos(String user, String pass);
	
	public void enviar(Correo correo);

	public float tazaDeTransferencia();
	
	public void realizarBackUp();

}
