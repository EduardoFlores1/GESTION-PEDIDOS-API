package com.pruebatecnica.prueba.service.impl;

import com.pruebatecnica.prueba.exception.CustomException;
import com.pruebatecnica.prueba.mapper.ProductoMapper;
import com.pruebatecnica.prueba.model.dto.product.ProductoCreate;
import com.pruebatecnica.prueba.model.dto.product.ProductoResponse;
import com.pruebatecnica.prueba.model.entities.ProductoEntity;
import com.pruebatecnica.prueba.model.enums.Estado;
import com.pruebatecnica.prueba.repository.ProductoRepository;
import com.pruebatecnica.prueba.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    private final static String NF_MESSAGE = "El producto no se ha encontrado.";

    @Override
    public Flux<ProductoResponse> findAll() {
        return productoRepository.findAll()
                .map(productoMapper::toResponse);
    }

    @Override
    public Mono<ProductoResponse> findById(Long id) {
        return productoRepository.findById(id)
                .map(productoMapper::toResponse)
                .switchIfEmpty(Mono.error(new CustomException(HttpStatus.NOT_FOUND, NF_MESSAGE)));
    }

    @Override
    public Mono<ProductoResponse> save(ProductoCreate create) {
        var dateTime = LocalDateTime.now();
        ProductoEntity entity = productoMapper.toEntity(create);
        entity.setEstado(Estado.ACTIVO.toString());
        entity.setCreatedAt(dateTime);
        entity.setUpdatedAt(dateTime);

        return productoRepository.save(entity)
                .map(productoMapper::toResponse);
    }
}
