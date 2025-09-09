package com.example.EjercicioAutonomo.Dto;

import lombok.Data;

@Data
public class ClienteDTO {
    private Long id;
    private String nombre;
    private String telefono;
    private String email;
    private String direccion;

}
