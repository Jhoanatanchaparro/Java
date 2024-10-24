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
@Table(name = "Nota")
@NoArgsConstructor
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNota;
    private int idEstudiante;
    private int idcurso;
    private double nota;
    private String fecha;
    public Nota(int idNota, int idEstudiante, int idcurso, double nota, String fecha) {
        this.idNota = idNota;
        this.idEstudiante = idEstudiante;
        this.idcurso = idcurso;
        this.nota = nota;
        this.fecha = fecha;
    }
}
