package com.icodeap.facturacion_prod.Repository;

import com.icodeap.facturacion_prod.Model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaReposistory extends JpaRepository<Factura, Integer> {
}
