package com.example.EjercicioAutonomo.Service.Servicelmpl;

import com.example.EjercicioAutonomo.Dto.CategoriaDTO;
import com.example.EjercicioAutonomo.Entity.Categoria;
import com.example.EjercicioAutonomo.Repository.CategoriaRepository;
import com.example.EjercicioAutonomo.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServicelmpl implements CategoriaService{

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> mostrarCategoria() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public CategoriaDTO crearCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = convertirDTOAEntidad(categoriaDTO);
        categoria = categoriaRepository.save(categoria);
        return convertirEntidadDTO(categoria);
    }

    @Override
    public CategoriaDTO actualizarCategoria(Long id, CategoriaDTO categoriaDTO) {
        Optional<Categoria> categoriaExistente = categoriaRepository.findById(id);

        if (categoriaExistente.isPresent()) {
            Categoria categoria = categoriaExistente.get();
            categoria.setNombres(categoriaDTO.getNombres());
            categoria.setDescripcion(categoriaDTO.getDescripcion());

            categoria = categoriaRepository.save(categoria);
            return convertirEntidadDTO(categoria);
        }
        return null;
    }

    @Override
    public void eliminarCategoria(Long id) {
    categoriaRepository.deleteById(id);
    }

    private CategoriaDTO convertirEntidadDTO(Categoria categoria) {
        if (categoria== null) {
            return null;
        }
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId(categoria.getId());
        categoriaDTO.setNombres(categoria.getNombres());
        categoriaDTO.setDescripcion(categoria.getDescripcion());
        categoriaDTO.setProductos(categoria.getProductos());
        return categoriaDTO;
    }

    private Categoria convertirDTOAEntidad(CategoriaDTO categoriaDTO) {
        if (categoriaDTO == null){
            return null;
        }

        Categoria categoria = new Categoria();
        categoria.setId(categoria.getId());
        categoria.setNombres(categoriaDTO.getNombres());
        categoria.setDescripcion(categoriaDTO.getDescripcion());
        categoria.setProductos(categoriaDTO.getProductos());
        return categoria;
    }
}

