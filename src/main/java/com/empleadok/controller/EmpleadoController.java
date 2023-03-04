package com.empleadok.controller;

import com.empleadok.dto.EmpleadoDTO;
import com.empleadok.service.EmpleadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "*")
public class EmpleadoController {
    @Autowired
    private EmpleadoServicio empleadoServicio;

    @GetMapping("/all")
    public List<EmpleadoDTO> listarEmpleados(){
        return empleadoServicio.obtenerTodosEmpleados();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> obtenerEmpleadoPorId(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(empleadoServicio.obtenerEmpleadoPorId(id));
    }

    @PostMapping("/save")
    public ResponseEntity<EmpleadoDTO> guardarEmpleado(@RequestBody EmpleadoDTO empleadoDTO) {
        return new ResponseEntity<>(empleadoServicio.crearEmpleado(empleadoDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> actualizarEmpleado(@RequestBody EmpleadoDTO empleadoDTO, @PathVariable(name = "id") long id) {
        EmpleadoDTO empleadoRespuesta = empleadoServicio.actualizarEmpleado(empleadoDTO, id);
        return new ResponseEntity<>(empleadoRespuesta, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEmpleado(@PathVariable(name = "id") long id) {
        empleadoServicio.eliminarEmpleado(id);
        return new ResponseEntity<>("Empleado Eliminado Con Exito", HttpStatus.OK);
    }
}
