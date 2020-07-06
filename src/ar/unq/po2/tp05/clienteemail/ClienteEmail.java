package ar.unq.po2.tp05.clienteemail;

import java.util.List;

public class ClienteEmail {
	
	private String user;
	private String pass;
	private Servidor servidor;
	private ColeccionEmail emails;
	
	public ClienteEmail(String user, String pass, Servidor servidor, ColeccionEmail emails) {
		this.setUser(user);
		this.setPass(pass);
		this.setServidor(servidor);
		this.setEmails(emails);
		this.conectar();
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public Servidor getServidor() {
		return servidor;
	}
	
	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}
	
	public ColeccionEmail getEmails() {
		return emails;
	}
	
	public void setEmails(ColeccionEmail emails) {
		this.emails = emails;
	}
	
	public void conectar() {
		this.getServidor().conectar(this.user, this.pass);
	}
	
	public void borrarCorreo(Correo correo) {
		this.getEmails().borrarCorreo(correo);
	}
	
	public int contarBorrados() {
		return this.getEmails().contarBorrados();
	}
	
	public int contarInbox() {
		return this.getEmails().contarInbox();
	}
	
	public void eliminarBorrado(Correo correo) {
		this.getEmails().eliminarBorrado(correo);
	}
	
	public void recibirNuevos() {
		List<Correo> correos = this.servidor.recibirNuevos(this.getUser(), this.getPass());
		this.getEmails().agregarTodos(correos);
	}
	
	public void enviarCorreo(String asunto, List<String> destinatarios, String cuerpo){
		Correo correo = new Correo(asunto, destinatarios, cuerpo);
		this.servidor.enviar(correo);
	}

}
