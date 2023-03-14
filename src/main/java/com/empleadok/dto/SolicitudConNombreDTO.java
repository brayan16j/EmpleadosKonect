package com.empleadok.dto;

import com.empleadok.model.Solicitud;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudConNombreDTO {

    private Solicitud solicitud;
    private String nombreEmpleado;
}
