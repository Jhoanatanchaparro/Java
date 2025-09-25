package com.example.EjercicioAutonomo.Dto.Request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class OrdenCompraRequest {
    @NotNull
    private Long clienteId;
    @NotNull
    private List<OrdenDetalleRequest> detalles;
}
