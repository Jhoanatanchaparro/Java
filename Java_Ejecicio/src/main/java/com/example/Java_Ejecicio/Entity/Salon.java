package com.example.Java_Ejecicio.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Salon")
@NoArgsConstructor
public class Salon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSalon;
    private String ubicacion;
    private int capacidad;

    public Salon(int id, String ubicacion, int capacidad) {
        this.idSalon = id;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
    }
}
