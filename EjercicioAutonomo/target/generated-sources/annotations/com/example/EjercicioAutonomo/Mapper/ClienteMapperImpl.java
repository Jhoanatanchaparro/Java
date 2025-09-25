package com.example.EjercicioAutonomo.Mapper;

import com.example.EjercicioAutonomo.Dto.Request.ClienteRequest;
import com.example.EjercicioAutonomo.Dto.Response.ClienteResponse;
import com.example.EjercicioAutonomo.Dto.Response.OrdenDetalleResponse;
import com.example.EjercicioAutonomo.Entity.Cliente;
import com.example.EjercicioAutonomo.Entity.Orden_Compra;
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
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public Cliente toEntity(ClienteRequest request) {
        if ( request == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setDireccion( request.getDireccion() );
        cliente.setEmail( request.getEmail() );
        cliente.setNombre( request.getNombre() );
        cliente.setTelefono( request.getTelefono() );

        return cliente;
    }

    @Override
    public ClienteResponse toResponse(Cliente cliente) {
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

    @Override
    public List<ClienteResponse> toResponseList(List<Cliente> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ClienteResponse> list = new ArrayList<ClienteResponse>( entities.size() );
        for ( Cliente cliente : entities ) {
            list.add( toResponse( cliente ) );
        }

        return list;
    }

    @Override
    public void updateEntityFromRequest(ClienteRequest request, Cliente cliente) {
        if ( request == null ) {
            return;
        }

        cliente.setDireccion( request.getDireccion() );
        cliente.setEmail( request.getEmail() );
        cliente.setNombre( request.getNombre() );
        cliente.setTelefono( request.getTelefono() );
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
}
