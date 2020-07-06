package ar.unq.po2.tp05.sistemabancario;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private List<Cliente> clientes;
	private List<Solicitud> solicitudes;
	
	public Banco() {
		this.setClientes(new ArrayList<Cliente>());
		this.setSolicitudes(new ArrayList<Solicitud>());
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	private void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Solicitud> getSolicitudes() {
		return solicitudes;
	}

	private void setSolicitudes(List<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}
	
	public void agregarCliente(Cliente cliente) {
		this.getClientes().add(cliente);
	}
	
	public void agregarSolicitud(Solicitud solicitud) {
		this.getSolicitudes().add(solicitud);
	}
	
	public Float montoADesembolsar() {
		return this.getSolicitudes().stream()
				.filter(s -> s.esAceptable())
				.map(s -> s.getMonto())
				.reduce(0f, (a, b) -> a + b);
	}

}

