package com.example.Java_Ejecicio.ServicesInterfaces;

import org.springframework.http.ResponseEntity;
import com.example.Java_Ejecicio.Entity.Horarios;
import java.util.List;

public interface HorarioServiceInterface {
    List<Horarios> getAllHorarios();
    ResponseEntity<Horarios> getHorarioById(int id);
    Horarios createHorario(Horarios horario);
    ResponseEntity<Horarios> updateHorario(int id, Horarios horarioDetails);
    ResponseEntity<Void> deleteHorario(int id);
}

