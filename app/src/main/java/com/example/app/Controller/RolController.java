package com.example.app.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.Entity.Rol;
import com.example.app.Services.RolServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private RolServices rolServices;

    @GetMapping("/list")
    public List<Rol> obtenerTodos() {
        return rolServices.obtenerTodos();
    }

    @GetMapping("/rol/{id}")
    public Optional<Rol> obtenerPorId(@PathVariable Long id) {
        return rolServices.obtenerPorId(id);
    }

    @PostMapping("/rol/{guardar}")
    public Rol guardar(@RequestBody Rol rol) {
        return rolServices.guardar(rol);
    }

    @GetMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        rolServices.eliminar(id);
    }
}