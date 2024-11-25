package com.example.EjercicioAutonomo.Service;

import com.example.EjercicioAutonomo.Dto.CategoriaDTO;
import com.example.EjercicioAutonomo.Entity.Categoria;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CategoriaService  {

    List<Categoria> mostrarCategoria();

    Optional<Categoria> findById(Long id);

    CategoriaDTO crearCategoria(CategoriaDTO categoriaDTO);

    CategoriaDTO actualizarCategoria(Long id, CategoriaDTO categoriaDTO);

    void  eliminarCategoria(Long id);
}
