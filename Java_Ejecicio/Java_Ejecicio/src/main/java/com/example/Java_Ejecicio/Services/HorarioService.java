package com.example.Java_Ejecicio.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Java_Ejecicio.Entity.Horarios;
import com.example.Java_Ejecicio.Repository.HorarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    public List<Horarios> getAllHorarios() {
        return horarioRepository.findAll();
    }

    public ResponseEntity<Horarios> getHorarioById(int id) {
        Optional<Horarios> horario = horarioRepository.findById(id);
        return horario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public Horarios createHorario(Horarios horario) {
        return horarioRepository.save(horario);
    }

    public ResponseEntity<Horarios> updateHorario(int id, Horarios horarioDetails) {
        Optional<Horarios> horario = horarioRepository.findById(id);
        if (horario.isPresent()) {
            Horarios updatedHorario = horario.get();
            updatedHorario.setDiaSemana(horarioDetails.getDiaSemana());
            updatedHorario.setHoraInicio(horarioDetails.getHoraInicio());
            updatedHorario.setHoraFin(horarioDetails.getHoraFin());
            return ResponseEntity.ok(horarioRepository.save(updatedHorario));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> deleteHorario(int id) {
        Optional<Horarios> horario = horarioRepository.findById(id);
        if (horario.isPresent()) {
            horarioRepository.delete(horario.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

