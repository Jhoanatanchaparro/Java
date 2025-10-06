package com.example.EjercicioAutonomo.Controller.View;

import com.example.EjercicioAutonomo.Dto.Request.ProveedorRequest;
import com.example.EjercicioAutonomo.Dto.Response.ProveedorResponse;
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
        List<ProveedorResponse> proveedores = proveedorService.mostrarProveedor();
        model.addAttribute("proveedores", proveedores);
        model.addAttribute("proveedorRequest", new ProveedorRequest());
        return "proveedores";
    }

    @PostMapping("/guardar")
    public String crearProveedor(@ModelAttribute("proveedorRequest") ProveedorRequest proveedorRequest){
        proveedorService.crearProveedor(proveedorRequest);
        return "redirect:/vista/proveedores";
    }

    @PostMapping("/actualizar")
    public String actualizarProveedor(@RequestParam("id") Long id,
                                      @ModelAttribute ProveedorRequest proveedorRequest){
        proveedorService.actualizar(id, proveedorRequest);
        return "redirect:/vista/proveedores";
    }

    @PostMapping("/eliminar")
    public String eliminarProveedor(@RequestParam("id") Long id){
        proveedorService.eliminarProveedor(id);
        return "redirect:/vista/proveedores";
    }
}

