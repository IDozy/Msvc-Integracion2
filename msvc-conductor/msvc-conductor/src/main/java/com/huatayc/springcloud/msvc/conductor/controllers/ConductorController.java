package com.huatayc.springcloud.msvc.conductor.controllers;


import com.huatayc.springcloud.msvc.conductor.models.entity.Conductor;
import com.huatayc.springcloud.msvc.conductor.services.ConductorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/conductor")
@RestController
public class ConductorController {

    @Autowired
    private ConductorService service;

    @GetMapping
    public List<Conductor> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id) {
        Optional<Conductor> conductorOptional = service.porId(id);
        if (conductorOptional.isPresent()) {
            return ResponseEntity.ok(conductorOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Conductor conductor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(conductor));
    }

    @PutMapping ("/{id}")
    public ResponseEntity<?> editar(@RequestBody Conductor conductor, @PathVariable Long id) {
        Optional<Conductor> op = service.porId(id);
        if (op.isPresent()) {

            Conductor conductorDB = op.get();
            conductorDB.setNombres(conductor.getNombres());
            conductorDB.setDni(conductor.getDni());
            conductorDB.setBrevete(conductor.getBrevete());
            conductorDB.setInfraccionado(conductor.getInfraccionado());
            conductorDB.setEdad(conductor.getEdad());
            conductorDB.setCategoria(conductor.getCategoria());


            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(conductorDB));
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<Conductor> op = service.porId(id);
        if (op.isPresent()) {
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<?> listarPorCategoria(@PathVariable String categoria) {
        List<Conductor> conductores = service.listarPorCategoria(categoria);
        if (!conductores.isEmpty()) {
            return ResponseEntity.ok(conductores);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/brevete/{brevete}")
    public ResponseEntity<?> conductorBrevete(@PathVariable String brevete) {
        Conductor conductor = service.PorBrevete(brevete);
        if (conductor != null) {
            return ResponseEntity.ok(conductor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @GetMapping("/datos")
    public ResponseEntity<?> Existencia() {

        if (!service.Datos()) {
            return ResponseEntity.ok("True");
        } else {
            return ResponseEntity.ok("False");
        }
    }

    @DeleteMapping("/infraccion/{infraccion}")
    public ResponseEntity<?> eliminarInfraccion(@PathVariable Boolean infraccion){
        try {
            service.eliminarInfraccion(infraccion);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar los conductores con infracción: " + e.getMessage());
        }
    }
}
