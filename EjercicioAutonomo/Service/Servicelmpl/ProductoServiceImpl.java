package com.example.EjercicioAutonomo.Service.Servicelmpl;

import com.example.EjercicioAutonomo.Dto.Request.ProductoRequest;
import com.example.EjercicioAutonomo.Dto.Response.ProductoResponse;
import com.example.EjercicioAutonomo.Entity.Producto;
import com.example.EjercicioAutonomo.Exception.ResourceNotFoundException;
import com.example.EjercicioAutonomo.Mapper.ProductoMapper;
import com.example.EjercicioAutonomo.Repository.ProductoRepository;
import com.example.EjercicioAutonomo.Service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    @Override
    public List<ProductoResponse> mostrarProducto() {
        return productoMapper.toResponseList(productoRepository.findAll());
    }

    @Override
    public ProductoResponse findById(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto", id));
        return productoMapper.toResponse(producto);
    }

    @Override
    public ProductoResponse crearProducto(ProductoRequest request) {
        Producto producto = productoMapper.toEntity(request);
        producto = productoRepository.save(producto);
        return productoMapper.toResponse(producto);
    }

    @Override
    public ProductoResponse actualizarProducto(Long id, ProductoRequest request) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto", id));

        productoMapper.updateEntityFromRequest(request, producto);

        producto = productoRepository.save(producto);
        return productoMapper.toResponse(producto);
    }

    @Override
    public void eliminarProducto(Long id) {
        if (!productoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Producto", id);
        }
        productoRepository.deleteById(id);
    }
}

