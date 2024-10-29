package com.pruebatecnica.prueba.service.impl;

import com.pruebatecnica.prueba.exception.CustomException;
import com.pruebatecnica.prueba.mapper.ClienteMapper;
import com.pruebatecnica.prueba.model.dto.cliente.ClienteCreate;
import com.pruebatecnica.prueba.model.dto.cliente.ClienteResponse;
import com.pruebatecnica.prueba.model.entities.ClienteEntity;
import com.pruebatecnica.prueba.model.enums.Estado;
import com.pruebatecnica.prueba.repository.ClienteRepository;
import com.pruebatecnica.prueba.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    private final static String NF_MESSAGE = "Cliente no encontrado.";

    @Override
    public Flux<ClienteResponse> findAll() {
        return clienteRepository.findAll()
                .map(clienteMapper::toResponse);
    }

    @Override
    public Mono<ClienteResponse> findById(Long id) {
        return clienteRepository.findById(id)
                .map(clienteMapper::toResponse)
                .switchIfEmpty(Mono.error(new CustomException(HttpStatus.NOT_FOUND, NF_MESSAGE)));
    }

    @Override
    public Mono<ClienteResponse> save(ClienteCreate create) {
        var dateTime = LocalDateTime.now();
        ClienteEntity entity = clienteMapper.toEntity(create);
        entity.setEstado(Estado.ACTIVO.toString());
        entity.setCreatedAt(dateTime);
        entity.setUpdatedAt(dateTime);

        return clienteRepository.save(entity)
                .map(clienteMapper::toResponse);
    }
}
