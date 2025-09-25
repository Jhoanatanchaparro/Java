package com.example.EjercicioAutonomo.Service;

import com.example.EjercicioAutonomo.Dto.Request.OrdenCompraRequest;
import com.example.EjercicioAutonomo.Dto.Response.OrdenCompraResponse;

import java.util.List;

public interface OrdenCompraService {

    List<OrdenCompraResponse> mostrarOrdenCompra();
    OrdenCompraResponse findById(Long id);
    OrdenCompraResponse crearOrdenCompra(OrdenCompraRequest request);
    OrdenCompraResponse actualizar(Long id, OrdenCompraRequest request);
    void eliminarOrdenCompra(Long id);
}

