package com.example.app.Entity;

import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    @OneToMany(mappedBy = "rol")
    private List<Empleado> empleados;

    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }
}
