package com.example.EjercicioAutonomo.Mapper;

import com.example.EjercicioAutonomo.Dto.Request.CategoriaRequest;
import com.example.EjercicioAutonomo.Dto.Response.CategoriaResponse;
import com.example.EjercicioAutonomo.Dto.Response.ProductoResponse;
import com.example.EjercicioAutonomo.Entity.Categoria;
import com.example.EjercicioAutonomo.Entity.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-25T16:12:50-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.43.0.v20250819-1513, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class CategoriaMapperImpl implements CategoriaMapper {

    @Override
    public Categoria toEntity(CategoriaRequest request) {
        if ( request == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setDescripcion( request.getDescripcion() );
        categoria.setNombres( request.getNombres() );

        return categoria;
    }

    @Override
    public CategoriaResponse toResponse(Categoria entity) {
        if ( entity == null ) {
            return null;
        }

        CategoriaResponse categoriaResponse = new CategoriaResponse();

        categoriaResponse.setDescripcion( entity.getDescripcion() );
        categoriaResponse.setId( entity.getId() );
        categoriaResponse.setNombres( entity.getNombres() );
        categoriaResponse.setProductos( productoListToProductoResponseList( entity.getProductos() ) );

        return categoriaResponse;
    }

    @Override
    public List<CategoriaResponse> toResponseList(List<Categoria> entities) {
        if ( entities == null ) {
            return null;
        }

        List<CategoriaResponse> list = new ArrayList<CategoriaResponse>( entities.size() );
        for ( Categoria categoria : entities ) {
            list.add( toResponse( categoria ) );
        }

        return list;
    }

    @Override
    public void updateEntityFromRequest(CategoriaRequest request, Categoria entity) {
        if ( request == null ) {
            return;
        }

        entity.setDescripcion( request.getDescripcion() );
        entity.setNombres( request.getNombres() );
    }

    protected ProductoResponse productoToProductoResponse(Producto producto) {
        if ( producto == null ) {
            return null;
        }

        ProductoResponse productoResponse = new ProductoResponse();

        productoResponse.setCantidad( producto.getCantidad() );
        productoResponse.setId( producto.getId() );
        productoResponse.setNombre( producto.getNombre() );
        if ( producto.getPrecio() != null ) {
            productoResponse.setPrecio( producto.getPrecio().doubleValue() );
        }

        return productoResponse;
    }

    protected List<ProductoResponse> productoListToProductoResponseList(List<Producto> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductoResponse> list1 = new ArrayList<ProductoResponse>( list.size() );
        for ( Producto producto : list ) {
            list1.add( productoToProductoResponse( producto ) );
        }

        return list1;
    }
}
