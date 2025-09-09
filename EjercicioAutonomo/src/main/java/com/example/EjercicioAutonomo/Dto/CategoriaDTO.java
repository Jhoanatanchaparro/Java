package com.example.EjercicioAutonomo.Dto;

import com.example.EjercicioAutonomo.Entity.Producto;
import lombok.Data;
import java.util.List;

@Data
public class CategoriaDTO {
    private Long id;
    private String nombres;
    private String descripcion;
    private List<Producto> productos;
}
