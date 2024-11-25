package com.example.EjercicioAutonomo.Service.Servicelmpl;

import com.example.EjercicioAutonomo.Dto.ProveedorDTO;
import com.example.EjercicioAutonomo.Entity.Proveedor;
import com.example.EjercicioAutonomo.Repository.ProveedorRepository;
import com.example.EjercicioAutonomo.Service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorServicelmpl implements ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public List<Proveedor> mostrarProveedor() {
        return proveedorRepository.findAll();
    }

    @Override
    public Optional<Proveedor> findById(Long id) {
        return proveedorRepository.findById(id);
    }

    @Override
    public ProveedorDTO crearProveedor(ProveedorDTO proveedorDTO){
        Proveedor proveedor = convertirDTOAEntidad(proveedorDTO);
        proveedor = proveedorRepository.save(proveedor);
        return convertirEntidadDTO(proveedor);
    }

    @Override
    public ProveedorDTO actualizar(Long id, ProveedorDTO proveedorDTO) {
        Optional<Proveedor> proveedorExistente  = proveedorRepository.findById(id);

        if (proveedorExistente.isPresent()){
            Proveedor proveedor = (Proveedor) proveedorExistente.get();
            proveedor.setNombre(proveedorDTO.getNombre());
            proveedor.setEmail(proveedorDTO.getEmail());

            proveedor = proveedorRepository.save(proveedor);
            return convertirEntidadDTO(proveedor);
        }
        return null;
    }

    @Override
    public void eliminarProveedor(Long id) {

    }

    private ProveedorDTO convertirEntidadDTO(Proveedor proveedor) {
        if (proveedor== null) {
            return null;
        }
        ProveedorDTO proveedorDTO = new ProveedorDTO();
        proveedorDTO.setId(proveedor.getId());
        proveedorDTO.setNombre(proveedor.getNombre());
        proveedorDTO.setTelefono(proveedor.getTelefono());
        proveedorDTO.setEmail(proveedor.getEmail());
        proveedorDTO.setDireccion(proveedor.getDireccion());
        return proveedorDTO;
    }

    private Proveedor convertirDTOAEntidad(ProveedorDTO proveedorDTO) {
        if (proveedorDTO == null){
            return null;
        }
        Proveedor proveedor = new Proveedor(null, null, null, null,null, null);
        proveedor.setNombre(proveedorDTO.getNombre());
        proveedor.setTelefono(proveedorDTO.getTelefono());
        proveedor.setEmail(proveedorDTO.getEmail());
        proveedor.setDireccion(proveedorDTO.getDireccion());
        return proveedor;
    }
}
