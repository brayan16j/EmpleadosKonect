package com.empleadok.service;

import com.empleadok.dto.SolicitudDTO;
import com.empleadok.excepciones.ResourceNotFoundException;
import com.empleadok.model.Empleado;
import com.empleadok.model.Solicitud;
import com.empleadok.repository.EmpleadoRepository;
import com.empleadok.repository.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SolicitudServicioImpl implements SolicitudServicio{

    @Autowired
    private SolicitudRepository solicitudRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public SolicitudDTO crearSolicitud(long empleadoId, SolicitudDTO solicitudDTO) {
        Solicitud solicitud = mapearEntidad(solicitudDTO);
        Empleado empleado = empleadoRepository.findById(empleadoId).
                orElseThrow(() -> new ResourceNotFoundException("Empleado", "id", empleadoId));

        solicitud.setEmpleado(empleado);
        Solicitud nuevaSolicitud = solicitudRepository.save(solicitud);
        return mapearDTO(nuevaSolicitud);

    }

    @Override
    public List<SolicitudDTO> obtenerTodosSolicitudes() {
        List<Solicitud> ListaSolicitudes = solicitudRepository.findAll();
        return ListaSolicitudes.stream().map(solicitud -> mapearDTO(solicitud)).collect(Collectors.toList());
    }

    @Override
    public List<SolicitudDTO> obtenerSolicitudPorEmpleadoId(long empleadoId) {
        List<Solicitud> solicitudes = solicitudRepository.findByEmpleadoId(empleadoId);
        return solicitudes.stream().map(solicitud -> mapearDTO(solicitud)).collect(Collectors.toList());

    }

    private SolicitudDTO mapearDTO(Solicitud solicitud){
        SolicitudDTO solicitudDTO = new SolicitudDTO();
        solicitudDTO.setId(solicitud.getId());
        solicitudDTO.setCodigo(solicitud.getCodigo());
        solicitudDTO.setDescripcion(solicitud.getDescripcion());
        solicitudDTO.setResumen(solicitud.getResumen());

        return solicitudDTO;
    }
    private Solicitud mapearEntidad(SolicitudDTO solicitudDTO){
        Solicitud solicitud = new Solicitud();
        solicitud.setId(solicitudDTO.getId());
        solicitud.setCodigo(solicitudDTO.getCodigo());
        solicitud.setDescripcion(solicitudDTO.getDescripcion());
        solicitud.setResumen(solicitudDTO.getResumen());
        return solicitud;
    }
}
