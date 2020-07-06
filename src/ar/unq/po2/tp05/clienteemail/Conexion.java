package ar.unq.po2.tp05.clienteemail;

public interface Conexion {
	
	public void conectar(String user, String pass);
	
	public void resetear();
	
	public boolean esValida();

}
