package com.example.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.Entity.Empleado;

public interface EmpleadoRepository extends JpaRepository < Empleado, Long> {

}
