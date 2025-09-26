package com.example.EjercicioAutonomo.Controller;

import com.example.EjercicioAutonomo.Dto.Request.OrdenCompraRequest;
import com.example.EjercicioAutonomo.Dto.Response.OrdenCompraResponse;
import com.example.EjercicioAutonomo.Service.OrdenCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordenCompra")
public class OrdenCompraController {

    @Autowired
    private OrdenCompraService ordenCompraService;

    @GetMapping
    public ResponseEntity<List<OrdenCompraResponse>> obtenerTodos() {
        List<OrdenCompraResponse> ordenes = ordenCompraService.mostrarOrdenCompra();
        return ResponseEntity.ok(ordenes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenCompraResponse> obtenerPorId(@PathVariable Long id) {
        OrdenCompraResponse orden = ordenCompraService.findById(id);
        if (orden != null) {
            return ResponseEntity.ok(orden);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<OrdenCompraResponse> crearCompra(@RequestBody OrdenCompraRequest request) {
        OrdenCompraResponse nuevaOrden = ordenCompraService.crearOrdenCompra(request);
        return ResponseEntity.ok(nuevaOrden);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdenCompraResponse> actualizarCompra(
            @PathVariable Long id,
            @RequestBody OrdenCompraRequest request) {

        try {
            OrdenCompraResponse ordenActualizada = ordenCompraService.actualizar(id, request);
            return ResponseEntity.ok(ordenActualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCompra(@PathVariable Long id) {
        ordenCompraService.eliminarOrdenCompra(id);
        return ResponseEntity.noContent().build();
    }
}

