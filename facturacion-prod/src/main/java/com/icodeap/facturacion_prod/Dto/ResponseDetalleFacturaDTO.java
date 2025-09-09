package com.icodeap.facturacion_prod.Dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ResponseDetalleFacturaDTO {
    private Integer idProducto;
    private Integer cantidad;
    private BigDecimal precio;
    private BigDecimal total;
}
