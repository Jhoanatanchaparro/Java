package com.example.EjercicioAutonomo.Dto;

import com.example.EjercicioAutonomo.Entity.Cliente;
import com.example.EjercicioAutonomo.Entity.Orden_Detalle;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Data
public class OrdenCompraDTO {
    private Long id;
    private LocalDate fecha = LocalDate.now();
    private BigDecimal total;
    private List<Orden_Detalle> detalles;
    private Cliente cliente;

}
