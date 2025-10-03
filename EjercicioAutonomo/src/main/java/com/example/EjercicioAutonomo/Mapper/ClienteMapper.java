package com.example.EjercicioAutonomo.Mapper;

import com.example.EjercicioAutonomo.Dto.Request.ClienteRequest;
import com.example.EjercicioAutonomo.Dto.Response.ClienteResponse;
import com.example.EjercicioAutonomo.Entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    Cliente toEntity(ClienteRequest request);
    ClienteResponse toResponse(Cliente cliente);
    List<ClienteResponse> toResponseList(List<Cliente> entities);

    void updateEntityFromRequest(ClienteRequest request, @MappingTarget Cliente cliente);

    Cliente toEntityFromResponse(ClienteResponse response);
    List<Cliente> toEntityListFromResponse(List<ClienteResponse> responses);
}
