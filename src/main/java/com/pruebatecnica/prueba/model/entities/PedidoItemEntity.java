package com.pruebatecnica.prueba.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "pedido_item")
public class PedidoItemEntity {
    @Id
    private String id;
    private String pedidoId;
    private Long productoId;
    private Integer cantidad;
    private BigDecimal subTotal;
}
