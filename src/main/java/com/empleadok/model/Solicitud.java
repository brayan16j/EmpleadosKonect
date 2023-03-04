package com.empleadok.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "solicitud")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Solicitud implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "CODIGO",length = 50, nullable = false)
    private String codigo;
    @Column(name = "DESCRIPCION", length = 50, nullable = false)
    private String descripcion;
    @Column(name = "RESUMEN", length = 50, nullable = false)
    private String resumen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_EMPLEADO", nullable = false)
    @JsonBackReference
    private Empleado empleado;


}
