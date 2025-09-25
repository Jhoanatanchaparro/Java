package com.example.EjercicioAutonomo.Mapper;

import com.example.EjercicioAutonomo.Dto.Request.CategoriaRequest;
import com.example.EjercicioAutonomo.Dto.Response.CategoriaResponse;
import com.example.EjercicioAutonomo.Entity.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
    Categoria toEntity(CategoriaRequest request);
    CategoriaResponse toResponse(Categoria entity);
    List<CategoriaResponse> toResponseList(List<Categoria> entities);

    void updateEntityFromRequest(CategoriaRequest request, @MappingTarget Categoria entity);
}

