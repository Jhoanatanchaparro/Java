package com.example.Java_Ejecicio.Controller;

import com.example.Java_Ejecicio.Services.SalonService;
import com.example.Java_Ejecicio.Entity.Salon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/salones")
public class SalonController {

    @Autowired
    private SalonService salonService;

    @GetMapping
    public String getAllSalones(Model model) {
        List<Salon> salon = salonService.getAllSalones();
        model.addAttribute("salon", salon);
        return "verSalon";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable int id, Model model) {
        Salon salon = salonService.findById(id);
        model.addAttribute("salones", salon);
        return "verSalones";
    }

    @PostMapping("/crear")
    public String createSalon(Model model) {
        model.addAttribute("salon", new Salon());
        return "crearSalones";
    }

    @PutMapping("/{id}")
    public String save(@PathVariable int id, Salon salon) {
        salonService.save(salon);
        return "redirect:/salones";
    }

    @DeleteMapping("/eliminar/{id}")
    public String delete(@PathVariable int id, Model model) {
        salonService.delete(id);
        return "redirect:/salones";
    }

}
