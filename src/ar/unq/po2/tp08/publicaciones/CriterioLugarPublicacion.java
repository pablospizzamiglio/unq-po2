package ar.unq.po2.tp08.publicaciones;

public class CriterioLugarPublicacion implements Criterio {

	private String lugarPublicacion;
	
	public CriterioLugarPublicacion(String lugarPublicacion) {
		this.setLugarPublicacion(lugarPublicacion);
	}

	private String getLugarPublicacion() {
		return lugarPublicacion;
	}

	private void setLugarPublicacion(String lugarPublicacion) {
		this.lugarPublicacion = lugarPublicacion;
	}

	@Override
	public Boolean esDeInteres(Articulo articulo) {
		return this.getLugarPublicacion().equalsIgnoreCase(articulo.getLugarPublicacion());
	}

}

