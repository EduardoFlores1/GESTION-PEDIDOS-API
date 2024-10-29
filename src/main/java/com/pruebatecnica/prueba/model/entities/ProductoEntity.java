package com.pruebatecnica.prueba.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "productos")
public class ProductoEntity {
    @Id
    @Column(value = "id")
    private Long id;
    @Column(value = "nombre")
    private String nombre;
    @Column(value = "descripcion")
    private String descripcion;
    @Column(value = "precio")
    private BigDecimal precio;
    @Column(value = "stock")
    private Integer stock;
    @Column(value = "image_url")
    private String imageUrl;
    @Column(value = "categoria_id")
    private Long categoriaId;
    @Column(value = "estado")
    private String estado;
    @Column(value = "created_at")
    private LocalDateTime createdAt;
    @Column(value = "updated_at")
    private LocalDateTime updatedAt;
}
