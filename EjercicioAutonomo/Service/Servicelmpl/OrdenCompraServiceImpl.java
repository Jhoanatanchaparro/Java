package com.example.EjercicioAutonomo.Service.Servicelmpl;

import com.example.EjercicioAutonomo.Dto.Request.OrdenCompraRequest;
import com.example.EjercicioAutonomo.Dto.Response.OrdenCompraResponse;
import com.example.EjercicioAutonomo.Entity.Orden_Compra;
import com.example.EjercicioAutonomo.Exception.ResourceNotFoundException;
import com.example.EjercicioAutonomo.Mapper.OrdenCompraMapper;
import com.example.EjercicioAutonomo.Repository.ClienteRepository;
import com.example.EjercicioAutonomo.Repository.OrdenCompraRepository;
import com.example.EjercicioAutonomo.Repository.OrdenDetalleRepository;
import com.example.EjercicioAutonomo.Service.OrdenCompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdenCompraServiceImpl implements OrdenCompraService {

    private final OrdenCompraRepository ordenCompraRepository;
    private final ClienteRepository clienteRepository;
    private final OrdenDetalleRepository ordenDetalleRepository;
    private final OrdenCompraMapper ordenCompraMapper;

    @Override
    public List<OrdenCompraResponse> mostrarOrdenCompra() {
        return ordenCompraMapper.toResponseList(ordenCompraRepository.findAll());
    }

    @Override
    public OrdenCompraResponse findById(Long id) {
        return ordenCompraRepository.findById(id)
                .map(ordenCompraMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("OrdenCompra", id));
    }

    @Override
    public OrdenCompraResponse crearOrdenCompra(OrdenCompraRequest request) {
        Orden_Compra orden = ordenCompraMapper.toEntity(request);
        orden.setFecha(LocalDate.now());

        orden.setTotal(
                orden.getDetalles().stream()
                        .map(d -> d.getPrecio().multiply(BigDecimal.valueOf(d.getCantidad())))
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
        );

        orden = ordenCompraRepository.save(orden);
        return ordenCompraMapper.toResponse(orden);
    }

    @Override
    public OrdenCompraResponse actualizar(Long id, OrdenCompraRequest request) {
        Orden_Compra ordenExistente = ordenCompraRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrdenCompra", id));

        ordenCompraMapper.updateEntityFromRequest(request, ordenExistente);

        ordenExistente.setTotal(
                ordenExistente.getDetalles().stream()
                        .map(d -> d.getPrecio().multiply(BigDecimal.valueOf(d.getCantidad())))
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
        );

        ordenExistente = ordenCompraRepository.save(ordenExistente);
        return ordenCompraMapper.toResponse(ordenExistente);
    }

    @Override
    public void eliminarOrdenCompra(Long id) {
        if (!ordenCompraRepository.existsById(id)) {
            throw new ResourceNotFoundException("OrdenCompra", id);
        }
        ordenCompraRepository.deleteById(id);
    }
}