package com.example.EjercicioAutonomo.Dto;

import java.util.Date;

public class OrdenCompraDTO {

    private Long id;

    private Date fecha = new Date();

    private Double total;

    public OrdenCompraDTO(Long id, Date fecha, Double total) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
