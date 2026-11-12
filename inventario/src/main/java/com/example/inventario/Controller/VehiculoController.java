package com.example.inventario.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import com.example.inventario.model.Vehiculo;
import com.example.inventario.Service.VehiculoService;

@Controller
public class VehiculoController {

    private final VehiculoService service;

    public VehiculoController(VehiculoService service) {
        this.service = service;
    }

    @GetMapping({"/vehiculos", "/vehiculos/"})
    public String listar(Model model) {
        model.addAttribute("vehiculos", service.listar());
        return "Vehiculo";
    }

    @GetMapping("/vehiculos/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("vehiculo", new Vehiculo());
        return "Formulario-Vehiculo";
    }

    @PostMapping("/vehiculos/guardar")
    public String guardar(@ModelAttribute Vehiculo vehiculo) {
        service.guardar(vehiculo);
        return "redirect:/vehiculos";
    }

    @GetMapping("/vehiculos/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("vehiculo", buscarVehiculo(id));
        return "Formulario-Vehiculo";
    }

    @GetMapping("/vehiculos/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        buscarVehiculo(id);
        service.eliminar(id);
        return "redirect:/vehiculos";
    }

    @GetMapping("/")
    public String inicio() {
        return "redirect:/vehiculos";
    }

    private Vehiculo buscarVehiculo(Long id) {
        return service.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Vehículo no encontrado: " + id));
    }
}
