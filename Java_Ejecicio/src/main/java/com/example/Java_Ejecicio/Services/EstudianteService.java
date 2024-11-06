package com.example.Java_Ejecicio.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Java_Ejecicio.Entity.Estudiantes;
import com.example.Java_Ejecicio.Repository.EstudianteRepository;

import java.util.List;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public List<Estudiantes> getAllEstudiantes() {
        return estudianteRepository.findAll();
    }

    public Estudiantes getEstudianteById(int id) {
        return estudianteRepository.findById(id).orElse(null);
    }

    public Estudiantes save(Estudiantes estudiantes) {
        return estudianteRepository.save(estudiantes);
    }

    public void delete(int id) {
        estudianteRepository.deleteById(id);
    }
}
