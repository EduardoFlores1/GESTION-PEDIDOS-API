package com.pruebatecnica.prueba.service;

import com.pruebatecnica.prueba.model.dto.pedido.request.PedidoCreate;
import com.pruebatecnica.prueba.model.dto.pedido.response.PedidoDetalladoResponse;
import com.pruebatecnica.prueba.model.dto.pedido.response.PedidoResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PedidoService {
    Flux<PedidoResponse> findAll();
    Mono<PedidoDetalladoResponse> findById(Long id);
    Mono<PedidoResponse> save(PedidoCreate create);
    void cancelarById(String id);
}
