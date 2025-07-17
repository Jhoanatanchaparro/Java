package com.example.EjercicioAutonomo.Controller.View;

import com.example.EjercicioAutonomo.Dto.CategoriaDTO;
import com.example.EjercicioAutonomo.Entity.Categoria;
import com.example.EjercicioAutonomo.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vista/categorias")
public class CategoriaViewController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String obtenerTodasLasCategorias(Model model){
        List<Categoria> categorias = categoriaService.mostrarCategoria();
        model.addAttribute("categorias", categorias);
        return "categorias";
    }

    @PostMapping("/guardar")
    public String crearCategoria(@ModelAttribute CategoriaDTO categoriaDTO){
        categoriaService.crearCategoria(categoriaDTO);
        return "redirect:/vista/categorias";
    }

    @PostMapping("/actualizar")
    public String actualizarCategoria(@ModelAttribute CategoriaDTO categoriaDTO){
        categoriaService.actualizarCategoria(categoriaDTO.getId(), categoriaDTO);
        return "redirect:/vista/categorias";
    }
    @PostMapping("/eliminar")
    public String eliminarCategoria(@RequestParam("id") Long id) {
        categoriaService.eliminarCategoria(id);
        return "redirect:/vista/categorias";
    }
}
