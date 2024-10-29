package com.pruebatecnica.prueba.service;

import com.pruebatecnica.prueba.model.dto.cliente.ClienteCreate;
import com.pruebatecnica.prueba.model.dto.cliente.ClienteResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClienteService {
    Flux<ClienteResponse> findAll();
    Mono<ClienteResponse> findById(Long id);
    Mono<ClienteResponse> save(ClienteCreate create);
}
