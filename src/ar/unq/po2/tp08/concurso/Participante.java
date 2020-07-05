package ar.unq.po2.tp08.concurso;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
//import java.util.Map.Entry;
import java.util.Set;

public abstract class Participante {
	
	private String nombre;
	private Boolean estaListo;
	private Concurso concurso;
	private Map<String, Boolean> enunciados;

	public Participante(String nombre, Concurso concurso) {
		this.setNombre(nombre);
		this.setEstaListo(false);
		this.setConcurso(concurso);
		this.setEnunciados(new HashMap<String, Boolean>());
		this.getConcurso().solicitarParticipacion(this);
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	protected Boolean estaListo() {
		return estaListo;
	}

	protected void setEstaListo(Boolean estaListo) {
		this.estaListo = estaListo;
	}

	private Concurso getConcurso() {
		return concurso;
	}

	private void setConcurso(Concurso concurso) {
		this.concurso = concurso;
	}

	protected Map<String, Boolean> getEnunciados() {
		return enunciados;
	}

	protected void setEnunciados(Map<String, Boolean> enunciados) {
		this.enunciados = enunciados;
	}
	
//	public void resolverEnunciados() throws IOException {
//		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
//		String solucion;
//		if (this.estaListo() && this.hayEnunciadosSinResolver()) {
//			for (Entry<String, Boolean> enunciado : this.getEnunciados().entrySet()) {
//				if (!enunciado.getValue()) {
//					System.out.println(enunciado.getKey());
//					solucion = lector.readLine();
//					this.enviarSolucion(enunciado.getKey(), solucion);
//				}
//			}
//		} else {
//			System.out.println("No inició el concurso o no hay más enunciados para resolver");
//		}
//	}
//	
//	private Boolean hayEnunciadosSinResolver() {
//		return this.getEnunciados().values().contains(false);
//	}
	
	public void enviarSolucion(String enunciado, String solucion) {
		this.getConcurso().recibirSolucionEnunciado(this, enunciado, solucion);
	}

	public abstract void recibirNotificacionAceptacion(Set<String> enunciados);
	
	public abstract void recibirNotificacionValidezSolucion(String enunciado, Boolean esValido);
	
	public abstract void recibirNotificacionEnunciadoResuelto(String nombre, String enunciado);

	public abstract void recibirNotificacionGanador(String nombre);

}
