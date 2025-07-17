package com.example.EjercicioAutonomo.Dto;

import com.example.EjercicioAutonomo.Entity.Cliente;
import com.example.EjercicioAutonomo.Entity.Orden_Detalle;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class OrdenCompraDTO {

    private Long id;
    private LocalDate fecha = LocalDate.now();
    private BigDecimal total;
    private List<Orden_Detalle> detalles;
    private Cliente cliente;

    public OrdenCompraDTO() {
    }

    public OrdenCompraDTO(Long id, LocalDate fecha, BigDecimal total, List<Orden_Detalle> detalles, Cliente cliente) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.detalles = detalles;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<Orden_Detalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Orden_Detalle> detalles) {
        this.detalles = detalles;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
