package com.example.EjercicioAutonomo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@Table(name="Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 15)
    private String telefono;

    @Column(length = 100)
    private String email;

    @Column(columnDefinition = "direccion")
    private  String direccion;

    @ManyToMany
    @JoinTable(
            name = "cliente_orden",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "orden_id")
    )
    private List<Orden_Compra> ordenes;
}
