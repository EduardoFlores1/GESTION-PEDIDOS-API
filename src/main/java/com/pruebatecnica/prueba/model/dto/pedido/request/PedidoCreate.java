package com.pruebatecnica.prueba.model.dto.pedido.request;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import java.util.List;

@Getter
public class PedidoCreate {
    @NotNull(message = "El campo clienteId es requerido.")
    private Long clienteId;
    @NotNull(message = "El campo items debe contener almenos un producto.")
    private List<PedidoItemCreate> items;
}
