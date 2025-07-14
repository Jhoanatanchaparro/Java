package com.example.EjercicioAutonomo.Dto;

import com.example.EjercicioAutonomo.Entity.Categoria;
import com.example.EjercicioAutonomo.Entity.Proveedor;

import java.math.BigDecimal;

public class ProductoDTO {

    private Long id;
    private String nombre;
    private BigDecimal precio;
    private Integer cantidad;

    private Categoria categoria;
    private Proveedor proveedor;

    public ProductoDTO(Long id, String nombre, BigDecimal precio, Integer cantidad, Categoria categoria, Proveedor proveedor) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.proveedor = proveedor;
    }

    public ProductoDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Categoria getCategoria() {
        return categoria; }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria; }

    public Proveedor getProveedor() {
        return proveedor; }
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor; }

}
