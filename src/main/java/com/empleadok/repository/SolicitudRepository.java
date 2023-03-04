package com.empleadok.repository;

import com.empleadok.model.Empleado;
import com.empleadok.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {

    public List<Solicitud> findByEmpleadoId(long empleadoId);

    public Empleado findByEmpleado_Nombre(String nombre);

}
