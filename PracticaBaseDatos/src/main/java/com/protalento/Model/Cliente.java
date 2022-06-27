package com.protalento.Model;


public class Cliente {
	
	private Long idCliente = null;
	private String nombreCli;
	private String direccionCli;
	private String ciudadCli;
	private Long producto = null;
	/**
	 * 
	 */
	public Cliente() {
		super();
	}
		
	/**
	 * @param nombreCli
	 * @param direccionCli
	 * @param ciudadCli
	 * @param producto
	 */
	public Cliente(String nombreCli, String direccionCli, String ciudadCli, Long producto) {
		super();
		this.nombreCli = nombreCli;
		this.direccionCli = direccionCli;
		this.ciudadCli = ciudadCli;
		this.producto = producto;
	}


	/**
	 * @return the idCliente
	 */
	public Long getIdCliente() {
		return idCliente;
	}
	/**
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	/**
	 * @return the nombreCli
	 */
	public String getNombreCli() {
		return nombreCli;
	}
	/**
	 * @param nombreCli the nombreCli to set
	 */
	public void setNombreCli(String nombreCli) {
		this.nombreCli = nombreCli;
	}
	/**
	 * @return the direccionCli
	 */
	public String getDireccionCli() {
		return direccionCli;
	}
	/**
	 * @param direccionCli the direccionCli to set
	 */
	public void setDireccionCli(String direccionCli) {
		this.direccionCli = direccionCli;
	}
	/**
	 * @return the ciudadCli
	 */
	public String getCiudadCli() {
		return ciudadCli;
	}
	/**
	 * @param ciudadCli the ciudadCli to set
	 */
	public void setCiudadCli(String ciudadCli) {
		this.ciudadCli = ciudadCli;
	}
	/**
	 * @return the producto
	 */
	public Long getProducto() {
		return producto;
	}
	/**
	 * @param producto the producto to set
	 */
	public void setProducto(Long producto) {
		this.producto = producto;
	}
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombreCli=" + nombreCli + ", direccionCli=" + direccionCli
				+ ", ciudadCli=" + ciudadCli + ", producto=" + producto + "]";
	}
	
		
}
