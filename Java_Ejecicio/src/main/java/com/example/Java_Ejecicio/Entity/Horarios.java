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
@Table(name = "Horarios")
@NoArgsConstructor
public class Horarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHorario;
    private String horaInicio;
    private String horaFin;
    private int idGrados;
    private int idProfesor;
    private int diaSemana;
    private int idSalon;
    
    public Horarios(int idHorario, String horaInicio, String horaFin, int idGrados, int idProfesor, int diaSemana,
            int idSalon) {
        this.idHorario = idHorario;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.idGrados = idGrados;
        this.idProfesor = idProfesor;
        this.diaSemana = diaSemana;
        this.idSalon = idSalon;
    }

    
}
