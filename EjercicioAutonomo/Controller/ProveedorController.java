package com.example.EjercicioAutonomo.Controller;

import com.example.EjercicioAutonomo.Dto.Request.ProveedorRequest;
import com.example.EjercicioAutonomo.Dto.Response.ProveedorResponse;
import com.example.EjercicioAutonomo.Service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public ResponseEntity<List<ProveedorResponse>> obtenerTodosLosProveedores() {
        List<ProveedorResponse> proveedores = proveedorService.mostrarProveedor();
        return ResponseEntity.ok(proveedores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProveedorResponse> obtenerProveedorPorId(@PathVariable Long id) {
        ProveedorResponse proveedor = proveedorService.findById(id);
        return ResponseEntity.ok(proveedor);
    }

    @PostMapping
    public ResponseEntity<ProveedorResponse> crearProveedor(@RequestBody ProveedorRequest proveedorRequest) {
        ProveedorResponse nuevoProveedor = proveedorService.crearProveedor(proveedorRequest);
        return ResponseEntity.ok(nuevoProveedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProveedorResponse> actualizarProveedor(@PathVariable Long id, @RequestBody ProveedorRequest proveedorRequest) {
        ProveedorResponse proveedorActualizado = proveedorService.actualizar(id, proveedorRequest);
        if (proveedorActualizado != null) {
            return ResponseEntity.ok(proveedorActualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProveedor(@PathVariable Long id) {
        proveedorService.eliminarProveedor(id);
        return ResponseEntity.noContent().build();
    }
}

