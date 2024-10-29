package com.example.Java_Ejecicio.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Java_Ejecicio.Entity.Curso;
import com.example.Java_Ejecicio.Repository.CursoRepository;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    public Curso findById(int id) {
        return cursoRepository.findById(id).orElse(null);
    }

    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    public void delete(int id) {
        cursoRepository.deleteById(id);
    }
}