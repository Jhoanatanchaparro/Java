package com.example.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.Entity.Empleado;

public interface EmpladoRepository extends JpaRepository < Empleado, Long> {

    
}