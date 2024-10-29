package com.example.Java_Ejecicio.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Java_Ejecicio.Entity.Nota;
import com.example.Java_Ejecicio.Repository.NotaRepository;

import java.util.List;

@Service
public class NotaService {

    @Autowired
    private NotaRepository notaRepository;

    public List<Nota> getAllNotas(){
        return notaRepository.findAll();
    }

    public Nota findById(int id){
        return notaRepository.findById(id).orElse(null);
    }

    public Nota save(Nota nota){
        return notaRepository.save(nota);
    }

    public void delete(int id){
        notaRepository.deleteById(id);
    }
}

