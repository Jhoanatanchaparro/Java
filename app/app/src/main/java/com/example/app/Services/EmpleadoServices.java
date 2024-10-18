package com.example.app.Services;

import com.example.app.Entity.Empleado;
import com.example.app.Repository.EmpleadoRepository;
import com.example.app.Servicesinterfaces.EmpleadoImpl;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServices implements EmpleadoImpl {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> listaEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        empleadoRepository.findAll().forEach(empleados::add);
        return empleados;

    }

    @Override
    public Optional<Empleado> obtenerEmpladoPorId(long id) {
        return empleadoRepository.findById(id);
    }

    @Override
    public Empleado guardarEmpleado(Empleado empleado) {

        throw new UnsupportedOperationException("Unimplemented method 'guardarEmpleado'");
    }

    @Override
    public Empleado actualizarEmpleado(Empleado empleado) {
        throw new UnsupportedOperationException("Unimplemented method 'actualizarEmpleado'");
    }

    @Override
    public void eliminarEmplado(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'eliminarEmplado'");
    }
}