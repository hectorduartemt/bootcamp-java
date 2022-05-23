package practica.adicional.relaciones;

public class Ovni extends Voladores{
	
	private String avistamiento;

	/**
	 * 
	 */
	public Ovni() {
		super();
	}

	/**
	 * @param nombre
	 * @param tipo
	 * @param peso
	 * @param avistamiento
	 */
	public Ovni(String nombre, String tipo, Integer peso) {
		super(nombre, tipo, peso);
		this.avistamiento = avistamiento;
	}

	/**
	 * @return the avistamiento
	 */
	public String getAvistamiento() {
		return avistamiento;
	}

	/**
	 * @param avistamiento the avistamiento to set
	 */
	public void setAvistamiento(String avistamiento) {
		this.avistamiento = avistamiento;
	}

	@Override
	public String toString() {
		return "Ovni [avistamiento=" + avistamiento + "]";
	}
	
	

}
