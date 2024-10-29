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
@Table(name = "Curso")
@NoArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCurso;
    private String nombreCurso;
    private String descripcionCurso;
    private int creditos;

    public Curso(int idCurso, String nombreCurso, String descripcionCurso, int creditos) {
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
        this.descripcionCurso = descripcionCurso;
        this.creditos = creditos;

    }
}
