package com.example.EjercicioAutonomo.Dto.Request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrdenDetalleRequest {
    @Positive
    private Integer cantidad;
    private BigDecimal precio;
    @NotNull
    private Long ordenCompraId;
    @NotNull
    private Long productoId;
}
