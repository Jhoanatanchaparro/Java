package com.icodeap.facturacion_prod.Dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductoDto {

    private Integer id;
    private String nombre;
    private String detalle;
    private BigDecimal precio;

}
