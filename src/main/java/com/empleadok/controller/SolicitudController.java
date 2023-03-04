package com.empleadok.controller;

import com.empleadok.dto.SolicitudDTO;
import com.empleadok.service.SolicitudServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solicitud")
@CrossOrigin(origins = "*")
public class SolicitudController {

    @Autowired
    private SolicitudServicio solicitudServicio;

    @GetMapping("/all")
    public List<SolicitudDTO> listarEmpleados(){
        return solicitudServicio.obtenerTodosSolicitudes();
    }

    @GetMapping("/empleado/{empleadoId}/solicitud")
    public List<SolicitudDTO> listarSolicitudesPorEmpleadoId(@PathVariable(value = "empleadoId") long empleadoId){
        return solicitudServicio.obtenerSolicitudPorEmpleadoId(empleadoId);
    }

    @PostMapping("/empleado/{empleadoId}")
    public ResponseEntity<SolicitudDTO> guardarSolicitud(@PathVariable(value = "empleadoId") long empleadoId, @RequestBody SolicitudDTO solicitudDTO){
        return new ResponseEntity<>(solicitudServicio.crearSolicitud(empleadoId, solicitudDTO), HttpStatus.CREATED);

    }

}
