package com.example.Java_Ejecicio.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Java_Ejecicio.Entity.Profesor;
import com.example.Java_Ejecicio.Repository.ProfesorRepository;

import java.util.List;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    public List<Profesor> getAllProfesor(){
        return profesorRepository.findAll();
    }

    public Profesor findById(int id){
        return profesorRepository.findById(id).orElse(null);
    }

    public Profesor save(Profesor profesor){
        return profesorRepository.save(profesor);
    }

    public void delete(int id ){
        profesorRepository.deleteById(id);
    }
}
