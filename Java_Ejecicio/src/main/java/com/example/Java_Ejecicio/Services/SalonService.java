package com.example.Java_Ejecicio.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Java_Ejecicio.Entity.Salon;
import com.example.Java_Ejecicio.Repository.SalonRepository;

import java.util.List;

@Service
public class SalonService {

    @Autowired
    private SalonRepository salonRepository;

    public List<Salon> getAllSalones() {
        return salonRepository.findAll();
    }

    public Salon findById(int id){
        return salonRepository.findById(id).orElse(null);
    }

    public Salon save(Salon salon){
        return salonRepository.save(salon);
    }

    public void delete(int id){
        salonRepository.deleteById(id);
    }
}

