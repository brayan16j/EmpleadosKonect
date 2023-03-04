package com.empleadok.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudDTO {

    private long id;
    private String codigo;
    private String descripcion;
    private String resumen;
}
