package com.example.EjercicioAutonomo.Dto.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductoRequest {
    @NotBlank
    private String nombre;
    @NotNull
    private BigDecimal precio;
    @NotNull
    private Integer cantidad;
    @NotNull
    private Long categoriaId;
    @NotNull
    private Long proveedorId;
}
