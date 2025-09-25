package com.example.EjercicioAutonomo.Dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoResponse {
    private Long id;
    private String nombre;
    private Double precio;
    private Integer cantidad;

    private Long categoriaId;
    private Long proveedorId;
}
