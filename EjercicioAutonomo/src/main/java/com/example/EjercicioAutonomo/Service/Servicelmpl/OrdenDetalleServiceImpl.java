package com.example.EjercicioAutonomo.Service.Servicelmpl;

import com.example.EjercicioAutonomo.Dto.Request.OrdenDetalleRequest;
import com.example.EjercicioAutonomo.Dto.Response.OrdenDetalleResponse;
import com.example.EjercicioAutonomo.Entity.Orden_Detalle;
import com.example.EjercicioAutonomo.Exception.ResourceNotFoundException;
import com.example.EjercicioAutonomo.Mapper.OrdenDetalleMapper;
import com.example.EjercicioAutonomo.Repository.OrdenDetalleRepository;
import com.example.EjercicioAutonomo.Service.OrdenDetalleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdenDetalleServiceImpl implements OrdenDetalleService {

    private final OrdenDetalleRepository ordenDetalleRepository;
    private final OrdenDetalleMapper mapper;

    @Override
    public List<OrdenDetalleResponse> mostrarOrdenDetalle() {
        return mapper.toResponseList(ordenDetalleRepository.findAll());
    }

    @Override
    public OrdenDetalleResponse findById(Long id) {
        Orden_Detalle detalle = ordenDetalleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrdenDetalle", id));
        return mapper.toResponse(detalle);
    }

    @Override
    public OrdenDetalleResponse crearDetalle(OrdenDetalleRequest request) {
        Orden_Detalle detalle = mapper.toEntity(request);
        detalle = ordenDetalleRepository.save(detalle);
        return mapper.toResponse(detalle);
    }

    @Override
    public OrdenDetalleResponse actualizarDetalle(Long id, OrdenDetalleRequest request) {
        Orden_Detalle detalleExistente = ordenDetalleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrdenDetalle", id));

        mapper.updateEntityFromRequest(request, detalleExistente);

        detalleExistente = ordenDetalleRepository.save(detalleExistente);
        return mapper.toResponse(detalleExistente);
    }

    @Override
    public void eliminarDetalle(Long id) {
        if (!ordenDetalleRepository.existsById(id)) {
            throw new ResourceNotFoundException("OrdenDetalle", id);
        }
        ordenDetalleRepository.deleteById(id);
    }
}