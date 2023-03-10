package com.empleadok.dto;

import com.empleadok.model.Solicitud;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoDTO {
    private Long id;
    private Date fechaIngreso;
    private String nombre;
    private Integer salario;
    private Set<Solicitud> solicitudes;

}
