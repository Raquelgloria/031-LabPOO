package com.gremio.agenda_web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import com.gremio.agenda_web.model.Contacto;
import com.gremio.agenda_web.repository.ContactoRepository;

@Controller
public class ContactoController {

    private final ContactoRepository repo;

    // Spring inyecta el repository automáticamente
    public ContactoController(ContactoRepository repo) {
        this.repo = repo;
    }

    // GET /contactos → muestra la lista
    @GetMapping("/contactos")
    public String listar(Model model) {
        model.addAttribute("contactos", repo.findAll());
        return "contactos";
    }

    // GET /nuevo → muestra el formulario vacío
    @GetMapping("/nuevo")
    public String formulario(Model model) {
        model.addAttribute("contacto", new Contacto());
        return "nuevo";
    }

    // POST /guardar → recibe el formulario y guarda en BD
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Contacto contacto) {
        repo.save(contacto);
        return "redirect:/contactos";
    }

    @GetMapping("/editar/{id}")
    public String formularioEdicion(@PathVariable Long id, Model model) {
        Contacto contacto = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contacto no encontrado"));
        model.addAttribute("contacto", contacto);
        return "editar";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable Long id, @ModelAttribute Contacto contacto) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Contacto no encontrado");
        }
        contacto.setId(id);
        repo.save(contacto);
        return "redirect:/contactos";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        Contacto contacto = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contacto no encontrado"));
        repo.delete(contacto);
        return "redirect:/contactos";
    }
}