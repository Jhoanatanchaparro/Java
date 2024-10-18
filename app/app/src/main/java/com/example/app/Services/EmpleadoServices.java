package com.example.app.Services;

import com.example.app.Entity.Empleado;
import com.example.app.Repository.EmpleadoRepository;


import java.util.List;
import java.util.Optional;

public class EmpleadoServices {

    private EmpleadoRepository empleadoRepository;

    public List<Empleado> obtenerTodos(){
        return empleadoRepository.findAll();
    }

    public Optional<Empleado> obtenerPorId(Long id){
        return empleadoRepository.findById(id);

    }
    public Empleado guardar(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public void eliminar(Long id){
        empleadoRepository.deleteById(id);;
    }
}