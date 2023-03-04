package com.empleadok.service;

import com.empleadok.dto.EmpleadoDTO;

import java.util.List;

public interface EmpleadoServicio {

    public EmpleadoDTO crearEmpleado(EmpleadoDTO empleadoDTO);

    public List<EmpleadoDTO> obtenerTodosEmpleados();

    public EmpleadoDTO obtenerEmpleadoPorId (long id);

    public EmpleadoDTO actualizarEmpleado(EmpleadoDTO empleadoDTO, long id);

    public void eliminarEmpleado(long id);

}
