package com.example.Java_Ejecicio.Controller;

import com.example.Java_Ejecicio.Services.NotaService;
import com.example.Java_Ejecicio.Entity.Nota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotaController {

    @Autowired
    private NotaService notaService;

    @GetMapping
    public List<Nota> getAllNotas() {
        return notaService.getAllNotas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nota> getNotaById(@PathVariable int id) {
        return notaService.getNotaById(id);
    }

    @PostMapping
    public Nota createNota(@RequestBody Nota nota) {
        return notaService.createNota(nota);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nota> updateNota(@PathVariable int id, @RequestBody Nota nota) {
        return notaService.updateNota(id, nota);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNota(@PathVariable int id) {
        return notaService.deleteNota(id);
    }
}

