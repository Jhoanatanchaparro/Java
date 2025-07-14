package com.example.EjercicioAutonomo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String nombres;

    @Column(name = "Descripcion", nullable = false)
    private String descripcion;

    @JsonIgnore
    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;

}
