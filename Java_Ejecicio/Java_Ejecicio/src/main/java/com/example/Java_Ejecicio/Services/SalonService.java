package com.example.Java_Ejecicio.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Java_Ejecicio.Entity.Salon;
import com.example.Java_Ejecicio.Repository.SalonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SalonService {

    @Autowired
    private SalonRepository salonRepository;

    public List<Salon> getAllSalones() {
        return salonRepository.findAll();
    }

    public ResponseEntity<Salon> getSalonById(int id) {
        Optional<Salon> salon = salonRepository.findById(id);
        return salon.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public Salon createSalon(Salon salon) {
        return salonRepository.save(salon);
    }

    public ResponseEntity<Salon> updateSalon(int id, Salon salonDetails) {
        Optional<Salon> salon = salonRepository.findById(id);
        if (salon.isPresent()) {
            Salon updatedSalon = salon.get();
            updatedSalon.setUbicacion(salonDetails.getUbicacion());
            updatedSalon.setCapacidad(salonDetails.getCapacidad());
            return ResponseEntity.ok(salonRepository.save(updatedSalon));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> deleteSalon(int id) {
        Optional<Salon> salon = salonRepository.findById(id);
        if (salon.isPresent()) {
            salonRepository.delete(salon.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

