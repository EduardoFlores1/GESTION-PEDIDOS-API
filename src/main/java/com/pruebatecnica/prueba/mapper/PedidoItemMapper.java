package com.pruebatecnica.prueba.mapper;

import com.pruebatecnica.prueba.model.dto.pedido.request.PedidoItemCreate;
import com.pruebatecnica.prueba.model.entities.PedidoItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PedidoItemMapper {
    PedidoItemEntity toEntity(PedidoItemCreate create);
}
