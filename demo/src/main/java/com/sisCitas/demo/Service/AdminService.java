package com.sisCitas.demo.Service;

import java.util.List;

import com.sisCitas.demo.Dto.AdminDTO;

public interface AdminService {

    List<AdminDTO> findAll();
    
    AdminDTO findById(Long id);
 
    AdminDTO save (AdminDTO adminDTO);

    void delete(Long id);

}
