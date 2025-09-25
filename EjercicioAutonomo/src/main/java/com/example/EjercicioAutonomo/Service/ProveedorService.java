package com.example.EjercicioAutonomo.Service;

import com.example.EjercicioAutonomo.Dto.Request.ProveedorRequest;
import com.example.EjercicioAutonomo.Dto.Response.ProveedorResponse;

import java.util.List;

public interface ProveedorService {
    List<ProveedorResponse> mostrarProveedor();
    ProveedorResponse findById(Long id);
    ProveedorResponse crearProveedor(ProveedorRequest proveedorRequest);
    ProveedorResponse actualizar(Long id, ProveedorRequest proveedorRequest);
    void eliminarProveedor(Long id);
}

