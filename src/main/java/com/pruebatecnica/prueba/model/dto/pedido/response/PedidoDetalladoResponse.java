package com.pruebatecnica.prueba.model.dto.pedido.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDetalladoResponse {
    private String id;
    private String clienteUsername;
    private String clienteTelefono;
    private String numeroPedido;
    private Integer totalProductos;
    private BigDecimal montoTotal;
    private String estado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    List<PedidoItemResponse> items;
}
