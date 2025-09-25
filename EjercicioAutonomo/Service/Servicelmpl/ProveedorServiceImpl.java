package com.example.EjercicioAutonomo.Service.Servicelmpl;

import com.example.EjercicioAutonomo.Dto.Request.ProveedorRequest;
import com.example.EjercicioAutonomo.Dto.Response.ProveedorResponse;
import com.example.EjercicioAutonomo.Entity.Proveedor;
import com.example.EjercicioAutonomo.Exception.ResourceNotFoundException;
import com.example.EjercicioAutonomo.Mapper.ProveedorMapper;
import com.example.EjercicioAutonomo.Repository.ProveedorRepository;
import com.example.EjercicioAutonomo.Service.ProveedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProveedorServiceImpl implements ProveedorService {

    private final ProveedorRepository proveedorRepository;
    private final ProveedorMapper proveedorMapper;

    @Override
    public List<ProveedorResponse> mostrarProveedor() {
        return proveedorMapper.toResponseList(proveedorRepository.findAll());
    }

    @Override
    public ProveedorResponse findById(Long id) {
        Proveedor proveedor = proveedorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor", id));
        return proveedorMapper.toResponse(proveedor);
    }

    @Override
    public ProveedorResponse crearProveedor(ProveedorRequest proveedorRequest) {
        Proveedor proveedor = proveedorMapper.toEntity(proveedorRequest);
        proveedor = proveedorRepository.save(proveedor);
        return proveedorMapper.toResponse(proveedor);
    }

    @Override
    public ProveedorResponse actualizar(Long id, ProveedorRequest proveedorRequest) {
        Proveedor proveedor = proveedorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor", id));

        proveedorMapper.updateEntityFromRequest(proveedorRequest, proveedor);

        proveedor = proveedorRepository.save(proveedor);
        return proveedorMapper.toResponse(proveedor);
    }

    @Override
    public void eliminarProveedor(Long id) {
        if (!proveedorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Proveedor", id);
        }
        proveedorRepository.deleteById(id);
    }
}