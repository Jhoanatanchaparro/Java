package com.example.Java_Ejecicio.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Java_Ejecicio.Entity.Estudiantes;
import com.example.Java_Ejecicio.Repository.EstudianteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public List<Estudiantes> getAllEstudiantes() {
        return estudianteRepository.findAll();
    }

    public ResponseEntity<Estudiantes> getEstudianteById(int id) {
        Optional<Estudiantes> estudiante = estudianteRepository.findById(id);
        return estudiante.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public Estudiantes createEstudiante(Estudiantes estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public ResponseEntity<Estudiantes> updateEstudiante(int id, Estudiantes estudianteDetails) {
        Optional<Estudiantes> estudiante = estudianteRepository.findById(id);
        if (estudiante.isPresent()) {
            Estudiantes updatedEstudiante = estudiante.get();
            updatedEstudiante.setNombre(estudianteDetails.getNombre());
            updatedEstudiante.setApellido(estudianteDetails.getApellido());
            updatedEstudiante.setFechaNacimiento(estudianteDetails.getFechaNacimiento());
            updatedEstudiante.setCorreoElectronico(estudianteDetails.getCorreoElectronico());
            return ResponseEntity.ok(estudianteRepository.save(updatedEstudiante));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> deleteEstudiante(int id) {
        Optional<Estudiantes> estudiante = estudianteRepository.findById(id);
        if (estudiante.isPresent()) {
            estudianteRepository.delete(estudiante.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
