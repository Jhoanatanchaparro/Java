package com.example.EjercicioAutonomo.Mapper;

import com.example.EjercicioAutonomo.Dto.Request.OrdenCompraRequest;
import com.example.EjercicioAutonomo.Dto.Request.OrdenDetalleRequest;
import com.example.EjercicioAutonomo.Dto.Response.OrdenCompraResponse;
import com.example.EjercicioAutonomo.Entity.Orden_Compra;
import com.example.EjercicioAutonomo.Entity.Orden_Detalle;
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
public class OrdenCompraMapperImpl implements OrdenCompraMapper {

    @Autowired
    private ClienteMapper clienteMapper;
    @Autowired
    private OrdenDetalleMapper ordenDetalleMapper;

    @Override
    public Orden_Compra toEntity(OrdenCompraRequest request) {
        if ( request == null ) {
            return null;
        }

        Orden_Compra orden_Compra = new Orden_Compra();

        orden_Compra.setDetalles( ordenDetalleRequestListToOrden_DetalleList( request.getDetalles() ) );

        return orden_Compra;
    }

    @Override
    public OrdenCompraResponse toResponse(Orden_Compra entity) {
        if ( entity == null ) {
            return null;
        }

        OrdenCompraResponse ordenCompraResponse = new OrdenCompraResponse();

        ordenCompraResponse.setCliente( clienteMapper.toResponse( entity.getCliente() ) );
        ordenCompraResponse.setDetalles( ordenDetalleMapper.toResponseList( entity.getDetalles() ) );
        ordenCompraResponse.setFecha( entity.getFecha() );
        ordenCompraResponse.setId( entity.getId() );
        ordenCompraResponse.setTotal( entity.getTotal() );

        return ordenCompraResponse;
    }

    @Override
    public List<OrdenCompraResponse> toResponseList(List<Orden_Compra> entities) {
        if ( entities == null ) {
            return null;
        }

        List<OrdenCompraResponse> list = new ArrayList<OrdenCompraResponse>( entities.size() );
        for ( Orden_Compra orden_Compra : entities ) {
            list.add( toResponse( orden_Compra ) );
        }

        return list;
    }

    @Override
    public void updateEntityFromRequest(OrdenCompraRequest request, Orden_Compra entity) {
        if ( request == null ) {
            return;
        }

        if ( entity.getDetalles() != null ) {
            List<Orden_Detalle> list = ordenDetalleRequestListToOrden_DetalleList( request.getDetalles() );
            if ( list != null ) {
                entity.getDetalles().clear();
                entity.getDetalles().addAll( list );
            }
            else {
                entity.setDetalles( null );
            }
        }
        else {
            List<Orden_Detalle> list = ordenDetalleRequestListToOrden_DetalleList( request.getDetalles() );
            if ( list != null ) {
                entity.setDetalles( list );
            }
        }
    }

    protected List<Orden_Detalle> ordenDetalleRequestListToOrden_DetalleList(List<OrdenDetalleRequest> list) {
        if ( list == null ) {
            return null;
        }

        List<Orden_Detalle> list1 = new ArrayList<Orden_Detalle>( list.size() );
        for ( OrdenDetalleRequest ordenDetalleRequest : list ) {
            list1.add( ordenDetalleMapper.toEntity( ordenDetalleRequest ) );
        }

        return list1;
    }
}
