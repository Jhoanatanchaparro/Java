package com.example.Java_Ejecicio.ServicesInterfaces;

import org.springframework.http.ResponseEntity;
import com.example.Java_Ejecicio.Entity.Nota;
import java.util.List;

public interface NotaServiceInterface {
    List<Nota> getAllNotas();
    ResponseEntity<Nota> getNotaById(int id);
    Nota createNota(Nota nota);
    ResponseEntity<Nota> updateNota(int id, Nota notaDetails);
    ResponseEntity<Void> deleteNota(int id);
}
