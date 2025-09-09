package com.icodeap.facturacion_prod.Repository;

import com.icodeap.facturacion_prod.Model.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura, Integer> {
}
