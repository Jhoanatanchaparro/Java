package com.example.Java_Ejecicio.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Java_Ejecicio.Entity.Curso;
import com.example.Java_Ejecicio.Repository.CursoRepository;

import java.util.List;
import java.util.Optional;


@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    public ResponseEntity<Curso> getCursoById(int id) {
        Optional<Curso> curso = cursoRepository.findById(id);
        return curso.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public Curso createCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public ResponseEntity<Curso> updateCurso(int id, Curso cursoDetails) {
        Optional<Curso> curso = cursoRepository.findById(id);
        if (curso.isPresent()) {
            Curso updatedCurso = curso.get();
            updatedCurso.setNombreCurso(cursoDetails.getNombreCurso());
            updatedCurso.setDescripcionCurso(cursoDetails.getDescripcionCurso());
            updatedCurso.setCreditos(cursoDetails.getCreditos());
            return ResponseEntity.ok(cursoRepository.save(updatedCurso));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> deleteCurso(int id) {
        Optional<Curso> curso = cursoRepository.findById(id);
        if (curso.isPresent()) {
            cursoRepository.delete(curso.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
