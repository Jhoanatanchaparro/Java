package com.example.EjercicioAutonomo.Controller.View;

import com.example.EjercicioAutonomo.Dto.Request.OrdenCompraRequest;
import com.example.EjercicioAutonomo.Dto.Response.ClienteResponse;
import com.example.EjercicioAutonomo.Dto.Response.OrdenCompraResponse;
import com.example.EjercicioAutonomo.Dto.Response.ProductoResponse;
import com.example.EjercicioAutonomo.Service.ClienteService;
import com.example.EjercicioAutonomo.Service.OrdenCompraService;
import com.example.EjercicioAutonomo.Service.ProductoService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vista/compras")
public class CompraViewController {

    private final OrdenCompraService ordenCompraService;
    private final ClienteService clienteService;
    private final ProductoService productoService;

    public CompraViewController(
            OrdenCompraService ordenCompraService,
            @Qualifier("clienteServiceImpl") ClienteService clienteService,
            ProductoService productoService) {
        this.ordenCompraService = ordenCompraService;
        this.clienteService = clienteService;
        this.productoService = productoService;
    }

    @GetMapping
    public String obtenerTodos(Model model) {
        List<OrdenCompraResponse> compras = ordenCompraService.mostrarOrdenCompra();
        List<ClienteResponse> clientes = clienteService.mostrarCliente();
        List<ProductoResponse> productos = productoService.mostrarProducto();

        model.addAttribute("productos", productos);
        model.addAttribute("clientes", clientes);
        model.addAttribute("compras", compras);

        return "compras";
    }

    @PostMapping("/guardar")
    public String crearCompra(@ModelAttribute OrdenCompraRequest ordenCompraRequest) {
        ordenCompraService.crearOrdenCompra(ordenCompraRequest);
        return "redirect:/vista/compras";
    }

    @PostMapping("/actualizar")
    public String actualizarCompra(@ModelAttribute OrdenCompraRequest ordenCompraRequest,
                                   @RequestParam("id") Long id) {
        ordenCompraService.actualizar(id, ordenCompraRequest);
        return "redirect:/vista/compras";
    }

    @PostMapping("/eliminar")
    public String eliminarCompra(@RequestParam("id") Long id) {
        ordenCompraService.eliminarOrdenCompra(id);
        return "redirect:/vista/compras";
    }
}


