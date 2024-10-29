package com.pruebatecnica.prueba.repository;

import com.pruebatecnica.prueba.model.entities.ClienteEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ClienteRepository extends ReactiveCrudRepository<ClienteEntity, Long> {
}
