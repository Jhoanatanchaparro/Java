package com.example.Java_Ejecicio.Controller;


import com.example.Java_Ejecicio.Services.HorarioService;
import com.example.Java_Ejecicio.Entity.Horarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/horarios")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    @GetMapping
    public String getAllHorario(Model model) {
        List<Horarios> horarios = horarioService.getAllHorarios();
        model.addAttribute("horarios", horarios);
        return "verHorarios";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable int id, Model model) {
        Horarios horarios = horarioService.findById(id);
        model.addAttribute("horario", horarios);
        return "verHorarios";
    }

    @PostMapping("/crear")
    public String createHorario(Model model) {
        model.addAttribute("horario", new Horarios());
        return "crearHorario";
    }

    @PutMapping("/{id}")
    public String save(@PathVariable int id, Horarios horarios) {
        horarioService.save(horarios);
        return "redirect:/horarios";
    }

    @DeleteMapping("/eliminar/{id}")
    public String delete(@PathVariable int id, Model model) {
        horarioService.delete(id);
        return "redirect:/horarios";
    }
}
