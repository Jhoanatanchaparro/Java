package com.icodeap.facturacion_prod.Services;

import com.icodeap.facturacion_prod.Dto.RequestDetalleFacturaDTO;
import com.icodeap.facturacion_prod.Dto.RequestFacturaDTO;
import com.icodeap.facturacion_prod.Dto.ResponseFacturaDTO;
import com.icodeap.facturacion_prod.Model.DetalleFactura;
import com.icodeap.facturacion_prod.Model.Factura;
import com.icodeap.facturacion_prod.Model.Producto;
import com.icodeap.facturacion_prod.Repository.FacturaReposistory;
import com.icodeap.facturacion_prod.Repository.ProductoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FacturaService {

    private final FacturaReposistory facturaReposistory;
    private final ProductoRepository productoRepository;
    private final ModelMapper modelMapper;

    public List<ResponseFacturaDTO> findAll(){
        return  facturaReposistory.findAll().stream().map(
                factura -> modelMapper.map(factura, ResponseFacturaDTO.class)
        ).collect(Collectors.toList());
    }

    public Optional<ResponseFacturaDTO> findById(Integer id){
        return  facturaReposistory.findById(id).map(
                factura -> modelMapper.map(factura, ResponseFacturaDTO.class)
        );
    }

    public void  deleteById(Integer id){
        facturaReposistory.deleteById(id);
    }

    @Transactional
    public ResponseFacturaDTO save(RequestFacturaDTO requestFacturaDTO){
        Factura factura = new Factura();
        BigDecimal subtotalFactura = BigDecimal.ZERO;
        Set<DetalleFactura> detalles = new HashSet<>();
        factura.setNumeroFactura(requestFacturaDTO.getNumeroFactura());

        for (RequestDetalleFacturaDTO detalleFacturaDTO: requestFacturaDTO.getDetalleFacturas()){
            Producto producto = productoRepository.findById(detalleFacturaDTO.getIdproducto()).orElseThrow(
                    ()-> new RuntimeException("Producto no encontrado")
            );
            BigDecimal totalProducto = producto.getPrecio().multiply(BigDecimal.valueOf(detalleFacturaDTO.getCantidad()));
            subtotalFactura = subtotalFactura.add(totalProducto);
            DetalleFactura detalleFactura =new DetalleFactura();
            detalleFactura.setIdProduto(detalleFacturaDTO.getIdproducto());
            detalleFactura.setPrecio(producto.getPrecio());
            detalleFactura.setCantidad(detalleFactura.getCantidad());
            detalleFactura.setTotal(totalProducto);
            detalleFactura.setFactura(factura);

            detalles.add(detalleFactura);
        }
        factura.setDetalleFacturas(detalles);
        factura.setSubTotal(subtotalFactura);
        factura.setTotal(subtotalFactura.add(subtotalFactura.multiply(BigDecimal.valueOf(factura.getIVA()))));

        Factura saveFactura = facturaReposistory.save(factura);
        return modelMapper.map(saveFactura, ResponseFacturaDTO.class);
    }
}
