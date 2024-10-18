package com.example.app.Servicesinterfaces;

import java.util.List;
import java.util.Optional;
import com.example.app.Entity.Empleado;

public interface EmpleadoImpl {

    List<Empleado> listaEmpleados();

    Optional<Empleado> obtenerEmpladoPorId(long id);

    Empleado guardarEmpleado(Empleado empleado);

    Empleado actualizarEmpleado(Empleado empleado);

    void eliminarEmplado(Long id);

}