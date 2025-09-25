package com.example.EjercicioAutonomo.Controller.View;

import com.example.EjercicioAutonomo.Dto.Request.OrdenCompraRequest;
import com.example.EjercicioAutonomo.Dto.Response.ClienteResponse;
import com.example.EjercicioAutonomo.Dto.Response.OrdenCompraResponse;
import com.example.EjercicioAutonomo.Dto.Response.ProductoResponse;
import com.example.EjercicioAutonomo.Entity.Orden_Compra;
import com.example.EjercicioAutonomo.Entity.Orden_Detalle;
import com.example.EjercicioAutonomo.Service.ClienteService;
import com.example.EjercicioAutonomo.Service.OrdenCompraService;
import com.example.EjercicioAutonomo.Service.OrdenDetalleService;
import com.example.EjercicioAutonomo.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vista/compras")
public class CompraViewController {

    @Autowired
    private OrdenCompraService ordenCompraService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private OrdenDetalleService ordenDetalleService;

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public String obtenerTodos(Model model) {
        List<OrdenCompraResponse> compras = ordenCompraService.mostrarOrdenCompra();
        List<ClienteResponse> clientes = clienteService.mostrarCliente();
        List<ProductoResponse> productos = productoService.mostrarProducto();

        model.addAttribute("productos", productos);
        model.addAttribute("clientes", clientes);
        model.addAttribute("compras", compras);

        return "compras"; // Nombre de la plantilla Thymeleaf
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
