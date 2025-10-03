package com.example.EjercicioAutonomo.Feign;

import com.example.EjercicioAutonomo.Dto.Request.ClienteRequest;
import com.example.EjercicioAutonomo.Dto.Response.ClienteResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "cliente-service", url = "http://localhost:8081/api/clientes")
public interface ClienteFeignClient {

    @GetMapping
    List<ClienteResponse> obtenerClientes();

    @GetMapping("/{id}")
    ClienteResponse obtenerClientePorId(@PathVariable("id") Long id);

    @PostMapping
    ClienteResponse crearCliente(@RequestBody ClienteRequest clienteRequest);

    @PutMapping("/{id}")
    ClienteResponse actualizarCliente(@PathVariable("id") Long id,
                                      @RequestBody ClienteRequest clienteRequest);

    @DeleteMapping("/{id}")
    void eliminarCliente(@PathVariable("id") Long id);
}

