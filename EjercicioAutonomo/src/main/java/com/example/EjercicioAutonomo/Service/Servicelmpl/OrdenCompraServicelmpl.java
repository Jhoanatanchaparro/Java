package com.example.EjercicioAutonomo.Service.Servicelmpl;

import com.example.EjercicioAutonomo.Dto.OrdenCompraDTO;
import com.example.EjercicioAutonomo.Dto.OrdenDetalleDTO;
import com.example.EjercicioAutonomo.Entity.Cliente;
import com.example.EjercicioAutonomo.Entity.Orden_Compra;
import com.example.EjercicioAutonomo.Entity.Orden_Detalle;
import com.example.EjercicioAutonomo.Repository.ClienteRepository;
import com.example.EjercicioAutonomo.Repository.OrdenCompraRepository;
import com.example.EjercicioAutonomo.Repository.OrdenDetalleRepository;
import com.example.EjercicioAutonomo.Service.OrdenCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrdenCompraServicelmpl implements OrdenCompraService {

    @Autowired
    private OrdenCompraRepository ordenCompraRepository;
    @Autowired
    private OrdenDetalleRepository ordenDetalleRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Orden_Compra> mostrarOrdencompra(){
        return ordenCompraRepository.findAll();
    }

    @Override
    public Optional<Orden_Compra> findById(Long id) {
        return ordenCompraRepository.findById(id);
    }

    @Override
    public OrdenCompraDTO crearOrdenCompra(OrdenCompraDTO ordenCompraDTO) {
        Orden_Compra ordenCompra =  convertirDTOAEntidad(ordenCompraDTO);
        ordenCompra = ordenCompraRepository.save(ordenCompra);
        return convertirEntidadDTO(ordenCompra);
    }

    @Override
    public OrdenCompraDTO actualizar(Long id, OrdenCompraDTO ordenCompraDTO) {
        Optional<Orden_Compra> ordenExistente = ordenCompraRepository.findById(id);

        if (ordenExistente.isPresent()){
            Orden_Compra ordenCompra = (Orden_Compra) ordenExistente.get();
            ordenCompra.setFecha(ordenCompraDTO.getFecha());
            ordenCompra.setTotal(ordenCompraDTO.getTotal());

            if (ordenCompraDTO.getCliente() != null && ordenCompraDTO.getCliente().getId() != null) {
                Cliente cliente = clienteRepository.findById(ordenCompraDTO.getCliente().getId())
                        .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
                ordenCompra.setCliente(cliente);
            }
            if (ordenCompraDTO.getDetalles() != null && !ordenCompraDTO.getDetalles().isEmpty()){
                List<Orden_Detalle> detalles = new ArrayList<>();
                for (Orden_Detalle ordenDetalle : ordenCompraDTO.getDetalles()){
                    Orden_Detalle detalle = ordenDetalleRepository.findById(ordenDetalle.getId())
                            .orElseThrow(() -> new RuntimeException("Detalle no encontrado "));
                    detalles.add(detalle);
                }
                ordenCompra.getDetalles().clear();
                ordenCompra.getDetalles().addAll(detalles);
            }
            ordenCompra = ordenCompraRepository.save(ordenCompra);
            return convertirEntidadDTO(ordenCompra);
        }
        return null;
    }

    @Override
    public void eliminarOrdenCompra(Long id) {
        ordenCompraRepository.deleteById(id);
    }

    private OrdenCompraDTO convertirEntidadDTO(Orden_Compra ordenCompra){
        if (ordenCompra== null){
            return null;
        }
        OrdenCompraDTO ordenCompraDTO =new OrdenCompraDTO();
        ordenCompraDTO.setId(ordenCompra.getId());
        ordenCompraDTO.setFecha(ordenCompra.getFecha());
        ordenCompraDTO.setTotal(ordenCompra.getTotal());
        ordenCompraDTO.setCliente(ordenCompra.getCliente());
        ordenCompraDTO.setDetalles(ordenCompra.getDetalles());
        return ordenCompraDTO;

    }

    private Orden_Compra convertirDTOAEntidad(OrdenCompraDTO ordenCompraDTO) {
        if (ordenCompraDTO == null){
            return null;
        }
        Orden_Compra ordenCompra = new Orden_Compra();
        ordenCompra.setFecha(ordenCompraDTO.getFecha());
        ordenCompra.setTotal(ordenCompraDTO.getTotal());

        if (ordenCompraDTO.getCliente() != null && ordenCompraDTO.getCliente().getId() != null) {
            Cliente cliente = clienteRepository.findById(ordenCompraDTO.getCliente().getId())
                    .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
            ordenCompra.setCliente(cliente);
        }
        if (ordenCompraDTO.getDetalles() != null && !ordenCompraDTO.getDetalles().isEmpty()) {
            List<Orden_Detalle> detalles = new ArrayList<>();

            for (Orden_Detalle ordenDetalleDTO : ordenCompraDTO.getDetalles()) {
                if(ordenDetalleDTO.getId() != null) {
                    Orden_Detalle detalle = ordenDetalleRepository.findById(ordenDetalleDTO.getId())
                            .orElseThrow(() -> new RuntimeException("Detalle no encontrado con ID: " + ordenDetalleDTO.getId()));
                    detalles.add(detalle);
                }
            }

            ordenCompra.setDetalles(detalles);
        }

        return ordenCompra;
    }
}
