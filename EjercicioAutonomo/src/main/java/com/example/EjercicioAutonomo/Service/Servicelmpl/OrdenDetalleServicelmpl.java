package com.example.EjercicioAutonomo.Service.Servicelmpl;

import com.example.EjercicioAutonomo.Dto.OrdenDetalleDTO;
import com.example.EjercicioAutonomo.Entity.Orden_Detalle;
import com.example.EjercicioAutonomo.Repository.OrdenDetalleRepository;
import com.example.EjercicioAutonomo.Service.OrdenDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenDetalleServicelmpl implements OrdenDetalleService {

    @Autowired
    private OrdenDetalleRepository ordenDetalleRepository;

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

            orden_detalle=ordenDetalleRepository.save(orden_detalle);
            return convertirEntidadDTO(orden_detalle);
        }
        return null;
    }

    @Override
    public void eliminarCliente(Long id) {
        ordenDetalleRepository.deleteById(id);

    }

    private OrdenDetalleDTO convertirEntidadDTO(Orden_Detalle orden_detalle){

        if (orden_detalle == null){
            return null;
        }

        OrdenDetalleDTO ordenDetalleDTO = new OrdenDetalleDTO();
        orden_detalle.setId(orden_detalle.getId());
        orden_detalle.setPrecio(orden_detalle.getPrecio());
        orden_detalle.setCantidad(orden_detalle.getCantidad());
        return ordenDetalleDTO;
    }

    private Orden_Detalle convertirDTOAEntidad(OrdenDetalleDTO ordenDetalleDTO){

        if (ordenDetalleDTO == null){
            return null;
        }
        Orden_Detalle orden_detalle = new Orden_Detalle(null, null, null, null, null);
        orden_detalle.setId(ordenDetalleDTO.getId());
        orden_detalle.setPrecio(ordenDetalleDTO.getPrecio());
        orden_detalle.setCantidad(orden_detalle.getCantidad());
        return  orden_detalle;
    }

}
