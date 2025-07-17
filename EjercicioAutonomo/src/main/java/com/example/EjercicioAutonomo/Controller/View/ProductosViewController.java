package com.example.EjercicioAutonomo.Controller.View;

import com.example.EjercicioAutonomo.Dto.ProductoDTO;
import com.example.EjercicioAutonomo.Entity.Categoria;
import com.example.EjercicioAutonomo.Entity.Producto;
import com.example.EjercicioAutonomo.Entity.Proveedor;
import com.example.EjercicioAutonomo.Service.CategoriaService;
import com.example.EjercicioAutonomo.Service.ProductoService;
import com.example.EjercicioAutonomo.Service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vista/productos")
public class ProductosViewController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public String obtenerTodosLosProductos(Model model){
        List<Producto> productos = productoService.mostrarProducto();
        List<Categoria> categorias = categoriaService.mostrarCategoria();
        List<Proveedor> proveedores = proveedorService.mostrarProveedor();

        model.addAttribute("productos", productos);
        model.addAttribute("categorias", categorias);
        model.addAttribute("proveedores", proveedores);

        return "productos";
    }


    @PostMapping("/guardar")
    public String crearProducto(@ModelAttribute ProductoDTO productoDTO){
        productoService.crearProducto(productoDTO);
        return "redirect:/vista/productos";
    }

    @PostMapping("/actualizar")
    public String actualizarProducto(@ModelAttribute ProductoDTO productoDTO) {
        if (productoDTO.getCantidad() == null) {
            throw new IllegalArgumentException("El campo 'cantidad' es obligatorio");
        }
        productoService.actualizarProducto(productoDTO.getId(), productoDTO);
        return "redirect:/vista/productos";
    }

    @PostMapping("/eliminar")
    public String eliminarProducto(@RequestParam("id") Long id){
        productoService.eliminarProducto(id);
        return "redirect:/vista/productos";
    }
}
