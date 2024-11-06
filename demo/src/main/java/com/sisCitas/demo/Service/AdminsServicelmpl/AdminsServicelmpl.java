package com.sisCitas.demo.Service.AdminsServicelmpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisCitas.demo.Dto.AdminDTO;
import com.sisCitas.demo.Model.Admin;
import com.sisCitas.demo.Repository.AdminRepository;
import com.sisCitas.demo.Service.AdminService;

@Service
public class AdminsServicelmpl implements AdminService{

    @Autowired
    private AdminRepository admiRepository;

    @Override
    public List<AdminDTO> findAll() {
        return admiRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AdminDTO findById(Long id) {
        Optional<Admin> adminOptional = admiRepository.findById(id);
        return adminOptional.map(this:: convertToDTO).orElse(null);
    }

    @Override
    public AdminDTO save(AdminDTO adminDTO) {
        Admin admin = convertToEntity(adminDTO);
        Admin saveAdmin= admiRepository.save(admin);
        return convertToDTO(saveAdmin);
    }

    @Override
    public void delete(Long id) {
        admiRepository.deleteById(id);
    }

    private AdminDTO convertToDTO(Admin admin){
        if (admin == null){
            return null;
        }
        AdminDTO adminDTO= new AdminDTO();
        adminDTO.setAdmin_id(admin.getAdmin_id());
        adminDTO.setNombres(admin.getNombres());
        adminDTO.setEmail(admin.getEmail());
        adminDTO.setPassword(admin.getPassword());

        //System.out.println("AdminDTO GENERADO: "+ adminDTO);
        return adminDTO;
    }

    private Admin convertToEntity(AdminDTO adminDTO){
        if (adminDTO == null){
            return null;
        }

        Admin admin = new Admin(null, null, null, null);
        admin.setAdmin_id(adminDTO.getAdmin_id());
        admin.setNombres(adminDTO.getNombres());
        admin.setNombres(adminDTO.getNombres());
        admin.setEmail(adminDTO.getEmail());
        admin.setPassword(adminDTO.getPassword());

        return admin;
    }
}