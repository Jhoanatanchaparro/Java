package com.example.EjercicioAutonomo.Dto.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdenCompraResponse {
    private Long id;
    private LocalDate fecha;
    private BigDecimal total;
    private ClienteResponse cliente;
    private List<OrdenDetalleResponse> detalles;
}
