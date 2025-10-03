package com.example.EjercicioAutonomo.Repository;

import com.example.EjercicioAutonomo.Entity.Cliente;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("NullableProblems")
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @EntityGraph(attributePaths = "ordenes")
    List<Cliente> findAll();
}