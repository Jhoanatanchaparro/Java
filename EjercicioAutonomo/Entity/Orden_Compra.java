package com.example.EjercicioAutonomo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = {"detalles", "cliente"})
@Table(name = "orden_compra")
public class Orden_Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

    @JsonIgnore
    @OneToMany(mappedBy = "ordenCompra", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Orden_Detalle> detalles;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

}
