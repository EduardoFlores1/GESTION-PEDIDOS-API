package com.pruebatecnica.prueba.router.handler;

import com.pruebatecnica.prueba.model.dto.cliente.ClienteCreate;
import com.pruebatecnica.prueba.model.dto.cliente.ClienteResponse;
import com.pruebatecnica.prueba.service.ClienteService;
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
public class ClienteHandler {

    private final ClienteService clienteService;
    private final ObjectValidator objectValidator;

    public Mono<ServerResponse> findAll(ServerRequest request) {
        Flux<ClienteResponse> clientes = clienteService.findAll();

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(clientes, ClienteResponse.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        Long id = Long.parseLong(request.pathVariable("clienteId"));
        Mono<ClienteResponse> cliente = clienteService.findById(id);

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(cliente, ClienteResponse.class);
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        Mono<ClienteCreate> dtoMono = request
                .bodyToMono(ClienteCreate.class)
                .doOnNext(objectValidator::validate);

        return dtoMono.flatMap(dto ->
                ServerResponse.status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(clienteService.save(dto), ClienteResponse.class)
                );
    }
}
