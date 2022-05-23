package practica.adicional.relaciones;

public abstract class Transporte extends Voladores {
	
	private Integer cantPas;
	private String modelo;
	private String modOperacion;
	/**
	 * 
	 */
	public Transporte() {
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
	 */
	public Transporte(String nombre, String tipo, Integer peso) {
		super(nombre, tipo, peso);
		this.cantPas = cantPas;
		this.modelo = modelo;
		this.modOperacion = modOperacion;
	}
	/**
	 * @return the cantPas
	 */
	public Integer getCantPas() {
		return cantPas;
	}
	/**
	 * @param cantPas the cantPas to set
	 */
	public void setCantPas(Integer cantPas) {
		this.cantPas = cantPas;
	}
	/**
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}
	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	/**
	 * @return the modOperacion
	 */
	public String getModOperacion() {
		return modOperacion;
	}
	/**
	 * @param modOperacion the modOperacion to set
	 */
	public void setModOperacion(String modOperacion) {
		this.modOperacion = modOperacion;
	}
	
	

}
