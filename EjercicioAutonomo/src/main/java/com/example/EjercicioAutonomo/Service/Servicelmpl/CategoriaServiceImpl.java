package com.example.EjercicioAutonomo.Service.Servicelmpl;

import com.example.EjercicioAutonomo.Dto.Request.CategoriaRequest;
import com.example.EjercicioAutonomo.Dto.Response.CategoriaResponse;
import com.example.EjercicioAutonomo.Entity.Categoria;
import com.example.EjercicioAutonomo.Exception.ResourceNotFoundException;
import com.example.EjercicioAutonomo.Mapper.CategoriaMapper;
import com.example.EjercicioAutonomo.Repository.CategoriaRepository;
import com.example.EjercicioAutonomo.Service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    @Override
    public List<CategoriaResponse> mostrarCategoria() {
        return categoriaMapper.toResponseList(categoriaRepository.findAll());
    }

    @Override
    public CategoriaResponse findById(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria", id));
        return categoriaMapper.toResponse(categoria);
    }

    @Override
    public CategoriaResponse crearCategoria(CategoriaRequest categoriaRequest) {
        Categoria categoria = categoriaMapper.toEntity(categoriaRequest);
        return categoriaMapper.toResponse(categoriaRepository.save(categoria));
    }

    @Override
    public CategoriaResponse actualizarCategoria(Long id, CategoriaRequest categoriaRequest) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria", id));

        categoriaMapper.updateEntityFromRequest(categoriaRequest, categoria);

        return categoriaMapper.toResponse(categoriaRepository.save(categoria));
    }

    @Override
    public void eliminarCategoria(Long id) {
        if (!categoriaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Categoria", id);
        }
        categoriaRepository.deleteById(id);
    }
}


