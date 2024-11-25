package com.example.EjercicioAutonomo.Dto;

import java.math.BigDecimal;

public class OrdenDetalleDTO {

    private Long id;

    private Integer cantidad;

    private BigDecimal precio;

    public OrdenDetalleDTO(Long id, Integer cantidad, BigDecimal precio) {
        this.id = id;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public OrdenDetalleDTO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
}
