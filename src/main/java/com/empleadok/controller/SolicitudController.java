package com.empleadok.controller;

import com.empleadok.dto.SolicitudConNombreDTO;
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
    public List<SolicitudConNombreDTO> listarSolicitudes() {
        return solicitudServicio.obtenerTodasSolicitudesConNombreEmpleado();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitudDTO> obtenerSolicitudPorId(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(solicitudServicio.obtenerSolicitud(id));
    }

    /*
        @GetMapping("/all")
        public List<SolicitudDTO> listarSolicitudes(){
            return solicitudServicio.obtenerTodosSolicitudes();

           }
    */
    @GetMapping("/empleado/{empleadoId}/solicitud")
    public List<SolicitudDTO> listarSolicitudesPorEmpleadoId(@PathVariable(value = "empleadoId") long empleadoId) {
        return solicitudServicio.obtenerSolicitudPorEmpleadoId(empleadoId);
    }

    @PostMapping("/empleado/{empleadoId}")
    public ResponseEntity<SolicitudDTO> guardarSolicitud(@PathVariable(value = "empleadoId") long empleadoId, @RequestBody SolicitudDTO solicitudDTO) {
        return new ResponseEntity<>(solicitudServicio.crearSolicitud(empleadoId, solicitudDTO), HttpStatus.CREATED);

    }

    @PutMapping("/empleado/solicitudes/{id}")
    public ResponseEntity<SolicitudDTO> actualizarSolicitud(@PathVariable(value = "id") Long solicitudId, @RequestBody SolicitudDTO solicitudDTO) {
        SolicitudDTO solicitudActualizada = solicitudServicio.actualizarSolicitud(solicitudId, solicitudDTO);
        return new ResponseEntity<>(solicitudActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarSolicitud(@PathVariable(name = "id") long id) {
        solicitudServicio.eliminarSolicitud(id);
        return new ResponseEntity<>("Solicitud Eliminada Con Exito", HttpStatus.OK);
    }

}
