package com.example.EjercicioAutonomo.Controller;

import com.example.EjercicioAutonomo.Dto.OrdenDetalleDTO;
import com.example.EjercicioAutonomo.Entity.Orden_Detalle;
import com.example.EjercicioAutonomo.Service.OrdenDetalleService;
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
@RequestMapping("/api/orden-detalles")
public class OrdenDetalleController {

    @Autowired
    private OrdenDetalleService ordenDetalleService;

    @GetMapping
    public ResponseEntity<List<Orden_Detalle>> obtenerTodosLosDetalles() {
        List<Orden_Detalle> detalles = ordenDetalleService.mostrarOrdenDetalle();
        return ResponseEntity.ok(detalles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orden_Detalle> obtenerDetallePorId(@PathVariable Long id) {
        Optional<Orden_Detalle> detalle = ordenDetalleService.findById(id);
        return detalle.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OrdenDetalleDTO> crearDetalle(@RequestBody OrdenDetalleDTO ordenDetalleDTO) {
        OrdenDetalleDTO nuevoDetalle = ordenDetalleService.crearDetalle(ordenDetalleDTO);
        return ResponseEntity.ok(nuevoDetalle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdenDetalleDTO> actualizarDetalle(@PathVariable Long id, @RequestBody OrdenDetalleDTO ordenDetalleDTO) {
        OrdenDetalleDTO detalleActualizado = ordenDetalleService.actualizarDetalle(id, ordenDetalleDTO);
        if (detalleActualizado != null) {
            return ResponseEntity.ok(detalleActualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDetalle(@PathVariable Long id) {
        ordenDetalleService.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
