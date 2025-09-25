package com.example.EjercicioAutonomo.Controller.View;

import com.example.EjercicioAutonomo.Dto.Request.OrdenDetalleRequest;
import com.example.EjercicioAutonomo.Dto.Response.OrdenCompraResponse;
import com.example.EjercicioAutonomo.Dto.Response.OrdenDetalleResponse;
import com.example.EjercicioAutonomo.Dto.Response.ProductoResponse;
import com.example.EjercicioAutonomo.Entity.Orden_Compra;
import com.example.EjercicioAutonomo.Entity.Producto;
import com.example.EjercicioAutonomo.Service.OrdenCompraService;
import com.example.EjercicioAutonomo.Service.OrdenDetalleService;
import com.example.EjercicioAutonomo.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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
    public String obtenerTodosLosDetalles(Model model) {
        List<OrdenDetalleResponse> detalles = ordenDetalleService.mostrarOrdenDetalle();
        List<ProductoResponse> productos = productoService.mostrarProducto();
        List<OrdenCompraResponse> ordenCompras = ordenCompraService.mostrarOrdenCompra();

        model.addAttribute("detalles", detalles);
        model.addAttribute("productos", productos);
        model.addAttribute("ordenes", ordenCompras);
        return "detalles";
    }

    @PostMapping("/guardar")
    public String crearDetalle(@RequestParam("precio") BigDecimal precio,
                               @RequestParam("cantidad") Integer cantidad,
                               @RequestParam("productoId") Long productoId,
                               @RequestParam("ordenCompraId") Long ordenCompraId) {

        OrdenDetalleRequest request = new OrdenDetalleRequest();
        request.setPrecio(precio);
        request.setCantidad(cantidad);
        request.setProductoId(productoId);
        request.setOrdenCompraId(ordenCompraId);

        ordenDetalleService.crearDetalle(request);
        return "redirect:/vista/detalles";
    }

    @PostMapping("/actualizar")
    public String actualizarDetalle(@RequestParam("id") Long id,
                                    @RequestParam("precio") BigDecimal precio,
                                    @RequestParam("cantidad") Integer cantidad,
                                    @RequestParam("productoId") Long productoId,
                                    @RequestParam("ordenCompraId") Long ordenCompraId) {

        OrdenDetalleRequest request = new OrdenDetalleRequest();
        request.setPrecio(precio);
        request.setCantidad(cantidad);
        request.setProductoId(productoId);
        request.setOrdenCompraId(ordenCompraId);

        ordenDetalleService.actualizarDetalle(id, request);
        return "redirect:/vista/detalles";
    }


    @PostMapping("/eliminar")
    public String eliminarDetalle(@RequestParam("id") Long id) {
        ordenDetalleService.eliminarDetalle(id);
        return "redirect:/vista/detalles";
    }
}


