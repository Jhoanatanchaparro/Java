package com.example.EjercicioAutonomo.Controller;

import com.example.EjercicioAutonomo.Dto.OrdenCompraDTO;
import com.example.EjercicioAutonomo.Entity.Orden_Compra;
import com.example.EjercicioAutonomo.Service.OrdenCompraService;
import org.aspectj.apache.bcel.classfile.Module;
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
@RequestMapping("/api/ordenCompra")
public class OrdenCompraController {

    @Autowired
    private OrdenCompraService ordenCompraService;

    @GetMapping
    public ResponseEntity<List<Orden_Compra>> obtenerTodos(){
        List<Orden_Compra> ordenCompras = ordenCompraService.mostrarOrdencompra();
        return  ResponseEntity.ok(ordenCompras);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orden_Compra> obtenerPorId(@PathVariable Long id){
        Optional<Orden_Compra> ordenCompra = ordenCompraService.findById(id);
        return ordenCompra.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public  ResponseEntity <OrdenCompraDTO> crearCompra(@RequestBody OrdenCompraDTO ordenCompraDTO){
        OrdenCompraDTO nuevaCompra = ordenCompraService.crearOrdenCompra(ordenCompraDTO);
        return  ResponseEntity.ok(nuevaCompra);
    }

    @PutMapping("/{id}")
    public ResponseEntity <OrdenCompraDTO> actualizarCompra(@PathVariable Long id, @RequestBody OrdenCompraDTO ordenCompraDTO){
        OrdenCompraDTO ordencompraActualizada = ordenCompraService.actualizar(id, ordenCompraDTO);
        if (ordencompraActualizada != null){
            return ResponseEntity.ok(ordencompraActualizada);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCompra(@PathVariable Long id){
        ordenCompraService.eliminarOrdenCompra(id);
        return ResponseEntity.noContent().build();
    }
}
