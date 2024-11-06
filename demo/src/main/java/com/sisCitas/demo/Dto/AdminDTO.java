package com.sisCitas.demo.Dto;

public class AdminDTO {

    private Long admin_id;

    private String nombres;

    private String email;
    
    private String password;

    public AdminDTO(Long admin_id, String nombres, String email, String password) {
        this.admin_id = admin_id;
        this.nombres = nombres;
        this.email = email;
        this.password = password;
    }

    public AdminDTO(){}

    public Long getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Long admin_id) {
        this.admin_id = admin_id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
}
