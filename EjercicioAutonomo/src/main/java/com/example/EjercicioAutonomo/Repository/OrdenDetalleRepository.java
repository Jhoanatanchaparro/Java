package com.example.EjercicioAutonomo.Repository;

import com.example.EjercicioAutonomo.Entity.Orden_Detalle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenDetalleRepository extends JpaRepository<Orden_Detalle, Long> {
}
