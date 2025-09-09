package com.example.EjercicioAutonomo.Controller;

import com.example.EjercicioAutonomo.Dto.ProveedorDTO;
import com.example.EjercicioAutonomo.Entity.Proveedor;
import com.example.EjercicioAutonomo.Service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
@Controller
@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;


    // Obtener todos los proveedores
    @GetMapping
    public ResponseEntity<List<Proveedor>> obtenerTodosLosProveedores() {
        List<Proveedor> proveedores = proveedorService.mostrarProveedor();
        return ResponseEntity.ok(proveedores);
    }

    // Obtener un proveedor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> obtenerProveedorPorId(@PathVariable Long id) {
        Optional<Proveedor> proveedor = proveedorService.findById(id);
        return proveedor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo proveedor
    @PostMapping
    public ResponseEntity<ProveedorDTO> crearProveedor(@RequestBody ProveedorDTO proveedorDTO) {
        ProveedorDTO nuevoProveedor = proveedorService.crearProveedor(proveedorDTO);
        return ResponseEntity.ok(nuevoProveedor);
    }

    // Actualizar un proveedor existente
    @PutMapping("/{id}")
    public ResponseEntity<ProveedorDTO> actualizarProveedor(@PathVariable Long id, @RequestBody ProveedorDTO proveedorDTO) {
        ProveedorDTO proveedorActualizado = proveedorService.actualizar(id, proveedorDTO);
        if (proveedorActualizado != null) {
            return ResponseEntity.ok(proveedorActualizado);
        }
        return ResponseEntity.notFound().build();
    }

    // Eliminar un proveedor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProveedor(@PathVariable Long id) {
        proveedorService.eliminarProveedor(id);
        return ResponseEntity.noContent().build();
    }
}
