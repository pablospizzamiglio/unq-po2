package ar.unq.po2.tp05.clienteemail;

import java.util.List;

public abstract class Servidor {
	
	private Conexion conexion;
	private Almacenamiento almacenamiento;
	
	public Servidor(Conexion conexion, Almacenamiento almacenamiento) {
		this.setConexion(conexion);
		this.setAlmacenamiento(almacenamiento);
	}

	public Conexion getConexion() {
		return conexion;
	}

	private void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}

	public Almacenamiento getAlmacenamiento() {
		return almacenamiento;
	}

	private void setAlmacenamiento(Almacenamiento almacenamiento) {
		this.almacenamiento = almacenamiento;
	}
	
	public abstract void conectar(String user, String pass);
	
	public abstract void resetear();
	
	public abstract List<Correo> recibirNuevos(String user, String pass);
	
	public abstract void enviar(Correo correo);
	
	public abstract float tazaDeTransferencia();
	
	public abstract void realizarBackUp();

}
