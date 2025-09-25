package com.example.EjercicioAutonomo.Repository;

import com.example.EjercicioAutonomo.Entity.Orden_Detalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenDetalleRepository extends JpaRepository<Orden_Detalle, Long> {
}
