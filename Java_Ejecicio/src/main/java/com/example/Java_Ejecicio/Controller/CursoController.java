package com.example.Java_Ejecicio.Controller;

import com.example.Java_Ejecicio.Entity.Curso;
import com.example.Java_Ejecicio.Services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public String getAllCursos(Model model) {
        List<Curso> cursos = cursoService.getAllCursos();
        model.addAttribute("cursos", cursos);
        return "verCursos";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable int id, Model model) {
        Curso Curso = cursoService.findById(id);
        model.addAttribute("curso", Curso);
        return "verCursos";
    }

    @PostMapping("/crear")
    public String createCurso(Model model) {
        model.addAttribute("curso", new Curso());
        return "crearCurso";
    }

    @PutMapping("/{id}")
    public String save(@PathVariable int id, Curso curso) {
        cursoService.save(curso);
        return "redirect:/cursos";
    }

    @DeleteMapping("/eliminar/{id}")
    public String delete(@PathVariable int id, Model model) {
        cursoService.delete(id);
        return "redirect:/cursos";
    }
}
