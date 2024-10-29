package com.pruebatecnica.prueba.model.dto.pedido.request;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class PedidoItemCreate {
    private Long productoId;
    private Integer cantidad;
}
