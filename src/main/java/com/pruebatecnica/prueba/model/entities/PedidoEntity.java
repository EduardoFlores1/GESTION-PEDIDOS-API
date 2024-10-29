package com.pruebatecnica.prueba.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "pedidos")
public class PedidoEntity {
    @Id
    private String id;
    private Long clienteId;
    private String numeroPedido;
    private Integer totalProductos;
    private BigDecimal montoTotal;
    private String estado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
