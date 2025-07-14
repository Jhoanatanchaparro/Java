package com.example.EjercicioAutonomo.Service;

import com.example.EjercicioAutonomo.Dto.OrdenCompraDTO;
import com.example.EjercicioAutonomo.Entity.Orden_Compra;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrdenCompraService {

    List<Orden_Compra> mostrarOrdencompra();
    Optional<Orden_Compra> findById(Long id);
    OrdenCompraDTO crearOrdenCompra(OrdenCompraDTO ordenCompraDTO);
    OrdenCompraDTO actualizar(Long id, OrdenCompraDTO ordenCompraDTO);
    void eliminarOrdenCompra(Long id);

}
