package com.example.EjercicioAutonomo.Service.Servicelmpl;

import com.example.EjercicioAutonomo.Dto.ProductoDTO;
import com.example.EjercicioAutonomo.Entity.Categoria;
import com.example.EjercicioAutonomo.Entity.Producto;
import com.example.EjercicioAutonomo.Entity.Proveedor;
import com.example.EjercicioAutonomo.Repository.CategoriaRepository;
import com.example.EjercicioAutonomo.Repository.ProductoRepository;
import com.example.EjercicioAutonomo.Repository.ProveedorRepository;
import com.example.EjercicioAutonomo.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicelmpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

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
        if (productoExistente.isPresent()) {
            Producto producto = productoExistente.get();

            Long categoriaId = productoDTO.getCategoria() != null ? productoDTO.getCategoria().getId() : null;
            Long proveedorId = productoDTO.getProveedor() != null ? productoDTO.getProveedor().getId() : null;

            if (categoriaId == null) {
                throw new IllegalArgumentException("El id de la categoría no puede ser null");
            }

            if (proveedorId == null) {
                throw new IllegalArgumentException("El id del proveedor no puede ser null");
            }

            Categoria categoria = categoriaRepository.findById(categoriaId)
                    .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

            Proveedor proveedor = proveedorRepository.findById(proveedorId)
                    .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

            producto.setNombre(productoDTO.getNombre());
            producto.setPrecio(productoDTO.getPrecio());
            producto.setCantidad(productoDTO.getCantidad());
            producto.setCategoria(categoria);
            producto.setProveedor(proveedor);

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
        productoDTO.setCantidad(producto.getCantidad());
        productoDTO.setCategoria(producto.getCategoria());
        productoDTO.setProveedor(producto.getProveedor());
        return  productoDTO;
    }

    private Producto convertirDTOAEntidad(ProductoDTO productoDTO) {
        if (productoDTO == null) {
            return null;
        }

        Producto producto = new Producto();
        producto.setId(productoDTO.getId());
        producto.setNombre(productoDTO.getNombre());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setCantidad(productoDTO.getCantidad());

        if (productoDTO.getCategoria() != null && productoDTO.getCategoria().getId() != null) {
            Categoria categoria = categoriaRepository.findById(productoDTO.getCategoria().getId())
                    .orElseThrow(() -> new RuntimeException("Categoría no encontrada con ID: " + productoDTO.getCategoria().getId()));
            producto.setCategoria(categoria);
        } else {
            throw new RuntimeException("El ID de la categoría es obligatorio.");
        }

        if (productoDTO.getProveedor() != null && productoDTO.getProveedor().getId() != null) {
            Proveedor proveedor = proveedorRepository.findById(productoDTO.getProveedor().getId())
                    .orElseThrow(() -> new RuntimeException("Proveedor no encontrado con ID: " + productoDTO.getProveedor().getId()));
            producto.setProveedor(proveedor);
        } else {
            throw new RuntimeException("El ID del proveedor es obligatorio.");
        }

        return producto;
    }

}
