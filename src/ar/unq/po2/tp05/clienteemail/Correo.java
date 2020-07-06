package ar.unq.po2.tp05.clienteemail;

import java.util.List;

public class Correo {
	
	private String asunto;
	private List<String> destinatarios;
	private String cuerpo;
	
	public Correo(String asunto, List<String> destinatarios, String cuerpo) {
		this.setAsunto(asunto);
		this.setDestinatarios(destinatarios);
		this.setCuerpo(cuerpo);
	}

	public String getAsunto() {
		return asunto;
	}

	private void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public List<String> getDestinatarios() {
		return destinatarios;
	}

	private void setDestinatarios(List<String> destinatarios) {
		this.destinatarios = destinatarios;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	private void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}
	
	

}
