package com.example.EjercicioAutonomo.Dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteResponse {
    private Long id;
    private String nombre;
    private String telefono;
    private String email;
    private String direccion;

    private List<OrdenDetalleResponse> ordenes;
}