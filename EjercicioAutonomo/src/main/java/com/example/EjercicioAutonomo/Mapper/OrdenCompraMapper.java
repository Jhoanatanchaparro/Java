package com.example.EjercicioAutonomo.Mapper;


import com.example.EjercicioAutonomo.Dto.Request.OrdenCompraRequest;
import com.example.EjercicioAutonomo.Dto.Response.OrdenCompraResponse;
import com.example.EjercicioAutonomo.Entity.Orden_Compra;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ClienteMapper.class, OrdenDetalleMapper.class})
public interface OrdenCompraMapper {
    Orden_Compra toEntity(OrdenCompraRequest request);
    OrdenCompraResponse toResponse(Orden_Compra entity);
    List<OrdenCompraResponse> toResponseList(List<Orden_Compra> entities);

    void updateEntityFromRequest(OrdenCompraRequest request, @MappingTarget Orden_Compra entity);
}
