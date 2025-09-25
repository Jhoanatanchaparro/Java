package com.example.EjercicioAutonomo.Service;

import com.example.EjercicioAutonomo.Dto.Request.CategoriaRequest;
import com.example.EjercicioAutonomo.Dto.Response.CategoriaResponse;

import java.util.List;

public interface CategoriaService  {
    List<CategoriaResponse> mostrarCategoria();
    CategoriaResponse findById(Long id);
    CategoriaResponse crearCategoria(CategoriaRequest categoriaRequest);
    CategoriaResponse actualizarCategoria(Long id, CategoriaRequest categoriaRequest);
    void  eliminarCategoria(Long id);
}
