package com.pruebatecnica.prueba.model.dto.cliente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponse {
    private Long id;
    private String username;
    private String email;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String direccion;
    private String sexo;
    private LocalDate fechaNacimiento;
    private String estado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
