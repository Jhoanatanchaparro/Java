package com.example.Java_Ejecicio.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.ui.Model;


import com.example.Java_Ejecicio.Services.EstudianteService;
import com.example.Java_Ejecicio.Entity.Estudiantes;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public String getAllEstudiantes(Model model) {
        List<Estudiantes> estudiantes = estudianteService.getAllEstudiantes();
        model.addAttribute("estudiantes", estudiantes);
        return "verEstudiantes";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable int id, Model model) {
        Estudiantes estudiantes = estudianteService.getEstudianteById(id);
        model.addAttribute("estudiantes", estudiantes);
        return "verEstudiantes";
    }

    @PostMapping("/crear")
    public String createEstudiantes(Model model) {
        model.addAttribute("estudiantes", new Estudiantes());
        return "crearEstudiante";
    }

    @PutMapping("/{id}")
    public String save(@PathVariable int id, Estudiantes estudiantes) {
        estudianteService.save(estudiantes);
        return "redirect:/estudiantes";
    }

    @DeleteMapping("/eliminar/{id}")
    public String delete(@PathVariable int id, Model model) {
        estudianteService.delete(id);
        return "redirect:/estudiantes";
    }
}
