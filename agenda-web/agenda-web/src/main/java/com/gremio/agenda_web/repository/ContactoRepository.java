package com.gremio.agenda_web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gremio.agenda_web.model.Contacto;

public interface ContactoRepository extends JpaRepository<Contacto, Long> {
    // No necesitas escribir nada aquí
    // Spring Data JPA genera save(), findAll(), findById(), deleteById() automáticamente
}