package com.example.EjercicioAutonomo.Mapper;

import com.example.EjercicioAutonomo.Dto.Request.ProductoRequest;
import com.example.EjercicioAutonomo.Dto.Response.ProductoResponse;
import com.example.EjercicioAutonomo.Entity.Categoria;
import com.example.EjercicioAutonomo.Entity.Producto;
import com.example.EjercicioAutonomo.Entity.Proveedor;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-25T16:26:25-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 24.0.1 (Oracle Corporation)"
)
@Component
public class ProductoMapperImpl implements ProductoMapper {

    @Override
    public Producto toEntity(ProductoRequest request) {
        if ( request == null ) {
            return null;
        }

        Producto producto = new Producto();

        producto.setCategoria( productoRequestToCategoria( request ) );
        producto.setProveedor( productoRequestToProveedor( request ) );
        producto.setNombre( request.getNombre() );
        producto.setPrecio( request.getPrecio() );
        producto.setCantidad( request.getCantidad() );

        return producto;
    }

    @Override
    public ProductoResponse toResponse(Producto entity) {
        if ( entity == null ) {
            return null;
        }

        ProductoResponse productoResponse = new ProductoResponse();

        productoResponse.setId( entity.getId() );
        productoResponse.setNombre( entity.getNombre() );
        if ( entity.getPrecio() != null ) {
            productoResponse.setPrecio( entity.getPrecio().doubleValue() );
        }
        productoResponse.setCantidad( entity.getCantidad() );

        return productoResponse;
    }

    @Override
    public List<ProductoResponse> toResponseList(List<Producto> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ProductoResponse> list = new ArrayList<ProductoResponse>( entities.size() );
        for ( Producto producto : entities ) {
            list.add( toResponse( producto ) );
        }

        return list;
    }

    @Override
    public void updateEntityFromRequest(ProductoRequest request, Producto entity) {
        if ( request == null ) {
            return;
        }

        if ( entity.getCategoria() == null ) {
            entity.setCategoria( new Categoria() );
        }
        productoRequestToCategoria1( request, entity.getCategoria() );
        if ( entity.getProveedor() == null ) {
            entity.setProveedor( new Proveedor() );
        }
        productoRequestToProveedor1( request, entity.getProveedor() );
        entity.setNombre( request.getNombre() );
        entity.setPrecio( request.getPrecio() );
        entity.setCantidad( request.getCantidad() );
    }

    protected Categoria productoRequestToCategoria(ProductoRequest productoRequest) {
        if ( productoRequest == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setId( productoRequest.getCategoriaId() );

        return categoria;
    }

    protected Proveedor productoRequestToProveedor(ProductoRequest productoRequest) {
        if ( productoRequest == null ) {
            return null;
        }

        Proveedor proveedor = new Proveedor();

        proveedor.setId( productoRequest.getProveedorId() );

        return proveedor;
    }

    protected void productoRequestToCategoria1(ProductoRequest productoRequest, Categoria mappingTarget) {
        if ( productoRequest == null ) {
            return;
        }

        mappingTarget.setId( productoRequest.getCategoriaId() );
    }

    protected void productoRequestToProveedor1(ProductoRequest productoRequest, Proveedor mappingTarget) {
        if ( productoRequest == null ) {
            return;
        }

        mappingTarget.setId( productoRequest.getProveedorId() );
    }
}
