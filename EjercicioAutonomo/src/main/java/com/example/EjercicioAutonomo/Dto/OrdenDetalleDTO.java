package com.example.EjercicioAutonomo.Dto;

import com.example.EjercicioAutonomo.Entity.Orden_Compra;
import com.example.EjercicioAutonomo.Entity.Producto;

import java.math.BigDecimal;
import java.util.List;

public class OrdenDetalleDTO {

    private Long id;
    private Integer cantidad;
    private BigDecimal precio;

    private Producto producto;
    private Orden_Compra ordenCompra;

    public OrdenDetalleDTO(Long id, Integer cantidad, BigDecimal precio, Producto productos, Orden_Compra ordenCompra) {
        this.id = id;
        this.cantidad = cantidad;
        this.precio = precio;
        this.producto = productos;
        this.ordenCompra = ordenCompra;
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

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Orden_Compra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(Orden_Compra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }
}
