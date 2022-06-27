package com.protalento.Model;

public class Sucursal {

	private String nombreSuc;
	private String ciudadSuc;
	private Long empleado;
	
	
	public Sucursal() {
		super();
	}


	/**
	 * @param nombreSuc
	 * @param ciudadSuc
	 * @param empleado
	 */
	public Sucursal(String nombreSuc, String ciudadSuc, Long empleado) {
		super();
		this.nombreSuc = nombreSuc;
		this.ciudadSuc = ciudadSuc;
		this.empleado = empleado;
	}


	/**
	 * @return the nombreSuc
	 */
	public String getNombreSuc() {
		return nombreSuc;
	}


	/**
	 * @param nombreSuc the nombreSuc to set
	 */
	public void setNombreSuc(String nombreSuc) {
		this.nombreSuc = nombreSuc;
	}


	/**
	 * @return the ciudadSuc
	 */
	public String getCiudadSuc() {
		return ciudadSuc;
	}


	/**
	 * @param ciudadSuc the ciudadSuc to set
	 */
	public void setCiudadSuc(String ciudadSuc) {
		this.ciudadSuc = ciudadSuc;
	}


	/**
	 * @return the empleado
	 */
	public Long getEmpleado() {
		return empleado;
	}


	/**
	 * @param empleado the empleado to set
	 */
	public void setEmpleado(Long empleado) {
		this.empleado = empleado;
	}


	@Override
	public String toString() {
		return "Sucursal [nombreSuc=" + nombreSuc + ", ciudadSuc=" + ciudadSuc + ", empleado=" + empleado + "]";
	}


	
	
}
