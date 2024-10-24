package com.example.Java_Ejecicio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Java_Ejecicio.Entity.Estudiantes;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiantes, Integer> {
}


