package com.pruebatecnica.prueba.mapper;

import com.pruebatecnica.prueba.model.dto.cliente.ClienteCreate;
import com.pruebatecnica.prueba.model.dto.cliente.ClienteResponse;
import com.pruebatecnica.prueba.model.entities.ClienteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClienteMapper {
    ClienteResponse toResponse(ClienteEntity entity);
    @Mapping(target = "sexo", expression = "java(mapSexo(create))")
    ClienteEntity toEntity(ClienteCreate create);

    default String mapSexo(ClienteCreate create) {
        return create.getSexo().name();
    }
}
