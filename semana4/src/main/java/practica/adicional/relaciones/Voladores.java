package practica.adicional.relaciones;

public class Voladores {
	
	private String nombre;
	private String tipo;
	private Integer peso;
	/**
	 * 
	 */
	public Voladores() {
		super();
	}
	/**
	 * @param nombre
	 * @param tipo
	 * @param peso
	 */
	public Voladores(String nombre, String tipo, Integer peso) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.peso = peso;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return the peso
	 */
	public Integer getPeso() {
		return peso;
	}
	/**
	 * @param peso the peso to set
	 */
	public void setPeso(Integer peso) {
		this.peso = peso;
	}
	
	
	

}
