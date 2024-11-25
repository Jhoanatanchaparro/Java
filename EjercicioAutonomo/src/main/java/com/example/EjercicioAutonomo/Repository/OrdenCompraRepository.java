package com.example.EjercicioAutonomo.Repository;

import com.example.EjercicioAutonomo.Entity.Orden_Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenCompraRepository extends JpaRepository<Orden_Compra, Long> {
}
