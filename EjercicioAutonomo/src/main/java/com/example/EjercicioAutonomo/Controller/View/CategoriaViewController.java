package com.example.EjercicioAutonomo.Controller.View;

import com.example.EjercicioAutonomo.Dto.Request.CategoriaRequest;
import com.example.EjercicioAutonomo.Dto.Response.CategoriaResponse;
import com.example.EjercicioAutonomo.Service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vista/categorias")
@RequiredArgsConstructor
public class CategoriaViewController {

    private final CategoriaService categoriaService;

    @GetMapping
    public String obtenerTodasLasCategorias(Model model) {
        List<CategoriaResponse> categorias = categoriaService.mostrarCategoria();
        model.addAttribute("categorias", categorias);
        model.addAttribute("categoriaForm", new CategoriaRequest());
        return "categorias";
    }

    @PostMapping("/guardar")
    public String crearCategoria(@ModelAttribute("categoriaForm") CategoriaRequest categoriaRequest) {
        categoriaService.crearCategoria(categoriaRequest);
        return "redirect:/vista/categorias";
    }

    @PostMapping("/actualizar")
    public String actualizarCategoria(@RequestParam("id") Long id,
                                      @ModelAttribute("categoriaForm") CategoriaRequest categoriaRequest) {
        categoriaService.actualizarCategoria(id, categoriaRequest);
        return "redirect:/vista/categorias";
    }

    @PostMapping("/eliminar")
    public String eliminarCategoria(@RequestParam("id") Long id) {
        categoriaService.eliminarCategoria(id);
        return "redirect:/vista/categorias";
    }
}
