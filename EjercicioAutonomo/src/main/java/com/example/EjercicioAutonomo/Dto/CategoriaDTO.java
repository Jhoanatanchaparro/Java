package com.example.EjercicioAutonomo.Dto;

import com.example.EjercicioAutonomo.Entity.Producto;

import java.util.List;

public class CategoriaDTO {

    private Long id;
    private String nombres;
    private String descripcion;
    private List<Producto> productos;

    public CategoriaDTO(Long id, String nombres, String descripcion, List<Producto> productos) {
        this.id = id;
        this.nombres = nombres;
        this.descripcion = descripcion;
        this.productos = productos;
    }

    public CategoriaDTO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
