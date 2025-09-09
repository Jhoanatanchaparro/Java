package com.icodeap.facturacion_prod.Controller;

import com.icodeap.facturacion_prod.Dto.ProductoDto;
import com.icodeap.facturacion_prod.Services.ProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }
    @PostMapping
    public ResponseEntity<ProductoDto> save(@RequestBody ProductoDto productoDto){
        log.info("Infoormacion ProductoDTO {}", productoDto);
        return new ResponseEntity<>(productoService.save(productoDto), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<ProductoDto>> findAll(){
        List<ProductoDto> productoDtos= productoService.findAll();
        if (productoDtos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productoDtos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductoDto> findByid(@PathVariable Integer id){
        return productoService.finfById(id).map(
                ResponseEntity::ok
        ).orElseGet(()->ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id){
        if (productoService.deleteById(id))
            return  ResponseEntity.noContent().build();
        return  ResponseEntity.notFound().build();
    }
    @PutMapping
    public ResponseEntity<ProductoDto> update(@RequestBody ProductoDto productoDto){
        return productoService.update(productoDto).map(
                ResponseEntity::ok
        ).orElseGet(
                ()-> ResponseEntity.notFound().build()
        );
    }
}
