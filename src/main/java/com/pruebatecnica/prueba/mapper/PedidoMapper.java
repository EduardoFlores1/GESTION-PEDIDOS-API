package com.pruebatecnica.prueba.mapper;

import com.pruebatecnica.prueba.model.dto.pedido.request.PedidoCreate;
import com.pruebatecnica.prueba.model.dto.pedido.response.PedidoResponse;
import com.pruebatecnica.prueba.model.entities.PedidoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        uses = PedidoItemMapper.class,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PedidoMapper {
    PedidoEntity toEntity(PedidoCreate create);
    PedidoResponse toResponse(PedidoEntity pedido);
}
