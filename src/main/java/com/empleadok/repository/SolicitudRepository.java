package com.empleadok.repository;

import com.empleadok.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {

    public List<Solicitud> findByEmpleadoId(long empleadoId);

    @Query("SELECT s, e.nombre FROM Solicitud s INNER JOIN s.empleado e")
    List<Object[]> findAllSolicitudesWithNombreEmpleado();


}
