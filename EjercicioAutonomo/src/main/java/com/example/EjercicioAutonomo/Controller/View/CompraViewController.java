package com.example.EjercicioAutonomo.Controller.View;

import com.example.EjercicioAutonomo.Dto.OrdenCompraDTO;
import com.example.EjercicioAutonomo.Entity.Cliente;
import com.example.EjercicioAutonomo.Entity.Orden_Compra;
import com.example.EjercicioAutonomo.Entity.Orden_Detalle;
import com.example.EjercicioAutonomo.Entity.Producto;
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
    public String obtenerTodos (Model model){
        List<Orden_Compra> compras = ordenCompraService.mostrarOrdencompra();
        List<Cliente> clientes = clienteService.mostrarCliente();
        List<Orden_Detalle> orden_detalles = ordenDetalleService.mostrarOrdenDetalle();
        List<Producto> productos = productoService.mostrarProducto();

        model.addAttribute("productos", productos);
        model.addAttribute("clientes", clientes);
        model.addAttribute("detalles", orden_detalles);
        model.addAttribute("compras", compras);
        return "compras";
    }

    @PostMapping("/guardar")
    public String crearCompra(@ModelAttribute OrdenCompraDTO ordenCompraDTO){
        ordenCompraService.crearOrdenCompra(ordenCompraDTO);
        return "redirect:/vista/compras";
    }

    @PostMapping("/actualizar")
    public String actualizarCompra(@ModelAttribute OrdenCompraDTO ordenCompraDTO){
        ordenCompraService.actualizar(ordenCompraDTO.getId(), ordenCompraDTO);
        return "redirect:/vista/compras";
    }

    @PostMapping("/eliminar")
    public String eliminarCompra(@RequestParam("id") Long id){
        ordenCompraService.eliminarOrdenCompra(id);
        return "redirect:/vista/compras";
    }
}
