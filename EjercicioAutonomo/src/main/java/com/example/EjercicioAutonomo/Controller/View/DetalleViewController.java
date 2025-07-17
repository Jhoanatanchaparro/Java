package com.example.EjercicioAutonomo.Controller.View;

import com.example.EjercicioAutonomo.Dto.OrdenDetalleDTO;
import com.example.EjercicioAutonomo.Entity.Orden_Compra;
import com.example.EjercicioAutonomo.Entity.Orden_Detalle;

import com.example.EjercicioAutonomo.Entity.Producto;
import com.example.EjercicioAutonomo.Service.OrdenCompraService;
import com.example.EjercicioAutonomo.Service.OrdenDetalleService;
import com.example.EjercicioAutonomo.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vista/detalles")
public class DetalleViewController {

    @Autowired
    private OrdenDetalleService ordenDetalleService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private OrdenCompraService ordenCompraService;

    @GetMapping
    public String obtenerTodosLosDetalles (Model model){
        List<Orden_Detalle> detalles = ordenDetalleService.mostrarOrdenDetalle();
        List<Producto> productos = productoService.mostrarProducto();
        List<Orden_Compra> ordenCompras= ordenCompraService.mostrarOrdencompra();

        model.addAttribute("detalles", detalles);
        model.addAttribute("productos", productos);
        model.addAttribute("ordenes", ordenCompras);
        return "detalles";
    }
    @PostMapping("/guardar")
    public String crearDetalle(@ModelAttribute OrdenDetalleDTO ordenDetalleDTO){
        ordenDetalleService.crearDetalle(ordenDetalleDTO);
        return "redirect:/vista/detalles";
    }
    @PostMapping("/actualizar")
    public String actualizarDetalle(@ModelAttribute OrdenDetalleDTO ordenDetalleDTO){
        if (ordenDetalleDTO.getProducto() == null){
            throw new IllegalArgumentException("El campo producto es obligatorio");
        }
        if (ordenDetalleDTO.getOrdenCompra() == null){
            throw new IllegalArgumentException("El campo ordencompra es obligatorio");
        }
        ordenDetalleService.actualizarDetalle(ordenDetalleDTO.getId(), ordenDetalleDTO);
        return "redirect:/vista/detalles";
    }

    @PostMapping("/eliminar")
    public String eliminarDetalle(@RequestParam("id") Long id){
        ordenDetalleService.eliminarCliente(id);
        return "redirect:/vista/detalles";
    }
}
