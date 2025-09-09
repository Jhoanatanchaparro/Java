package com.example.EjercicioAutonomo.Dto;

import com.example.EjercicioAutonomo.Entity.Categoria;
import com.example.EjercicioAutonomo.Entity.Proveedor;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class ProductoDTO {
    private Long id;
    private String nombre;
    private BigDecimal precio;
    private Integer cantidad;
    private Categoria categoria;
    private Proveedor proveedor;
}
