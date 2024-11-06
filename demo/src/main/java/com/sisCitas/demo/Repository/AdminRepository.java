package com.sisCitas.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisCitas.demo.Model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    
}
