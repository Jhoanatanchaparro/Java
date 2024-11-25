package com.example.EjercicioAutonomo.Repository;

import com.example.EjercicioAutonomo.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
