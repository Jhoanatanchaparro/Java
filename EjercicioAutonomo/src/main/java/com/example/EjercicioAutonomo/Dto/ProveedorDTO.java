package com.example.EjercicioAutonomo.Dto;

import com.example.EjercicioAutonomo.Entity.Producto;
import lombok.Data;

import java.util.List;
@Data
public class ProveedorDTO {
    private Long id;
    private String nombre;
    private String telefono;
    private String email;
    private String direccion;
    private List<Producto> productos;

}
