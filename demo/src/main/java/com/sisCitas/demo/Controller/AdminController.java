package com.sisCitas.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sisCitas.demo.Dto.AdminDTO;
import com.sisCitas.demo.Service.AdminService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public ResponseEntity<List<AdminDTO>> getAllAdmins(){
        List<AdminDTO> admins = adminService.findAll();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminDTO> getAdminsByid(@PathVariable Long id ){
        AdminDTO adminDTO = adminService.findById(id);
        return adminDTO != null ? new ResponseEntity<>(adminDTO, HttpStatus.OK)
                                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<AdminDTO> createAdmin(@RequestBody AdminDTO adminDTO) {
        System.out.println("AdminDTO:"+ adminDTO);
        AdminDTO newAdmin= adminService.save(adminDTO);
        return new ResponseEntity<>(newAdmin, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdminDTO> updateAdmin(@RequestBody Long id, @RequestBody AdminDTO adminDTO){
        AdminDTO existingAdmin = adminService.findById(id);
        if (existingAdmin == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        adminDTO.setAdmin_id(id);
        AdminDTO updateAdmin = adminService.save(adminDTO);
        return new ResponseEntity<>(updateAdmin, HttpStatus.OK);
    }    

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable Long id){
        AdminDTO adminDTO= adminService.findById(id);
        if (adminDTO == null){
            return new ResponseEntity<>("Admin no encontrado", HttpStatus.NOT_FOUND);
        }
        adminService.delete(id);
        return new ResponseEntity<>("Admin eliminado con exito:", HttpStatus.OK);
    }
}
