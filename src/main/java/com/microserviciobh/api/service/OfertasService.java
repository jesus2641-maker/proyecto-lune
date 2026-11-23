package com.microserviciobh.api.service;

import com.microserviciobh.api.model.ofertas;
import com.microserviciobh.api.repository.OfertasRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfertasService {

    private static final Logger logger = LoggerFactory.getLogger(OfertasService.class);

    private final OfertasRepository ofertasRepository;

    public OfertasService(OfertasRepository ofertasRepository) {
        this.ofertasRepository = ofertasRepository;
    }

    public List<ofertas> findAll() {
        logger.info("Obteniendo listado de ofertas");
        return ofertasRepository.findAll();
    }

    public Optional<ofertas> findById(int id) {
        logger.info("Buscando oferta con id: {}", id);
        return ofertasRepository.findById(id);
    }

    public ofertas create(ofertas oferta) {
        logger.info("Guardando nueva oferta");
        return ofertasRepository.save(oferta);
    }

    public Optional<ofertas> update(int id, ofertas oferta) {
        logger.info("Actualizando oferta con id: {}", id);
        if (!ofertasRepository.existsById(id)) {
            return Optional.empty();
        }
        oferta.setId_ofertas(id);
        return Optional.of(ofertasRepository.save(oferta));
    }

    public boolean deleteById(int id) {
        logger.info("Eliminando oferta con id: {}", id);
        if (!ofertasRepository.existsById(id)) {
            return false;
        }
        ofertasRepository.deleteById(id);
        return true;
    }
}
