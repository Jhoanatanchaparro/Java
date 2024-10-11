package com.example.app.Services;

import com.example.app.Entity.Empleado;
import com.example.app.Repository.EmpleadoRepository;
import com.example.app.Servicesinterfaces.EmpleadoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServices implements EmpleadoImpl {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> listaEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public Optional<Empleado> obtenerEmpleadoPorId(Long id) {
        return empleadoRepository.findById(id);
    }

    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado actualizarEmpleado(Empleado empleado) {
        Optional<Empleado> empleadoExistente = empleadoRepository.findById(empleado.getId());
        if (empleadoExistente.isPresent()) {
            Empleado emp = empleadoExistente.get();
            emp.setNombre(empleado.getNombre());
            emp.setApellido(empleado.getApellido());
            emp.setTelefono(empleado.getTelefono());
            emp.setCorreoElectronico(empleado.getCorreoElectronico());
            emp.setDireccionResidencia(empleado.getDireccionResidencia());
            emp.setSalario(empleado.getSalario());
            return empleadoRepository.save(emp);
        }
        throw new IllegalArgumentException("Empleado no encontrado con ID: " + empleado.getId());

    }

    @Override
    public void eliminarEmpleado(Long id) {
        if (empleadoRepository.existsById(id)) {
            empleadoRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Empleado no encontrado con ID: " + id);
        }
    }
}
