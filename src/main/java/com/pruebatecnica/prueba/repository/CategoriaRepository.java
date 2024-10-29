package com.pruebatecnica.prueba.repository;

import com.pruebatecnica.prueba.model.entities.CategoriaEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CategoriaRepository extends ReactiveCrudRepository<CategoriaEntity, Long> {
}
