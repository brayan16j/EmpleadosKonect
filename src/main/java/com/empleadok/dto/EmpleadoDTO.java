package com.empleadok.dto;

import com.empleadok.model.Solicitud;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

//@Setter
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
public class EmpleadoDTO {
    private Long id;
    private Date fechaIngreso;
    private String nombre;
    private Integer salario;
    private Set<Solicitud> solicitudes;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getSalario() {
		return salario;
	}
	public void setSalario(Integer salario) {
		this.salario = salario;
	}
	public Set<Solicitud> getSolicitudes() {
		return solicitudes;
	}
	public void setSolicitudes(Set<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}

}
