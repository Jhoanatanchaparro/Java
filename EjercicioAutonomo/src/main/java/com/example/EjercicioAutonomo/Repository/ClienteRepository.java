package com.example.EjercicioAutonomo.Repository;

import com.example.EjercicioAutonomo.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT DISTINCT c FROM Cliente c LEFT JOIN FETCH c.ordenes")
    List<Cliente> findAllWithOrdenes();
}
