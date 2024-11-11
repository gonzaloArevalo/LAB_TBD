package com.tbd_grupo_8.lab_1.controllers;

import com.tbd_grupo_8.lab_1.entities.DetalleOrden;
import com.tbd_grupo_8.lab_1.repositories.DetalleOrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/detalle_orden")
@CrossOrigin("*")
public class DetalleOrdenController {
    @Autowired
    private DetalleOrdenRepository detalleOrdenRepository;

    @GetMapping("/")
    public ResponseEntity<List<DetalleOrden>> getAllDetallesOrden() {
        List<DetalleOrden> detalleOrdenes = detalleOrdenRepository.findAll();
        return new ResponseEntity<>(detalleOrdenes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleOrden> getDetalleOrdenById(@PathVariable long id) {
        DetalleOrden detalleOrden = detalleOrdenRepository.findById(id);
        if (detalleOrden != null) {
            return new ResponseEntity<>(detalleOrden, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<DetalleOrden> createDetalleOrden(@RequestBody DetalleOrden detalleOrden) {
        try {
            DetalleOrden savedDetalleOrden = detalleOrdenRepository.save(detalleOrden);
            return new ResponseEntity<>(savedDetalleOrden, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleOrden> updateDetalleOrden(@PathVariable long id, @RequestBody DetalleOrden detalleOrden) {
        detalleOrden.setId_detalle(id);
        DetalleOrden savedDetalleOrden = detalleOrdenRepository.update(detalleOrden);
        if (savedDetalleOrden != null) {
            return new ResponseEntity<>(savedDetalleOrden, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DetalleOrden> deleteDetalleOrden(@PathVariable long id) {
        if (detalleOrdenRepository.delete(id)) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
