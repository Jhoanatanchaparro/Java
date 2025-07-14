package com.example.EjercicioAutonomo.Controller.View;

import com.example.EjercicioAutonomo.Service.ClienteService;
import com.example.EjercicioAutonomo.Entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteViewController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/vista")
    public String mostrarClientes(Model model) {
        List<Cliente> listaClientes = clienteService.mostrarCliente();
        model.addAttribute("clientes", listaClientes);
        return "clientes";
    }
}
