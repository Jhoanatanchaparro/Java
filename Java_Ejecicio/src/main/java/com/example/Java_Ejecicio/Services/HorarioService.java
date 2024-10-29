package com.example.Java_Ejecicio.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Java_Ejecicio.Services.HorarioService;


import com.example.Java_Ejecicio.Entity.Horarios;
import com.example.Java_Ejecicio.Repository.HorarioRepository;

import java.util.List;

@Service
public class HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    public List<Horarios> getAllHorarios(){
        return horarioRepository.findAll();
    }

    public Horarios findById(int id){
        return horarioRepository.findById(id).orElse(null);
    }

    public Horarios save(Horarios horarios){
        return horarioRepository.save(horarios);
    }

    public void delete(int id){
    horarioRepository.deleteById(id);
    }
}

