package com.example.Java_Ejecicio.Controller;

import com.example.Java_Ejecicio.Services.ProfesorService;
import com.example.Java_Ejecicio.Entity.Profesor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @GetMapping
    public String getAllProfesor(Model model) {
        List<Profesor> profesor = profesorService.getAllProfesor();
        model.addAttribute("profesores", profesor);
        return "verProfesores";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable int id, Model model) {
        Profesor profesor = profesorService.findById(id);
        model.addAttribute("profesores", profesor);
        return "verProfesores";
    }

    @PostMapping("/crear")
    public String createProfesor(Model model) {
        model.addAttribute("profesores", new Profesor());
        return "crearProfesores";
    }

    @PutMapping("/{id}")
    public String save(@PathVariable int id, Profesor profesor) {
        profesorService.save(profesor);
        return "redirect:/profesores";
    }

    @DeleteMapping("/eliminar/{id}")
    public String delete(@PathVariable int id, Model model) {
        profesorService.delete(id);
        return "redirect:/profesores";
    }
}

