package com.microserviciobh.api.repository;

import com.microserviciobh.api.model.ofertas;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class OfertasRepository {

    private final Map<Integer, ofertas> storage = new ConcurrentHashMap<>();
    private final AtomicInteger sequence = new AtomicInteger(1);

    public List<ofertas> findAll() {
        return new ArrayList<>(storage.values());
    }

    public Optional<ofertas> findById(int id) {
        return Optional.ofNullable(storage.get(id));
    }

    public ofertas save(ofertas oferta) {
        if (oferta.getId_ofertas() <= 0) {
            oferta.setId_ofertas(sequence.getAndIncrement());
        } else {
            sequence.updateAndGet(current -> Math.max(current, oferta.getId_ofertas() + 1));
        }
        storage.put(oferta.getId_ofertas(), oferta);
        return oferta;
    }

    public boolean existsById(int id) {
        return storage.containsKey(id);
    }

    public void deleteById(int id) {
        storage.remove(id);
    }
}
