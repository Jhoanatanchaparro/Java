package com.example.EjercicioAutonomo.Service.Servicelmpl;

import com.example.EjercicioAutonomo.Dto.OrdenDetalleDTO;
import com.example.EjercicioAutonomo.Entity.Orden_Compra;
import com.example.EjercicioAutonomo.Entity.Orden_Detalle;
import com.example.EjercicioAutonomo.Entity.Producto;
import com.example.EjercicioAutonomo.Repository.OrdenCompraRepository;
import com.example.EjercicioAutonomo.Repository.OrdenDetalleRepository;
import com.example.EjercicioAutonomo.Repository.ProductoRepository;
import com.example.EjercicioAutonomo.Service.OrdenDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenDetalleServicelmpl implements OrdenDetalleService {

    @Autowired
    private OrdenDetalleRepository ordenDetalleRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    @Override
    public List<Orden_Detalle> mostrarOrdenDetalle() {
        return ordenDetalleRepository.findAll();
    }

    @Override
    public Optional<Orden_Detalle> findById(Long id) {
        return ordenDetalleRepository.findById(id);
    }

    @Override
    public OrdenDetalleDTO crearDetalle(OrdenDetalleDTO ordenDetalleDTO) {
        Orden_Detalle orden_detalle= convertirDTOAEntidad(ordenDetalleDTO);
        orden_detalle = ordenDetalleRepository.save(orden_detalle);
        return convertirEntidadDTO(orden_detalle);
    }

    @Override
    public OrdenDetalleDTO actualizarDetalle(Long id, OrdenDetalleDTO ordenDetalleDTO) {
        Optional<Orden_Detalle> detalleExistente= ordenDetalleRepository.findById(id);

        if (detalleExistente.isPresent()){
            Orden_Detalle orden_detalle = detalleExistente.get();
            orden_detalle.setId(ordenDetalleDTO.getId());
            orden_detalle.setPrecio(ordenDetalleDTO.getPrecio());
            orden_detalle.setCantidad(ordenDetalleDTO.getCantidad());

            Long productoId= ordenDetalleDTO.getProducto().getId();
            Optional<Producto> productoOptional = productoRepository.findById(productoId);
            productoOptional.ifPresent(orden_detalle::setProducto);

            Long ordenId = ordenDetalleDTO.getOrdenCompra().getId();
            Optional<Orden_Compra> ordenCompraOptional = ordenCompraRepository.findById(ordenId);
            ordenCompraOptional.ifPresent(orden_detalle::setOrdenCompra);

            orden_detalle=ordenDetalleRepository.save(orden_detalle);
            return convertirEntidadDTO(orden_detalle);
        }
        return null;
    }

    @Override
    public void eliminarCliente(Long id) {
        ordenDetalleRepository.deleteById(id);

    }

    private OrdenDetalleDTO convertirEntidadDTO(Orden_Detalle orden_detalle) {
        if (orden_detalle == null) {
            return null;
        }

        OrdenDetalleDTO ordenDetalleDTO = new OrdenDetalleDTO();
        ordenDetalleDTO.setId(orden_detalle.getId());
        ordenDetalleDTO.setPrecio(orden_detalle.getPrecio());
        ordenDetalleDTO.setCantidad(orden_detalle.getCantidad());
        ordenDetalleDTO.setProducto(orden_detalle.getProducto());
        ordenDetalleDTO.setOrdenCompra(orden_detalle.getOrdenCompra());
        return ordenDetalleDTO;
    }
    private Orden_Detalle convertirDTOAEntidad(OrdenDetalleDTO ordenDetalleDTO) {
        if (ordenDetalleDTO == null) {
            return null;
        }
        Orden_Detalle orden_detalle = new Orden_Detalle();
        orden_detalle.setPrecio(ordenDetalleDTO.getPrecio());
        orden_detalle.setCantidad(ordenDetalleDTO.getCantidad());

        if (ordenDetalleDTO.getProducto() != null && ordenDetalleDTO.getProducto().getId() != null){
            Producto producto = productoRepository.findById(ordenDetalleDTO.getProducto().getId()).orElse(null);
            orden_detalle.setProducto(producto);
        }

        if (ordenDetalleDTO.getOrdenCompra() != null && ordenDetalleDTO.getOrdenCompra().getId() != null){
            Orden_Compra ordenCompra= ordenCompraRepository.findById(ordenDetalleDTO.getOrdenCompra().getId()).orElse(null);
            orden_detalle.setOrdenCompra(ordenCompra);
        }

        return orden_detalle;
    }
}
