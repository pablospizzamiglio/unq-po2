package ar.unq.po2.tp05.clienteemail;

import java.util.ArrayList;
import java.util.List;

public class ServidorPOP extends Servidor {

	public ServidorPOP(Conexion conexion, Almacenamiento almacenamiento) {
		super(conexion, almacenamiento);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void conectar(String user, String pass) {
		this.getConexion().conectar(user, pass); 
	}

	@Override
	public void resetear() {
		this.getConexion().resetear();
	}

	@Override
	public List<Correo> recibirNuevos(String user, String pass) {
		List<Correo> nuevos = new ArrayList<Correo>();
		if (this.getConexion().esValida()) {
			nuevos.addAll(this.getAlmacenamiento().recibirNuevos(user, pass));
		} else {
			System.out.println("Debe reconectarse");
		}
		return nuevos;
	}

	@Override
	public void enviar(Correo correo) {
		if (this.getConexion().esValida()) {
			this.getAlmacenamiento().enviar(correo);
		} else {
			System.out.println("Debe reconectarse");
		}
	}

	@Override
	public float tazaDeTransferencia() {
		return this.getAlmacenamiento().tazaDeTransferencia();
	}

	@Override
	public void realizarBackUp() {
		this.getAlmacenamiento().realizarBackUp();
	}

}
