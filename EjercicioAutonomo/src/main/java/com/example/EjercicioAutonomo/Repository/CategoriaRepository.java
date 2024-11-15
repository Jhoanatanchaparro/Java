package com.example.EjercicioAutonomo.Repository;

import com.example.EjercicioAutonomo.Entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
