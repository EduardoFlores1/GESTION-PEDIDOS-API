package com.pruebatecnica.prueba.repository;

import com.pruebatecnica.prueba.model.entities.PedidoEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PedidoRepository extends ReactiveMongoRepository<PedidoEntity, String> {
}
