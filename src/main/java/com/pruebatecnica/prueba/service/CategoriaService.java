package com.pruebatecnica.prueba.service;

import com.pruebatecnica.prueba.model.dto.categoria.CategoriaResponse;
import reactor.core.publisher.Flux;

public interface CategoriaService {
    Flux<CategoriaResponse> findAll();
}
