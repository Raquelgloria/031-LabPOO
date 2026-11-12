
package com.example.inventario.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.inventario.model.Vehiculo;
import com.example.inventario.Repository.VehiculoRepository;

@Service
public class VehiculoService {

    private final VehiculoRepository repository;

    public VehiculoService(VehiculoRepository repository) {
        this.repository = repository;
    }

    // Registrar o actualizar vehículo
    public Vehiculo guardar(Vehiculo vehiculo) {
        return repository.save(vehiculo);
    }

    // Consultar todos los vehículos
    public List<Vehiculo> listar() {
        return repository.findAll();
    }

    // Buscar vehículo por ID
    public Optional<Vehiculo> buscarPorId(Long id) {
        return repository.findById(id);
    }

    // Eliminar vehículo
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
