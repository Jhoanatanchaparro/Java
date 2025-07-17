package com.example.EjercicioAutonomo.Controller.View;

import com.example.EjercicioAutonomo.Dto.ClienteDTO;
import com.example.EjercicioAutonomo.Entity.Cliente;
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
        List<Cliente> clientes = clienteService.mostrarCliente();
        model.addAttribute("clientes", clientes);
        return "clientes";
    }

    @PostMapping("/guardar")
    public String crearCliente(@ModelAttribute ClienteDTO clienteDTO) {
        clienteService.crearCliente(clienteDTO);
        return "redirect:/vista/clientes";
    }

    @PostMapping("/actualizar")
    public String actualizarCliente(@ModelAttribute ClienteDTO clienteDTO) {
        clienteService.actualizarCliente(clienteDTO.getId(), clienteDTO);
        return "redirect:/vista/clientes";
    }

    @PostMapping("/eliminar")
    public String eliminarCliente(@RequestParam Long id) {
        clienteService.eliminarCliente(id);
        return "redirect:/vista/clientes";
    }
}
