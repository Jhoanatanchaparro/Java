package com.example.EjercicioAutonomo.Controller.View;

import com.example.EjercicioAutonomo.Dto.ProveedorDTO;
import com.example.EjercicioAutonomo.Entity.Proveedor;
import com.example.EjercicioAutonomo.Service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vista/proveedores")
public class ProveedorViewController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public String obtenerTodosLosProveedores(Model model){
        List<Proveedor> proveedor = proveedorService.mostrarProveedor();
        model.addAttribute("proveedores", proveedor);
        return "proveedores";
    }

    @PostMapping("/guardar")
    public String crearProveedor(@ModelAttribute ProveedorDTO proveedorDTO){
        proveedorService.crearProveedor(proveedorDTO);
        return "redirect:/vista/proveedores";
    }

    @PostMapping("/actualizar")
    public String actualizarProveedor(@ModelAttribute ProveedorDTO proveedorDTO){
        proveedorService.actualizar(proveedorDTO.getId(), proveedorDTO);
        return "redirect:/vista/proveedores";
    }

    @PostMapping("/eliminar")
    public String eliminarProveedor(@RequestParam("id") Long id){
        proveedorService.eliminarProveedor(id);
        return "redirect:/vista/proveedores";
    }
}
