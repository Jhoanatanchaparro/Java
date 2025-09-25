package com.example.EjercicioAutonomo.Mapper;

import com.example.EjercicioAutonomo.Dto.Request.ProveedorRequest;
import com.example.EjercicioAutonomo.Dto.Response.ProductoResponse;
import com.example.EjercicioAutonomo.Dto.Response.ProveedorResponse;
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
public class ProveedorMapperImpl implements ProveedorMapper {

    @Override
    public Proveedor toEntity(ProveedorRequest request) {
        if ( request == null ) {
            return null;
        }

        Proveedor proveedor = new Proveedor();

        proveedor.setNombre( request.getNombre() );
        proveedor.setTelefono( request.getTelefono() );
        proveedor.setEmail( request.getEmail() );
        proveedor.setDireccion( request.getDireccion() );

        return proveedor;
    }

    @Override
    public ProveedorResponse toResponse(Proveedor entity) {
        if ( entity == null ) {
            return null;
        }

        ProveedorResponse proveedorResponse = new ProveedorResponse();

        proveedorResponse.setId( entity.getId() );
        proveedorResponse.setNombre( entity.getNombre() );
        proveedorResponse.setTelefono( entity.getTelefono() );
        proveedorResponse.setEmail( entity.getEmail() );
        proveedorResponse.setDireccion( entity.getDireccion() );
        proveedorResponse.setProductos( productoListToProductoResponseList( entity.getProductos() ) );

        return proveedorResponse;
    }

    @Override
    public List<ProveedorResponse> toResponseList(List<Proveedor> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ProveedorResponse> list = new ArrayList<ProveedorResponse>( entities.size() );
        for ( Proveedor proveedor : entities ) {
            list.add( toResponse( proveedor ) );
        }

        return list;
    }

    @Override
    public void updateEntityFromRequest(ProveedorRequest request, Proveedor entity) {
        if ( request == null ) {
            return;
        }

        entity.setNombre( request.getNombre() );
        entity.setTelefono( request.getTelefono() );
        entity.setEmail( request.getEmail() );
        entity.setDireccion( request.getDireccion() );
    }

    protected ProductoResponse productoToProductoResponse(Producto producto) {
        if ( producto == null ) {
            return null;
        }

        ProductoResponse productoResponse = new ProductoResponse();

        productoResponse.setId( producto.getId() );
        productoResponse.setNombre( producto.getNombre() );
        if ( producto.getPrecio() != null ) {
            productoResponse.setPrecio( producto.getPrecio().doubleValue() );
        }
        productoResponse.setCantidad( producto.getCantidad() );

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
