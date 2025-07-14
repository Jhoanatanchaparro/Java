package com.example.EjercicioAutonomo.Service.Servicelmpl;

import com.example.EjercicioAutonomo.Dto.ClienteDTO;
import com.example.EjercicioAutonomo.Entity.Cliente;
import com.example.EjercicioAutonomo.Repository.ClienteRepository;
import com.example.EjercicioAutonomo.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicelmpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> mostrarCliente() {
        return clienteRepository.findAllWithOrdenes();
    }
    
    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public ClienteDTO crearCliente(ClienteDTO clienteDTO) {
        Cliente cliente= convertirDTOAEntidad(clienteDTO);
        cliente = clienteRepository.save(cliente);
        return convertirEntidadDTO(cliente);
    }

    @Override
    public ClienteDTO actualizarCliente(Long id, ClienteDTO clienteDTO){
        Optional<Cliente> clienteExistente = clienteRepository.findById(id);

       if (clienteExistente.isPresent()){
           Cliente cliente = clienteExistente.get();
           cliente.setNombre(clienteDTO.getNombre());
           cliente.setEmail(clienteDTO.getEmail());
           cliente.setTelefono(clienteDTO.getTelefono());

           cliente= clienteRepository.save(cliente);
           return convertirEntidadDTO(cliente);
       }
        return null;
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);

    }

    private ClienteDTO convertirEntidadDTO(Cliente cliente){

        if (cliente== null){
            return null;
        }
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(cliente.getId());
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setTelefono(cliente.getTelefono());
        clienteDTO.setEmail(cliente.getEmail());
        clienteDTO.setDireccion(cliente.getDireccion());
        return clienteDTO;
    }

    private Cliente convertirDTOAEntidad(ClienteDTO clienteDTO){
        if (clienteDTO == null){
            return null;
        }
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setTelefono(clienteDTO.getTelefono());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setDireccion(clienteDTO.getDireccion());
        return cliente;
    }
}
