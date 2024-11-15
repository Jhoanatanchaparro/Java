package com.example.EjercicioAutonomo.Service.Servicelmpl;

import com.example.EjercicioAutonomo.Dto.ProductoDTO;
import com.example.EjercicioAutonomo.Entity.Producto;
import com.example.EjercicioAutonomo.Repository.ProductoRepository;
import com.example.EjercicioAutonomo.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicelmpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> mostrarProducto() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public ProductoDTO crearProducto(ProductoDTO productoDTO) {
        Producto producto = convertirDTOAEntidad(productoDTO);
        producto = productoRepository.save(producto);
        return convertirEntidadDTO(producto);
    }

    @Override
    public ProductoDTO actualizarProducto(Long id, ProductoDTO productoDTO) {
        Optional<Producto> productoExistente = productoRepository.findById(id);
        if (productoExistente.isPresent()){
            Producto producto = productoExistente.get();
            producto.setId(productoDTO.getId());
            producto.setNombre(productoDTO.getNombre());
            producto.setPrecio(productoDTO.getPrecio());

            producto = productoRepository.save(producto);
            return convertirEntidadDTO(producto);
        }
        return null;
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }

    private ProductoDTO convertirEntidadDTO(Producto producto){
        if (producto == null){
            return null;
        }
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setId(producto.getId());
        productoDTO.setNombre(producto.getNombre());
        productoDTO.setPrecio(producto.getPrecio());
        return  productoDTO;
    }

    private Producto convertirDTOAEntidad(ProductoDTO productoDTO){
        if (productoDTO == null){
            return null;
        }

        Producto producto = new Producto(null, null, null,null, null, null);
        producto.setId(producto.getId());
        producto.setNombre(producto.getNombre());
        producto.setPrecio(producto.getPrecio());
        return producto;
    }
}
