package com.example.EjercicioAutonomo.Dto;

import com.example.EjercicioAutonomo.Entity.Orden_Compra;
import com.example.EjercicioAutonomo.Entity.Producto;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class OrdenDetalleDTO {
    private Long id;
    private Integer cantidad;
    private BigDecimal precio;
    private Producto producto;
    private Orden_Compra ordenCompra;
}
