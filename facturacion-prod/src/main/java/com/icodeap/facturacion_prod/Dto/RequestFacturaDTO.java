package com.icodeap.facturacion_prod.Dto;

import lombok.Data;

import java.util.Set;

@Data
public class RequestFacturaDTO {
    private Integer id;
    private String numeroFactura;
    private Set<RequestDetalleFacturaDTO> detalleFacturas;
}
