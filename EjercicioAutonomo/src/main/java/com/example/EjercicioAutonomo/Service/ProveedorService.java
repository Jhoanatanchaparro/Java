package com.example.EjercicioAutonomo.Service;

import com.example.EjercicioAutonomo.Dto.ProveedorDTO;
import com.example.EjercicioAutonomo.Entity.Proveedor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProveedorService {

    List<Proveedor> mostrarProveedor();

    Optional<Proveedor> findById(Long id);

    ProveedorDTO crearProveedor(ProveedorDTO proveedorDTO);

    ProveedorDTO actualizar(Long id, ProveedorDTO proveedorDTO);

    void eliminarProveedor(Long id);
}
