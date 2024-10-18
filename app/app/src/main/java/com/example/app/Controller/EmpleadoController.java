package com.example.app.Controller;

import com.example.app.Entity.Empleado;
import com.example.app.Servicesinterfaces.EmpleadoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoImpl empleadoServices;

    @GetMapping("/list")
    public String listarEmpleados(Model model) {
        List<Empleado> empleados = empleadoServices.listaEmpleados();
        model.addAttribute("empleados", empleados);
        return "empleados/listar";
    }

    @GetMapping("/{id}")
    public String detalleEmpleado(@PathVariable Long id, Model model) {
        Empleado empleado = empleadoServices.obtenerEmpladoPorId(id).orElse(null);
        model.addAttribute("empleado", empleado);
        return "empleados/detalle";
    }
}
