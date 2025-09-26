package com.example.EjercicioAutonomo.Service;

import com.example.EjercicioAutonomo.Dto.Request.OrdenDetalleRequest;
import com.example.EjercicioAutonomo.Dto.Response.OrdenDetalleResponse;

import java.util.List;

public interface OrdenDetalleService {

    List<OrdenDetalleResponse> mostrarOrdenDetalle();
    OrdenDetalleResponse findById(Long id);
    OrdenDetalleResponse crearDetalle(OrdenDetalleRequest request);
    OrdenDetalleResponse actualizarDetalle(Long id, OrdenDetalleRequest request);
    void eliminarDetalle(Long id);
}

