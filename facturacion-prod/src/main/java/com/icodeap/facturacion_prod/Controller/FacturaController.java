package com.icodeap.facturacion_prod.Controller;

import com.icodeap.facturacion_prod.Dto.RequestFacturaDTO;
import com.icodeap.facturacion_prod.Dto.ResponseFacturaDTO;
import com.icodeap.facturacion_prod.Services.FacturaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/facturas")
public class FacturaController {

    private final FacturaService facturaService;

    @PostMapping
    public ResponseFacturaDTO save(@RequestBody RequestFacturaDTO requestFacturaDTO){
        return facturaService.save(requestFacturaDTO);
    }

    @GetMapping
    public ResponseEntity<List<ResponseFacturaDTO>> findAll(){
        List<ResponseFacturaDTO> responseFacturaDTOS = facturaService.findAll();
        if (responseFacturaDTOS.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(responseFacturaDTOS);
    }

    @GetMapping("/id")
    public ResponseEntity<ResponseFacturaDTO> findById(@PathVariable Integer id){
        Optional<ResponseFacturaDTO> factura = facturaService.findById(id);
        return factura.map(
                ResponseEntity::ok
        ).orElseGet(
                ()-> ResponseEntity.notFound().build()
        );
    }

    @DeleteMapping
    public void deleteById(@PathVariable Integer id){
        facturaService.deleteById(id);
    }
}
