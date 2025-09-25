package com.example.EjercicioAutonomo.Mapper;

import com.example.EjercicioAutonomo.Dto.Request.ProveedorRequest;
import com.example.EjercicioAutonomo.Dto.Response.ProveedorResponse;
import com.example.EjercicioAutonomo.Entity.Proveedor;
import org.mapstruct.Mapper;

import java.util.List;

import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProveedorMapper {
    Proveedor toEntity(ProveedorRequest request);
    ProveedorResponse toResponse(Proveedor entity);
    List<ProveedorResponse> toResponseList(List<Proveedor> entities);

    void updateEntityFromRequest(ProveedorRequest request, @MappingTarget Proveedor entity);
}

