package com.example.Java_Ejecicio.ServicesInterfaces;

import org.springframework.http.ResponseEntity;
import com.example.Java_Ejecicio.Entity.Profesor;
import java.util.List;

public interface ProfesorServiceInterface {
    List<Profesor> getAllProfesores();
    ResponseEntity<Profesor> getProfesorById(int id);
    Profesor createProfesor(Profesor profesor);
    ResponseEntity<Profesor> updateProfesor(int id, Profesor profesorDetails);
    ResponseEntity<Void> deleteProfesor(int id);
}

