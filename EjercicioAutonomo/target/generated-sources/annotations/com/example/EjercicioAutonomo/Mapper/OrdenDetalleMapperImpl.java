package com.example.EjercicioAutonomo.Mapper;

import com.example.EjercicioAutonomo.Dto.Request.OrdenDetalleRequest;
import com.example.EjercicioAutonomo.Dto.Response.ClienteResponse;
import com.example.EjercicioAutonomo.Dto.Response.OrdenCompraResponse;
import com.example.EjercicioAutonomo.Dto.Response.OrdenDetalleResponse;
import com.example.EjercicioAutonomo.Entity.Cliente;
import com.example.EjercicioAutonomo.Entity.Orden_Compra;
import com.example.EjercicioAutonomo.Entity.Orden_Detalle;
import com.example.EjercicioAutonomo.Entity.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-25T16:12:50-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.43.0.v20250819-1513, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class OrdenDetalleMapperImpl implements OrdenDetalleMapper {

    @Autowired
    private ProductoMapper productoMapper;

    @Override
    public Orden_Detalle toEntity(OrdenDetalleRequest request) {
        if ( request == null ) {
            return null;
        }

        Orden_Detalle.Orden_DetalleBuilder orden_Detalle = Orden_Detalle.builder();

        orden_Detalle.producto( ordenDetalleRequestToProducto( request ) );
        orden_Detalle.ordenCompra( ordenDetalleRequestToOrden_Compra( request ) );
        orden_Detalle.cantidad( request.getCantidad() );
        orden_Detalle.precio( request.getPrecio() );

        return orden_Detalle.build();
    }

    @Override
    public OrdenDetalleResponse toResponse(Orden_Detalle entity) {
        if ( entity == null ) {
            return null;
        }

        OrdenDetalleResponse ordenDetalleResponse = new OrdenDetalleResponse();

        ordenDetalleResponse.setProducto( productoMapper.toResponse( entity.getProducto() ) );
        ordenDetalleResponse.setOrdenCompra( orden_CompraToOrdenCompraResponse( entity.getOrdenCompra() ) );
        ordenDetalleResponse.setCantidad( entity.getCantidad() );
        ordenDetalleResponse.setId( entity.getId() );

        return ordenDetalleResponse;
    }

    @Override
    public List<OrdenDetalleResponse> toResponseList(List<Orden_Detalle> entities) {
        if ( entities == null ) {
            return null;
        }

        List<OrdenDetalleResponse> list = new ArrayList<OrdenDetalleResponse>( entities.size() );
        for ( Orden_Detalle orden_Detalle : entities ) {
            list.add( toResponse( orden_Detalle ) );
        }

        return list;
    }

    @Override
    public void updateEntityFromRequest(OrdenDetalleRequest request, Orden_Detalle entity) {
        if ( request == null ) {
            return;
        }

        if ( entity.getProducto() == null ) {
            entity.setProducto( new Producto() );
        }
        ordenDetalleRequestToProducto1( request, entity.getProducto() );
        if ( entity.getOrdenCompra() == null ) {
            entity.setOrdenCompra( new Orden_Compra() );
        }
        ordenDetalleRequestToOrden_Compra1( request, entity.getOrdenCompra() );
        entity.setCantidad( request.getCantidad() );
        entity.setPrecio( request.getPrecio() );
    }

    protected Producto ordenDetalleRequestToProducto(OrdenDetalleRequest ordenDetalleRequest) {
        if ( ordenDetalleRequest == null ) {
            return null;
        }

        Producto producto = new Producto();

        producto.setId( ordenDetalleRequest.getProductoId() );

        return producto;
    }

    protected Orden_Compra ordenDetalleRequestToOrden_Compra(OrdenDetalleRequest ordenDetalleRequest) {
        if ( ordenDetalleRequest == null ) {
            return null;
        }

        Orden_Compra orden_Compra = new Orden_Compra();

        orden_Compra.setId( ordenDetalleRequest.getOrdenCompraId() );

        return orden_Compra;
    }

    protected OrdenDetalleResponse orden_CompraToOrdenDetalleResponse(Orden_Compra orden_Compra) {
        if ( orden_Compra == null ) {
            return null;
        }

        OrdenDetalleResponse ordenDetalleResponse = new OrdenDetalleResponse();

        ordenDetalleResponse.setId( orden_Compra.getId() );

        return ordenDetalleResponse;
    }

    protected List<OrdenDetalleResponse> orden_CompraListToOrdenDetalleResponseList(List<Orden_Compra> list) {
        if ( list == null ) {
            return null;
        }

        List<OrdenDetalleResponse> list1 = new ArrayList<OrdenDetalleResponse>( list.size() );
        for ( Orden_Compra orden_Compra : list ) {
            list1.add( orden_CompraToOrdenDetalleResponse( orden_Compra ) );
        }

        return list1;
    }

    protected ClienteResponse clienteToClienteResponse(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        ClienteResponse clienteResponse = new ClienteResponse();

        clienteResponse.setDireccion( cliente.getDireccion() );
        clienteResponse.setEmail( cliente.getEmail() );
        clienteResponse.setId( cliente.getId() );
        clienteResponse.setNombre( cliente.getNombre() );
        clienteResponse.setOrdenes( orden_CompraListToOrdenDetalleResponseList( cliente.getOrdenes() ) );
        clienteResponse.setTelefono( cliente.getTelefono() );

        return clienteResponse;
    }

    protected OrdenCompraResponse orden_CompraToOrdenCompraResponse(Orden_Compra orden_Compra) {
        if ( orden_Compra == null ) {
            return null;
        }

        OrdenCompraResponse ordenCompraResponse = new OrdenCompraResponse();

        ordenCompraResponse.setCliente( clienteToClienteResponse( orden_Compra.getCliente() ) );
        ordenCompraResponse.setDetalles( toResponseList( orden_Compra.getDetalles() ) );
        ordenCompraResponse.setFecha( orden_Compra.getFecha() );
        ordenCompraResponse.setId( orden_Compra.getId() );
        ordenCompraResponse.setTotal( orden_Compra.getTotal() );

        return ordenCompraResponse;
    }

    protected void ordenDetalleRequestToProducto1(OrdenDetalleRequest ordenDetalleRequest, Producto mappingTarget) {
        if ( ordenDetalleRequest == null ) {
            return;
        }

        mappingTarget.setId( ordenDetalleRequest.getProductoId() );
    }

    protected void ordenDetalleRequestToOrden_Compra1(OrdenDetalleRequest ordenDetalleRequest, Orden_Compra mappingTarget) {
        if ( ordenDetalleRequest == null ) {
            return;
        }

        mappingTarget.setId( ordenDetalleRequest.getOrdenCompraId() );
    }
}
