package com.icodeap.facturacion_prod.Services;

import com.icodeap.facturacion_prod.Dto.ProductoDto;
import com.icodeap.facturacion_prod.Model.Producto;
import com.icodeap.facturacion_prod.Repository.ProductoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final ModelMapper modelMapper;

    public ProductoService(ProductoRepository productoRepository, ModelMapper modelMapper) {
        this.productoRepository = productoRepository;
        this.modelMapper = modelMapper;
    }

    public ProductoDto save(ProductoDto productoDto){
        Producto producto = modelMapper.map(productoDto, Producto.class);

        return modelMapper.map(productoRepository.save(producto), ProductoDto.class);
    }

    public List<ProductoDto> findAll(){
        return  productoRepository.findAll().stream().map(
                producto -> {
                    return modelMapper.map(producto, ProductoDto.class);
                }
        ).collect(Collectors.toList());
    }

    public Optional<ProductoDto> finfById(Integer id){
        return productoRepository.findById(id).map(
                producto -> {
                    return modelMapper.map(producto, ProductoDto.class);
                }
        );
    }

    public boolean deleteById (Integer id){
        return productoRepository.findById(id).map(
                producto -> {
                    productoRepository.delete(producto);
                    return true;
                }
        ).orElse(false);
    }

    public Optional<ProductoDto> update(ProductoDto productoDto){
        Producto producto= modelMapper.map(productoDto, Producto.class);

        return productoRepository.findById(producto.getId()).map(
                producto1 -> {
                    return modelMapper.map(productoRepository.save(producto), ProductoDto.class);
                }
        );
    }
}
