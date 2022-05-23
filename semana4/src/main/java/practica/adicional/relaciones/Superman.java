package practica.adicional.relaciones;

public class Superman extends Voladores{
	
	private String nacionalidad;

	/**
	 * 
	 */
	public Superman() {
		super();
	}

	/**
	 * @param nombre
	 * @param tipo
	 * @param peso
	 * @param nacionalidad
	 */
	public Superman(String nombre, String tipo, Integer peso) {
		super(nombre, tipo, peso);
		this.nacionalidad = nacionalidad;
	}

	/**
	 * @return the nacionalidad
	 */
	public String getNacionalidad() {
		return nacionalidad;
	}

	/**
	 * @param nacionalidad the nacionalidad to set
	 */
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	@Override
	public String toString() {
		return "Superman [nacionalidad=" + nacionalidad + "]";
	}
	
	

}
