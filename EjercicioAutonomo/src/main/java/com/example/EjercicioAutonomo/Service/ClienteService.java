package com.example.EjercicioAutonomo.Service;

import com.example.EjercicioAutonomo.Dto.Request.ClienteRequest;
import com.example.EjercicioAutonomo.Dto.Response.ClienteResponse;

import java.util.List;

public interface ClienteService {
    List<ClienteResponse> mostrarCliente();
    ClienteResponse findById(Long id);
    ClienteResponse crearCliente(ClienteRequest clienteRequest);
    ClienteResponse actualizarCliente(Long id, ClienteRequest clienteRequest);
    void eliminarCliente(Long id);
}
