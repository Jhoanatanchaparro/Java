package com.icodeap.facturacion_prod.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name="facturas")
public class Factura {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private  Integer id;
    private String numeroFactura;
    private BigDecimal subTotal;
    private BigDecimal total;

    @Transient
    private  final double IVA = 0.15;

    @CreationTimestamp
    private LocalDateTime fechaCreado;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "factura", orphanRemoval = true)
    private Set<DetalleFactura> detalleFacturas;
}
