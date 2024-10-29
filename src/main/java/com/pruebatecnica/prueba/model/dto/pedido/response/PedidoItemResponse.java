package com.pruebatecnica.prueba.model.dto.pedido.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoItemResponse {
    private String id;
    private Long productoId;
    private String nombre;
    private String descripcion;
    private String imageUrl;
    private Integer cantidad;
    private BigDecimal subTotal;
}
