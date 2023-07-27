package com.empleadok.dto;

import com.empleadok.model.Solicitud;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Setter
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
public class SolicitudConNombreDTO {

    private Solicitud solicitud;
    private String nombreEmpleado;
    
	public SolicitudConNombreDTO(Solicitud solicitud, String nombreEmpleado) {
		this.solicitud = solicitud;
		this.nombreEmpleado = nombreEmpleado;
	}
	public Solicitud getSolicitud() {
		return solicitud;
	}
	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}
	public String getNombreEmpleado() {
		return nombreEmpleado;
	}
	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}
    
}
