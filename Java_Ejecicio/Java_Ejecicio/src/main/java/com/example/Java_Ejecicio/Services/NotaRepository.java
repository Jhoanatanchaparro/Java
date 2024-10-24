package com.example.Java_Ejecicio.Services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Java_Ejecicio.Entity.Nota;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Integer> {
    // Métodos de consulta personalizados
}
