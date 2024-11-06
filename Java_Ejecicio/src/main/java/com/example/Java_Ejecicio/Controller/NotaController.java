package com.example.Java_Ejecicio.Controller;

import com.example.Java_Ejecicio.Services.NotaService;
import com.example.Java_Ejecicio.Entity.Nota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotaController {

    @Autowired
    private NotaService notaService;

    @GetMapping
    public String getAllNotas(Model model) {
        List<Nota> notas = notaService.getAllNotas();
        model.addAttribute("nota", notas);
        return "verNota";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable int id, Model model) {
        Nota nota = notaService.findById(id);
        model.addAttribute("curso", nota);
        return "verNota";
    }

    @PostMapping("/crear")
    public String createNota(Model model) {
        model.addAttribute("nota", new Nota());
        return "crearNota";
    }

    @PutMapping("/{id}")
    public String save(@PathVariable int id, Nota nota) {
        notaService.save(nota);
        return "redirect:/notas";
    }

    @DeleteMapping("/eliminar/{id}")
    public String delete(@PathVariable int id, Model model) {
        notaService.delete(id);
        return "redirect:/notas";
    }
}

