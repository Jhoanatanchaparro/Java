package com.example.Java_Ejecicio.Controller;

import com.example.Java_Ejecicio.Entity.Estudiantes;
import com.example.Java_Ejecicio.Services.EstudianteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public List<Estudiantes> getAllEstudiantes() {
        return estudianteService.getAllEstudiantes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiantes> getEstudianteById(@PathVariable int id) {
        return estudianteService.getEstudianteById(id);
    }

    @PostMapping
    public Estudiantes createEstudiante(@RequestBody Estudiantes estudiante) {
        return estudianteService.createEstudiante(estudiante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiantes> updateEstudiante(@PathVariable int id, @RequestBody Estudiantes estudiante) {
        return estudianteService.updateEstudiante(id, estudiante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstudiante(@PathVariable int id) {
        return estudianteService.deleteEstudiante(id);
    }
}

