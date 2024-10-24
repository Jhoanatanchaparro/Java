package com.example.Java_Ejecicio.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Java_Ejecicio.Entity.Profesor;
import com.example.Java_Ejecicio.Repository.ProfesorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    public List<Profesor> getAllProfesores() {
        return profesorRepository.findAll();
    }

    public ResponseEntity<Profesor> getProfesorById(int id) {
        Optional<Profesor> profesor = profesorRepository.findById(id);
        return profesor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public Profesor createProfesor(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    public ResponseEntity<Profesor> updateProfesor(int id, Profesor profesorDetails) {
        Optional<Profesor> profesor = profesorRepository.findById(id);
        if (profesor.isPresent()) {
            Profesor updatedProfesor = profesor.get();
            updatedProfesor.setNombre(profesorDetails.getNombre());
            updatedProfesor.setApellido(profesorDetails.getApellido());
            updatedProfesor.setCorreo(profesorDetails.getCorreo());
            updatedProfesor.setTelefono(profesorDetails.getTelefono());
            return ResponseEntity.ok(profesorRepository.save(updatedProfesor));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> deleteProfesor(int id) {
        Optional<Profesor> profesor = profesorRepository.findById(id);
        if (profesor.isPresent()) {
            profesorRepository.delete(profesor.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
