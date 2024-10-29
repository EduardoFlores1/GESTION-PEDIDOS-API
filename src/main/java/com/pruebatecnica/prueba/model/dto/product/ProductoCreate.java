package com.pruebatecnica.prueba.model.dto.product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import java.math.BigDecimal;

@Getter
public class ProductoCreate {
    @NotEmpty(message = "El campo nombre es requerido.")
    private String nombre;
    @NotEmpty(message = "El campo descripcion es requerido.")
    private String descripcion;
    @Min(value = 1, message = "El campo precio es requerido y minimo 1 sol.")
    private BigDecimal precio;
    @Min(value = 1, message = "El campo stock es requerido y mínimo un producto")
    private Integer stock;
    @NotEmpty(message = "El campo imageRul es requerido.")
    private String imageUrl;
    @NotNull(message = "El campo categoriaId es requerido.")
    private Long categoriaId;
}
