package com.example.EjercicioAutonomo.Mapper;

import com.example.EjercicioAutonomo.Dto.Request.ProductoRequest;
import com.example.EjercicioAutonomo.Dto.Response.ProductoResponse;
import com.example.EjercicioAutonomo.Entity.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoriaMapper.class, ProveedorMapper.class})
public interface ProductoMapper {

    @Mapping(source = "categoriaId", target = "categoria.id")
    @Mapping(source = "proveedorId", target = "proveedor.id")
    Producto toEntity(ProductoRequest request);

    ProductoResponse toResponse(Producto entity);

    List<ProductoResponse> toResponseList(List<Producto> entities);

    @Mapping(source = "categoriaId", target = "categoria.id")
    @Mapping(source = "proveedorId", target = "proveedor.id")
    void updateEntityFromRequest(ProductoRequest request, @MappingTarget Producto entity);
}




