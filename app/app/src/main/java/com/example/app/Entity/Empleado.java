package com.example.app.Entity;

public class Empleado {
    private String telefono;
    private String correoElectronico;
    private String direccionResidencia;
    private String nombre;
    private String apellido;
    private double salario;

    public Empleado(String nombre, String apellido, String telefono, String correoElectronico,
            String direccionResidencia, double salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.direccionResidencia = direccionResidencia;
        this.salario = salario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getDireccionResidencia() {
        return direccionResidencia;
    }

    public void setDireccionResidencia(String direccionResidencia) {
        this.direccionResidencia = direccionResidencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}
