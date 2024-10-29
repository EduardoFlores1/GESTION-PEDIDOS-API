package com.pruebatecnica.prueba.repository;

import com.pruebatecnica.prueba.model.entities.ProductoEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductoRepository extends ReactiveCrudRepository<ProductoEntity, Long> {
}
