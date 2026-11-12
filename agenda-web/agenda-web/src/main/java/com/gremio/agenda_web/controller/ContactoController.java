package com.gremio.agenda_web.controller;

import com.gremio.agenda_web.model.Contacto;
import com.gremio.service.Contactoservice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactoController {

    private final Contactoservice service;

    public ContactoController(Contactoservice service) {
        this.service = service;
    }

    @GetMapping("/contactos")
    public String listar(Model model) {
        model.addAttribute("contactos", service.listarTodos());
        return "contactos";
    }

    @GetMapping("/nuevo")
    public String formularioNuevo(Model model) {
        model.addAttribute("contacto", new Contacto());
        return "formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Contacto contacto) {
        service.guardar(contacto);
        return "redirect:/contactos";
    }

    @GetMapping("/editar/{id}")
    public String formularioEditar(@PathVariable Long id, Model model) {
        model.addAttribute("contacto", service.buscarPorId(id));
        return "formulario";
    }

    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Contacto contacto) {
        service.guardar(contacto);
        return "redirect:/contactos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/contactos";
    }
}