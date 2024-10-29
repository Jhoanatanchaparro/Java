package com.example.Java_Ejecicio.ServicesInterfaces;

import org.springframework.http.ResponseEntity;

import com.example.Java_Ejecicio.Entity.Estudiantes;

import java.util.List;

public interface EstudianteServiceInterface {
    List<Estudiantes> getAllEstudiantes();
    ResponseEntity<Estudiantes> getEstudianteById(int id);
    Estudiantes createEstudiante(Estudiantes estudiante);
    ResponseEntity<Estudiantes> updateEstudiante(int id, Estudiantes estudianteDetails);
    ResponseEntity<Void> deleteEstudiante(int id);
}

