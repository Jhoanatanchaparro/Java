package com.sisCitas.demo.Model;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@Table(name="admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "admin_id", nullable= false)
    private Long admin_id;

    @Column (name = "nombres", nullable= false, length = 100)
    private String nombres;

    @Column(name= "email", nullable= false, length=50)
    private String email;
    
    @Column (name = "password", nullable= false, length = 100)
    private String password;

}
