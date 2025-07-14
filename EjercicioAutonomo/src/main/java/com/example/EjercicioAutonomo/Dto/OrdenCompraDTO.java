package com.example.EjercicioAutonomo.Dto;

import com.example.EjercicioAutonomo.Entity.Cliente;
import com.example.EjercicioAutonomo.Entity.Orden_Detalle;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrdenCompraDTO {

    private Long id;
    private Date fecha = new Date();
    private BigDecimal total;
    private List<Orden_Detalle> detalles;
    private Cliente cliente;

    public OrdenCompraDTO(Long id, Date fecha, BigDecimal total, List<Orden_Detalle> detalles, Cliente cliente) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.detalles= detalles;
        this.cliente = cliente;
    }

    public OrdenCompraDTO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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
