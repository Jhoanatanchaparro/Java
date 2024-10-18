package com.example.app.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.app.Entity.Empleado;

public interface EmpleadoRepository extends CrudRepository <Empleado, Long> {

}
