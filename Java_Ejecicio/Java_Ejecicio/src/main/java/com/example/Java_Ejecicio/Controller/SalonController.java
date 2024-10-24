package com.example.Java_Ejecicio.Controller;

import com.example.Java_Ejecicio.Services.SalonService;
import com.example.Java_Ejecicio.Entity.Salon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/salones")
public class SalonController {

    @Autowired
    private SalonService salonService;

    @GetMapping
    public List<Salon> getAllSalones() {
        return salonService.getAllSalones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Salon> getSalonById(@PathVariable int id) {
        return salonService.getSalonById(id);
    }

    @PostMapping
    public Salon createSalon(@RequestBody Salon salon) {
        return salonService.createSalon(salon);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Salon> updateSalon(@PathVariable int id, @RequestBody Salon salon) {
        return salonService.updateSalon(id, salon);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalon(@PathVariable int id) {
        return salonService.deleteSalon(id);
    }
}
