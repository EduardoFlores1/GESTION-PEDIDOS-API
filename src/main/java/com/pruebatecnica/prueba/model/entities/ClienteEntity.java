package com.pruebatecnica.prueba.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clientes")
public class ClienteEntity {
    @Id
    @Column(value = "id")
    private Long id;
    @Column(value = "username")
    private String username;
    @Column(value = "email")
    private String email;
    @Column(value = "nombres")
    private String nombres;
    @Column(value = "apellidos")
    private String apellidos;
    @Column(value = "telefono")
    private String telefono;
    @Column(value = "direccion")
    private String direccion;
    @Column(value = "sexo")
    private String sexo;
    @Column(value = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
    @Column(value = "estado")
    private String estado;
    @Column(value = "created_at")
    private LocalDateTime createdAt;
    @Column(value = "updated_at")
    private LocalDateTime updatedAt;
}
