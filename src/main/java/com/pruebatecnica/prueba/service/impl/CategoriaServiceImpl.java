package com.pruebatecnica.prueba.service.impl;

import com.pruebatecnica.prueba.mapper.CategoriaMapper;
import com.pruebatecnica.prueba.model.dto.categoria.CategoriaResponse;
import com.pruebatecnica.prueba.repository.CategoriaRepository;
import com.pruebatecnica.prueba.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository repository;
    private final CategoriaMapper mapper;

    @Override
    public Flux<CategoriaResponse> findAll() {
        return repository.findAll()
                .map(mapper::toResponse);
    }
}
