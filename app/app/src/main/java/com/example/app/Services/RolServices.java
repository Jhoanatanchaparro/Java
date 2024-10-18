package com.example.app.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.Entity.Rol;
import com.example.app.Repository.RolRepository;

@Service
public class RolServices {

    @Autowired
    private RolRepository rolRepository;

    public List<Rol> obtenerTodos(){
        return rolRepository.findAll();
    }

    public Optional<Rol> obtenerPorId(Long id){
        return rolRepository.findById(id);
    }

    public Rol guardar(Rol rol){
        return rolRepository.save(rol);
    }

    public void eliminar (Long id){
        rolRepository.deleteById(id);
    }
}