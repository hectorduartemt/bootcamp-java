package practica.adicional.relaciones;

import practica.adicional.interfaces.Aterrizable;

public class Avion extends Transporte implements Aterrizable {
	
	private Integer distanciaVuelo;
	private Integer canTurbinas;
	/**
	 * 
	 */
	public Avion() {
		super();
	}
	/**
	 * @param nombre
	 * @param capacidadPas
	 * @param tipo
	 * @param peso
	 * @param cantPas
	 * @param modelo
	 * @param modOperacion
	 * @param distanciaVuelo
	 * @param canTurbinas
	 */
	public Avion(String nombre, String tipo, Integer peso) {
		super(nombre, tipo, peso);
		this.distanciaVuelo = distanciaVuelo;
		this.canTurbinas = canTurbinas;
	}
	/**
	 * @return the distanciaVuelo
	 */
	public Integer getDistanciaVuelo() {
		return distanciaVuelo;
	}
	/**
	 * @param distanciaVuelo the distanciaVuelo to set
	 */
	public void setDistanciaVuelo(Integer distanciaVuelo) {
		this.distanciaVuelo = distanciaVuelo;
	}
	/**
	 * @return the canTurbinas
	 */
	public Integer getCanTurbinas() {
		return canTurbinas;
	}
	/**
	 * @param canTurbinas the canTurbinas to set
	 */
	public void setCanTurbinas(Integer canTurbinas) {
		this.canTurbinas = canTurbinas;
	}
	
	@Override
	public String toString() {
		return "Avion [distanciaVuelo=" + distanciaVuelo + ", canTurbinas=" + canTurbinas + "]";
	}
	
	

}
