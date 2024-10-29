package com.pruebatecnica.prueba.mapper;

import com.pruebatecnica.prueba.model.dto.product.ProductoCreate;
import com.pruebatecnica.prueba.model.dto.product.ProductoResponse;
import com.pruebatecnica.prueba.model.entities.ProductoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    ProductoResponse toResponse(ProductoEntity entity);
    ProductoEntity toEntity(ProductoCreate create);
}
