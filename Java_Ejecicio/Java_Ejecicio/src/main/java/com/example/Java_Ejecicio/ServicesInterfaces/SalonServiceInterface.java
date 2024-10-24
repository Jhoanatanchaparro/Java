package com.example.Java_Ejecicio.ServicesInterfaces;

import org.springframework.http.ResponseEntity;
import com.example.Java_Ejecicio.Entity.Salon;
import java.util.List;

public interface SalonServiceInterface {
    List<Salon> getAllSalones();
    ResponseEntity<Salon> getSalonById(int id);
    Salon createSalon(Salon salon);
    ResponseEntity<Salon> updateSalon(int id, Salon salonDetails);
    ResponseEntity<Void> deleteSalon(int id);
}

