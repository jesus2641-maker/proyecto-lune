package com.microserviciobh.api.controller;

import com.microserviciobh.api.model.ofertas;
import com.microserviciobh.api.service.OfertasService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasController {

    private static final Logger logger = LoggerFactory.getLogger(OfertasController.class);

    private final OfertasService ofertasService;

    public OfertasController(OfertasService ofertasService) {
        this.ofertasService = ofertasService;
    }

    @GetMapping
    public ResponseEntity<List<ofertas>> getAll() {
        logger.info("Consultando todas las ofertas");
        return ResponseEntity.ok(ofertasService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ofertas> getById(@PathVariable int id) {
        logger.info("Consultando oferta con id: {}", id);
        return ofertasService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ofertas> create(@RequestBody ofertas oferta) {
        logger.info("Creando nueva oferta para el producto: {}", oferta.getId_productos());
        ofertas created = ofertasService.create(oferta);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ofertas> update(@PathVariable int id, @RequestBody ofertas oferta) {
        logger.info("Actualizando oferta con id: {}", id);
        return ofertasService.update(id, oferta)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        logger.info("Eliminando oferta con id: {}", id);
        if (!ofertasService.deleteById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
