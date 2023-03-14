package com.empleadok.service;

import com.empleadok.dto.EmpleadoDTO;
import com.empleadok.excepciones.ResourceNotFoundException;
import com.empleadok.model.Empleado;
import com.empleadok.repository.EmpleadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpleadoServicioImpl implements EmpleadoServicio {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public EmpleadoDTO crearEmpleado(EmpleadoDTO empleadoDTO) {
        Empleado empleado = mapearEntidad(empleadoDTO);
        Empleado nuevoEmpleado = empleadoRepository.save(empleado);

        EmpleadoDTO empleadoRespuesta = mapearDTO(nuevoEmpleado);
        return empleadoRespuesta;
    }

    @Override
    public List<EmpleadoDTO> obtenerTodosEmpleados() {
        List<Empleado> ListaEmpleados = empleadoRepository.findAll();
        return ListaEmpleados.stream().map(empleado -> mapearDTO(empleado)).collect(Collectors.toList());
    }

    @Override
    public EmpleadoDTO obtenerEmpleadoPorId(long id) {
        Empleado empleado = empleadoRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Empleado", "id", id));
        return mapearDTO(empleado);
    }

    @Override
    public EmpleadoDTO actualizarEmpleado(EmpleadoDTO empleadoDTO, long id) {
        Empleado empleado = empleadoRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Empleado", "id", id));

        empleado.setId(empleado.getId());
        empleado.setFechaIngreso(empleadoDTO.getFechaIngreso());
        empleado.setNombre(empleadoDTO.getNombre());
        empleado.setSalario(empleadoDTO.getSalario());
        Empleado empleadoActualiazdo = empleadoRepository.save(empleado);
        return mapearDTO(empleadoActualiazdo);
    }

    @Override
    public void eliminarEmpleado(long id) {
        Empleado empleado = empleadoRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Empleado", "id", id));
        empleadoRepository.delete(empleado);
    }

    // Este Metodo convierte entidad a DTO Haciendo uso de denpendencia Maven ModelMaper
    private EmpleadoDTO mapearDTO(Empleado empleado) {
        EmpleadoDTO empleadoDTO= modelMapper.map(empleado, EmpleadoDTO.class);
        return empleadoDTO;
    }

    // Convierte de DTO a Entidad
    private Empleado mapearEntidad(EmpleadoDTO empleadoDTO) {
        Empleado empleado = modelMapper.map(empleadoDTO, Empleado.class);
        return empleado;
    }
}
