package com.pruebatecnica.prueba.router.handler;

import com.pruebatecnica.prueba.model.dto.pedido.request.PedidoCreate;
import com.pruebatecnica.prueba.model.dto.pedido.response.PedidoDetalladoResponse;
import com.pruebatecnica.prueba.model.dto.pedido.response.PedidoResponse;
import com.pruebatecnica.prueba.service.PedidoService;
import com.pruebatecnica.prueba.validator.ObjectValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class PedidoHandler {

    private final PedidoService pedidoService;
    private final ObjectValidator objectValidator;

    public Mono<ServerResponse> findAll(ServerRequest request) {
        Flux<PedidoResponse> pedidos = pedidoService.findAll();

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(pedidos, PedidoResponse.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        Long id = Long.parseLong(request.pathVariable("pedidoId"));
        Mono<PedidoDetalladoResponse> pedido = pedidoService.findById(id);

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(pedido, PedidoDetalladoResponse.class);
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        Mono<PedidoCreate> dtoMono = request
                .bodyToMono(PedidoCreate.class)
                .doOnNext(objectValidator::validate);

        return dtoMono.flatMap(dto ->
                ServerResponse.status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(pedidoService.save(dto), PedidoDetalladoResponse.class)
        );
    }

}
