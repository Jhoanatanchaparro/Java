package com.example.EjercicioAutonomo.Service.Servicelmpl;

import com.example.EjercicioAutonomo.Dto.Request.ClienteRequest;
import com.example.EjercicioAutonomo.Dto.Response.ClienteResponse;
import com.example.EjercicioAutonomo.Feign.ClienteFeignClient;
import com.example.EjercicioAutonomo.Service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteFeignServiceImpl implements ClienteService {

    private final ClienteFeignClient clienteFeignClient;

    public ClienteFeignServiceImpl(ClienteFeignClient clienteFeignClient) {
        this.clienteFeignClient = clienteFeignClient;
    }

    @Override
    public List<ClienteResponse> mostrarCliente() {
        return clienteFeignClient.obtenerClientes();
    }

    @Override
    public ClienteResponse findById(Long id) {
        return clienteFeignClient.obtenerClientePorId(id);
    }

    @Override
    public ClienteResponse crearCliente(ClienteRequest clienteRequest) {
        return clienteFeignClient.crearCliente(clienteRequest);
    }

    @Override
    public ClienteResponse actualizarCliente(Long id, ClienteRequest clienteRequest) {
        return clienteFeignClient.actualizarCliente(id, clienteRequest);
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteFeignClient.eliminarCliente(id);
    }
}
