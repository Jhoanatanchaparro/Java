package com.example.EjercicioAutonomo.Service;

import com.example.EjercicioAutonomo.Dto.ClienteDTO;
import com.example.EjercicioAutonomo.Entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ClienteService {

    List<Cliente> mostrarCliente();

    Optional<Cliente> findById(Long id);

    ClienteDTO crearCliente(ClienteDTO clienteDTO);

    ClienteDTO actualizarCliente(Long id, ClienteDTO clienteDTO);

    void eliminarCliente(Long id);
}
