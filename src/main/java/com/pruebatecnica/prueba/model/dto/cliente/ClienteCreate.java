package com.pruebatecnica.prueba.model.dto.cliente;

import com.pruebatecnica.prueba.model.enums.Sexo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import java.time.LocalDate;

@Getter
public class ClienteCreate {
    @NotEmpty(message = "El campo username es requerido.")
    private String username;
    @Email(message = "El campo email es requerido.")
    private String email;
    @NotEmpty(message = "El campo nombres es requerido.")
    private String nombres;
    @NotEmpty(message = "El campo apellidos es requerido.")
    private String apellidos;
    @NotEmpty(message = "El campo telefono es requerido.")
    private String telefono;
    @NotEmpty(message = "El campo direccion es requerido.")
    private String direccion;
    private Sexo sexo;
    @NotNull(message = "El campo fechaNacimiento es requerido.")
    private LocalDate fechaNacimiento;
}
