package com.pruebatecnica.prueba.service;

import com.pruebatecnica.prueba.model.dto.product.ProductoCreate;
import com.pruebatecnica.prueba.model.dto.product.ProductoResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductoService {
    Flux<ProductoResponse> findAll();
    Mono<ProductoResponse> findById(Long id);
    Mono<ProductoResponse> save(ProductoCreate create);
}
