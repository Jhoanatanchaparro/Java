package com.example.Java_Ejecicio.Controller;


import com.example.Java_Ejecicio.Services.HorarioService;
import com.example.Java_Ejecicio.Entity.Horarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/horarios")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    @GetMapping
    public List<Horarios> getAllHorarios() {
        return horarioService.getAllHorarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Horarios> getHorarioById(@PathVariable int id) {
        return horarioService.getHorarioById(id);
    }

    @PostMapping
    public Horarios createHorario(@RequestBody Horarios horario) {
        return horarioService.createHorario(horario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Horarios> updateHorario(@PathVariable int id, @RequestBody Horarios horario) {
        return horarioService.updateHorario(id, horario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHorario(@PathVariable int id) {
        return horarioService.deleteHorario(id);
    }
}
