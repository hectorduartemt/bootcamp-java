package com.protalento.Model;

public class Producto {
	
	private Long idProducto = null;
	private String numProducto;
	private String tipoProducto;
	private Long cliente;
	/**
	 * 
	 */
	public Producto() {
		super();
	}
	
	
	/**
	 * @param numProducto
	 * @param tipoProducto
	 * @param cliente
	 */
	public Producto(String numProducto, String tipoProducto, Long cliente) {
		super();
		this.numProducto = numProducto;
		this.tipoProducto = tipoProducto;
		this.cliente = cliente;
	}


	/**
	 * @return the idProducto
	 */
	public Long getIdProducto() {
		return idProducto;
	}
	/**
	 * @param idProducto the idProducto to set
	 */
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}
	/**
	 * @return the numProducto
	 */
	public String getNumProducto() {
		return numProducto;
	}
	/**
	 * @param numProducto the numProducto to set
	 */
	public void setNumProducto(String numProducto) {
		this.numProducto = numProducto;
	}
	/**
	 * @return the tipoProducto
	 */
	public String getTipoProducto() {
		return tipoProducto;
	}
	/**
	 * @param tipoProducto the tipoProducto to set
	 */
	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	/**
	 * @return the cliente
	 */
	public Long getCliente() {
		return cliente;
	}
	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}
	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", numProducto=" + numProducto + ", tipoProducto=" + tipoProducto
				+ ", cliente=" + cliente + "]";
	}
	
		

}
