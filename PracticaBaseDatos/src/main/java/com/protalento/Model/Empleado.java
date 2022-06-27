package com.protalento.Model;

import java.time.LocalDateTime;


public class Empleado {
	
	private Long idEmpleado = null;
	private String nombreEmp;
	private String telefonoEmp;
	private String subordinadosEmp;
	private LocalDateTime fechaIngresoEmp;
	private Long idSupervisor;
	private Long cliente;
	/**
	 * 
	 */
	public Empleado() {
		super();
	}
	
	/**
	 * @param nombreEmp
	 * @param telefonoEmp
	 * @param subordinadosEmp
	 * @param fechaIngresoEmp
	 * @param idSupervisor
	 * @param cliente
	 */
	public Empleado(String nombreEmp, String telefonoEmp, String subordinadosEmp, LocalDateTime fechaIngresoEmp,
			Long idSupervisor, Long cliente) {
		super();
		this.nombreEmp = nombreEmp;
		this.telefonoEmp = telefonoEmp;
		this.subordinadosEmp = subordinadosEmp;
		this.fechaIngresoEmp = fechaIngresoEmp;
		this.idSupervisor = idSupervisor;
		this.cliente = cliente;
	}



	/**
	 * @return the idEmpleado
	 */
	public Long getIdEmpleado() {
		return idEmpleado;
	}
	/**
	 * @param idEmpleado the idEmpleado to set
	 */
	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	/**
	 * @return the nombreEmp
	 */
	public String getNombreEmp() {
		return nombreEmp;
	}
	/**
	 * @param nombreEmp the nombreEmp to set
	 */
	public void setNombreEmp(String nombreEmp) {
		this.nombreEmp = nombreEmp;
	}
	/**
	 * @return the telefonoEmp
	 */
	public String getTelefonoEmp() {
		return telefonoEmp;
	}
	/**
	 * @param telefonoEmp the telefonoEmp to set
	 */
	public void setTelefonoEmp(String telefonoEmp) {
		this.telefonoEmp = telefonoEmp;
	}
	/**
	 * @return the subordinadosEmp
	 */
	public String getSubordinadosEmp() {
		return subordinadosEmp;
	}
	/**
	 * @param subordinadosEmp the subordinadosEmp to set
	 */
	public void setSubordinadosEmp(String subordinadosEmp) {
		this.subordinadosEmp = subordinadosEmp;
	}
	/**
	 * @return the fechaIngresoEmp
	 */
	public LocalDateTime getFechaIngresoEmp() {
		return fechaIngresoEmp;
	}
	/**
	 * @param fechaIngresoEmp the fechaIngresoEmp to set
	 */
	public void setFechaIngresoEmp(LocalDateTime fechaIngresoEmp) {
		this.fechaIngresoEmp = fechaIngresoEmp;
	}
	/**
	 * @return the idSupervisor
	 */
	public Long getIdSupervisor() {
		return idSupervisor;
	}
	/**
	 * @param idSupervisor the idSupervisor to set
	 */
	public void setIdSupervisor(Long idSupervisor) {
		this.idSupervisor = idSupervisor;
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
		return "Empleado [idEmpleado=" + idEmpleado + ", nombreEmp=" + nombreEmp + ", telefonoEmp=" + telefonoEmp
				+ ", subordinadosEmp=" + subordinadosEmp + ", fechaIngresoEmp=" + fechaIngresoEmp + ", idSupervisor="
				+ idSupervisor + ", cliente=" + cliente + "]";
	}
	
	
	
		
}
