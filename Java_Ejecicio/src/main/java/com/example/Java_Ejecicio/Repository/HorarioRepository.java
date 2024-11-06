package com.example.Java_Ejecicio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Java_Ejecicio.Entity.Horarios;

@Repository
public interface HorarioRepository extends JpaRepository<Horarios, Integer> {
    // Métodos de consulta personalizados
}

