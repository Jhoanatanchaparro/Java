package com.example.EjercicioAutonomo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(
        name = "proveedores",
        indexes = {
                @Index(name = "idx_proveedor_email", columnList = "email"),
                @Index(name = "idx_proveedor_telefono", columnList = "telefono")
        }
)
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 15, unique = true)
    private String telefono;

    @Column(length = 100, unique = true)
    private String email;

    @Column(length = 200)
    private String direccion;

    @JsonIgnore
    @OneToMany(mappedBy = "proveedor", fetch = FetchType.LAZY)
    private List<Producto> productos;
}
