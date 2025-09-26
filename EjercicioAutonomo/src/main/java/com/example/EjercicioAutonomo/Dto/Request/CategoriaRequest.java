package com.example.EjercicioAutonomo.Dto.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoriaRequest {
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombres;
    @NotBlank
    private String descripcion;
}

