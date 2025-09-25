package com.example.EjercicioAutonomo.Service;

import com.example.EjercicioAutonomo.Dto.Request.ProductoRequest;
import com.example.EjercicioAutonomo.Dto.Response.ProductoResponse;

import java.util.List;

public interface ProductoService {

    List<ProductoResponse> mostrarProducto();
    ProductoResponse findById(Long id);
    ProductoResponse crearProducto(ProductoRequest request);
    ProductoResponse actualizarProducto(Long id, ProductoRequest request);
    void eliminarProducto(Long id);
}

