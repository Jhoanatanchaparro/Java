package com.example.EjercicioAutonomo.Controller;

import com.example.EjercicioAutonomo.Dto.Request.ClienteRequest;
import com.example.EjercicioAutonomo.Dto.Response.ClienteResponse;
import com.example.EjercicioAutonomo.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(@Qualifier("clienteServiceImpl") ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> mostrarClientes() {
        List<ClienteResponse> clientes = clienteService.mostrarCliente();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> obtenerCliente(@PathVariable Long id) {
        ClienteResponse cliente = clienteService.findById(id);
        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> crearCliente(@RequestBody ClienteRequest clienteRequest) {
        ClienteResponse nuevoCliente = clienteService.crearCliente(clienteRequest);
        return ResponseEntity.ok(nuevoCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> actualizarCliente(@PathVariable Long id,
                                                             @RequestBody ClienteRequest clienteRequest) {
        ClienteResponse clienteActualizado = clienteService.actualizarCliente(id, clienteRequest);
        return ResponseEntity.ok(clienteActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }
}

