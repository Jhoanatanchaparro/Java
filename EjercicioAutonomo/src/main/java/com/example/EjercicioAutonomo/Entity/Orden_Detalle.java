package com.example.EjercicioAutonomo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "Orden_Detalle")
public class Orden_Detalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "orden_id", nullable = false)
    private Orden_Compra ordenCompra;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @JsonIgnore
    @Column(nullable = false)
    private Integer cantidad;

    @JsonIgnore
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;
}
