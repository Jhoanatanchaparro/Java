package com.example.EjercicioAutonomo.Controller.Feign;

import com.example.EjercicioAutonomo.Dto.Request.ClienteRequest;
import com.example.EjercicioAutonomo.Dto.Response.ClienteResponse;
import com.example.EjercicioAutonomo.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes-feign")
public class ClienteFeignController {

    private final ClienteService clienteFeignService;

    @Autowired
    public ClienteFeignController(@Qualifier("clienteFeignServiceImpl") ClienteService clienteFeignService) {
        this.clienteFeignService = clienteFeignService;
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> obtenerClientesFeign() {
        return ResponseEntity.ok(clienteFeignService.mostrarCliente());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> obtenerClienteFeign(@PathVariable Long id) {
        return ResponseEntity.ok(clienteFeignService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> crearClienteFeign(@RequestBody ClienteRequest request) {
        return ResponseEntity.ok(clienteFeignService.crearCliente(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> actualizarClienteFeign(@PathVariable Long id,
                                                                  @RequestBody ClienteRequest request) {
        return ResponseEntity.ok(clienteFeignService.actualizarCliente(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarClienteFeign(@PathVariable Long id) {
        clienteFeignService.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
