package com.example.EjercicioAutonomo.Dto;

import com.example.EjercicioAutonomo.Entity.Producto;

import java.util.List;

public class ProveedorDTO {

    private Long id;
    private String nombre;
    private String telefono;
    private String email;
    private String direccion;

    private List<Producto> productos;

    public ProveedorDTO(Long id, String nombre, String telefono, String email, String direccion, List<Producto> productos) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.productos = productos;
    }

    public ProveedorDTO(){}

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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
