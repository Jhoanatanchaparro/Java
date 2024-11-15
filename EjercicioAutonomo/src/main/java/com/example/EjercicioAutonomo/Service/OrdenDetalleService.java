package com.example.EjercicioAutonomo.Service;

import com.example.EjercicioAutonomo.Dto.OrdenDetalleDTO;
import com.example.EjercicioAutonomo.Entity.Orden_Detalle;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrdenDetalleService {

    List<Orden_Detalle> mostrarOrdenDetalle();

    Optional<Orden_Detalle> findById(Long id);

    OrdenDetalleDTO crearDetalle(OrdenDetalleDTO ordenDetalleDTO);

    OrdenDetalleDTO actualizarDetalle(Long id, OrdenDetalleDTO ordenDetalleDTO);

    void eliminarCliente(Long id);
}
