package com.empleadok.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "empleado")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Empleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "FECHA_INGRESO", nullable = false)
    private Date fechaIngreso;
    @Column(name = "NOMBRE", length = 50, nullable = false)
    private String nombre;
    @Column(name = "SALARIO", nullable = false)
    private Integer salario;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference
    public Set<Solicitud> solicitudes = new HashSet<>();



}
