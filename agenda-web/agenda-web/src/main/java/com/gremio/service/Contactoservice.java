package com.gremio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gremio.agenda_web.model.Contacto;
import com.gremio.agenda_web.repository.ContactoRepository;

@Service
public class Contactoservice {

    private final ContactoRepository repo;

    public Contactoservice(ContactoRepository repo) {
        this.repo = repo;
    }

    public List<Contacto> listarTodos() {
        return repo.findAll();
    }

    public void guardar(Contacto contacto) {
        repo.save(contacto);
    }

    public Contacto buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Contacto no encontrado: " + id));
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
