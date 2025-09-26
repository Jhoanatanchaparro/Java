package com.example.EjercicioAutonomo.Controller.View;

import com.example.EjercicioAutonomo.Dto.Request.ClienteRequest;
import com.example.EjercicioAutonomo.Dto.Response.ClienteResponse;
import com.example.EjercicioAutonomo.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vista/clientes")
public class ClienteViewController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String mostrarClientes(Model model) {
        List<ClienteResponse> clientes = clienteService.mostrarCliente();
        model.addAttribute("clientes", clientes);
        return "clientes";
    }

    @PostMapping("/guardar")
    public String crearCliente(@ModelAttribute ClienteRequest clienteRequest) {
        clienteService.crearCliente(clienteRequest);
        return "redirect:/vista/clientes";
    }

    @PostMapping("/actualizar")
    public String actualizarCliente(@ModelAttribute ClienteRequest clienteRequest, @RequestParam Long id) {
        clienteService.actualizarCliente(id, clienteRequest);
        return "redirect:/vista/clientes";
    }

    @PostMapping("/eliminar")
    public String eliminarCliente(@RequestParam Long id) {
        clienteService.eliminarCliente(id);
        return "redirect:/vista/clientes";
    }
}

