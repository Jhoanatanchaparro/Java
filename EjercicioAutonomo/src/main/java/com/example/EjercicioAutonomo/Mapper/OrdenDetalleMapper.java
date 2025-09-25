package com.example.EjercicioAutonomo.Mapper;

import com.example.EjercicioAutonomo.Dto.Request.OrdenDetalleRequest;
import com.example.EjercicioAutonomo.Dto.Response.OrdenDetalleResponse;
import com.example.EjercicioAutonomo.Entity.Orden_Detalle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductoMapper.class})
public interface OrdenDetalleMapper {
    @Mapping(source = "productoId", target = "producto.id")
    @Mapping(source = "ordenCompraId", target = "ordenCompra.id")
    Orden_Detalle toEntity(OrdenDetalleRequest request);

    @Mapping(source = "producto", target = "producto")
    @Mapping(source = "ordenCompra", target = "ordenCompra")
    OrdenDetalleResponse toResponse(Orden_Detalle entity);

    List<OrdenDetalleResponse> toResponseList(List<Orden_Detalle> entities);

    @Mapping(source = "productoId", target = "producto.id")
    @Mapping(source = "ordenCompraId", target = "ordenCompra.id")
    void updateEntityFromRequest(OrdenDetalleRequest request, @MappingTarget Orden_Detalle entity);
}

