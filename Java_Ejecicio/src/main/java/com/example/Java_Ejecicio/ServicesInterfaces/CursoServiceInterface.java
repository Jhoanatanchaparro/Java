package com.example.Java_Ejecicio.ServicesInterfaces;

import org.springframework.http.ResponseEntity;
import java.util.List;

import com.example.Java_Ejecicio.Entity.Curso;

public interface CursoServiceInterface {
    List<Curso> getAllCursos();
    ResponseEntity<Curso> getCursoById(int id);
    Curso createCurso(Curso curso);
    ResponseEntity<Curso> updateCurso(int id, Curso cursoDetails);
    ResponseEntity<Void> deleteCurso(int id);
}
