package practica.adicional.relaciones;

import practica.adicional.interfaces.Aterrizable;

public class Helicoptero extends Transporte implements Aterrizable{
	
	private Integer aspaRotor;

	/**
	 * 
	 */
	public Helicoptero() {
		super();
	}

	/**
	 * @param nombre
	 * @param tipo
	 * @param peso
	 * @param cantPas
	 * @param modelo
	 * @param modOperacion
	 * @param aspaRotor
	 */
	public Helicoptero(String nombre, String tipo, Integer peso) {
		super(nombre, tipo, peso);
		this.aspaRotor = aspaRotor;
	}

	/**
	 * @return the aspaRotor
	 */
	public Integer getAspaRotor() {
		return aspaRotor;
	}

	/**
	 * @param aspaRotor the aspaRotor to set
	 */
	public void setAspaRotor(Integer aspaRotor) {
		this.aspaRotor = aspaRotor;
	}

	@Override
	public String toString() {
		return "Helicoptero [aspaRotor=" + aspaRotor + "]";
	}
	
	
}
