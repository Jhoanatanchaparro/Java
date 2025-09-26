package com.example.EjercicioAutonomo.Mapper;

import com.example.EjercicioAutonomo.Dto.Request.ProveedorRequest;
import com.example.EjercicioAutonomo.Dto.Response.ProveedorResponse;
import com.example.EjercicioAutonomo.Entity.Proveedor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProveedorMapper {
    Proveedor toEntity(ProveedorRequest request);
    ProveedorResponse toResponse(Proveedor entity);
    List<ProveedorResponse> toResponseList(List<Proveedor> entities);

    void updateEntityFromRequest(ProveedorRequest request, @MappingTarget Proveedor entity);
}

