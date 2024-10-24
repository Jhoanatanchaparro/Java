package com.example.Java_Ejecicio.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Java_Ejecicio.Entity.Nota;
import com.example.Java_Ejecicio.Repository.NotaRepository;

import java.util.List;
import java.util.Optional;


@Service
public class NotaService {

    @Autowired
    private NotaRepository notaRepository;

    public List<Nota> getAllNotas() {
        return notaRepository.findAll();
    }

    public ResponseEntity<Nota> getNotaById(int id) {
        Optional<Nota> nota = notaRepository.findById(id);
        return nota.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public Nota createNota(Nota nota) {
        return notaRepository.save(nota);
    }

    public ResponseEntity<Nota> updateNota(int id, Nota notaDetails) {
        Optional<Nota> nota = notaRepository.findById(id);
        if (nota.isPresent()) {
            Nota updatedNota = nota.get();
            updatedNota.setIdNota(notaDetails.getIdNota());
            updatedNota.setFecha(notaDetails.getFecha());
            return ResponseEntity.ok(notaRepository.save(updatedNota));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> deleteNota(int id) {
        Optional<Nota> nota = notaRepository.findById(id);
        if (nota.isPresent()) {
            notaRepository.delete(nota.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

