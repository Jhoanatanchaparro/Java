package com.example.EjercicioAutonomo.Controller;

import com.example.EjercicioAutonomo.Dto.Request.OrdenDetalleRequest;
import com.example.EjercicioAutonomo.Dto.Response.OrdenDetalleResponse;
import com.example.EjercicioAutonomo.Service.OrdenDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orden-detalles")
public class OrdenDetalleController {

    @Autowired
    private OrdenDetalleService ordenDetalleService;

    @GetMapping
    public ResponseEntity<List<OrdenDetalleResponse>> obtenerTodosLosDetalles() {
        List<OrdenDetalleResponse> detalles = ordenDetalleService.mostrarOrdenDetalle();
        return ResponseEntity.ok(detalles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenDetalleResponse> obtenerDetallePorId(@PathVariable Long id) {
        try {
            OrdenDetalleResponse detalle = ordenDetalleService.findById(id);
            return ResponseEntity.ok(detalle);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<OrdenDetalleResponse> crearDetalle(@RequestBody OrdenDetalleRequest request) {
        OrdenDetalleResponse nuevoDetalle = ordenDetalleService.crearDetalle(request);
        return ResponseEntity.ok(nuevoDetalle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdenDetalleResponse> actualizarDetalle(@PathVariable Long id,
                                                                  @RequestBody OrdenDetalleRequest request) {
        try {
            OrdenDetalleResponse detalleActualizado = ordenDetalleService.actualizarDetalle(id, request);
            return ResponseEntity.ok(detalleActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDetalle(@PathVariable Long id) {
        ordenDetalleService.eliminarDetalle(id);
        return ResponseEntity.noContent().build();
    }
}
