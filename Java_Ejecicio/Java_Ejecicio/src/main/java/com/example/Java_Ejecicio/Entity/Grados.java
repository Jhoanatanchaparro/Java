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
@Table(name = "Grados")
@NoArgsConstructor
public class Grados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGrados;
    private String nombreCurso;
    private String descripcionCurso;
    private int creditos;

    public Grados(int id, String nombreCurso, String descripcionCurso, int creditos) {
        this.idGrados = id;
        this.nombreCurso = nombreCurso;
        this.descripcionCurso = descripcionCurso;
        this.creditos = creditos;
    }
}
