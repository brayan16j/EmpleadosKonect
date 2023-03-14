package com.empleadok.service;

import com.empleadok.dto.SolicitudConNombreDTO;
import com.empleadok.dto.SolicitudDTO;

import java.util.List;


public interface SolicitudServicio {

    public SolicitudDTO crearSolicitud(long empleadoId, SolicitudDTO solicitudDTO);

    public List<SolicitudDTO> obtenerTodosSolicitudes();

    public List<SolicitudDTO> obtenerSolicitudPorEmpleadoId(long empleadoId);

    public SolicitudDTO obtenerSolicitud(long id);

    public List<SolicitudConNombreDTO> obtenerTodasSolicitudesConNombreEmpleado();

    public void eliminarSolicitud (Long solicitudId);

    public SolicitudDTO actualizarSolicitud(Long solicitudId, SolicitudDTO solicitudDeSolicitud);
}
