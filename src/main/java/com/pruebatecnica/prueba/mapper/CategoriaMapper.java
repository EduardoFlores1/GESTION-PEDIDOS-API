package com.pruebatecnica.prueba.mapper;

import com.pruebatecnica.prueba.model.dto.categoria.CategoriaResponse;
import com.pruebatecnica.prueba.model.entities.CategoriaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
    CategoriaResponse toResponse(CategoriaEntity entity);
}
