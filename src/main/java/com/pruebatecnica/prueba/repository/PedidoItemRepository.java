package com.pruebatecnica.prueba.repository;

import com.pruebatecnica.prueba.model.entities.PedidoItemEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PedidoItemRepository extends ReactiveMongoRepository<PedidoItemEntity, String> {
}
