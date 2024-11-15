package com.example.EjercicioAutonomo.Service;

import com.example.EjercicioAutonomo.Dto.ProductoDTO;
import com.example.EjercicioAutonomo.Entity.Producto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductoService {

    List<Producto> mostrarProducto();

    Optional<Producto> findById(Long id);

    ProductoDTO crearProducto(ProductoDTO productoDTO);

    ProductoDTO actualizarProducto(Long id, ProductoDTO productoDTO);

    void eliminarProducto(Long id);
}
