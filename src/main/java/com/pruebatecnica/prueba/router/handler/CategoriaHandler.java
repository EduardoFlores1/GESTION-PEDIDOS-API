package com.pruebatecnica.prueba.router.handler;

import com.pruebatecnica.prueba.model.dto.categoria.CategoriaResponse;
import com.pruebatecnica.prueba.service.CategoriaService;
import com.pruebatecnica.prueba.validator.ObjectValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CategoriaHandler {

    private final CategoriaService categoriaService;
    private final ObjectValidator objectValidator;

    public Mono<ServerResponse> findAll(ServerRequest request) {
        Flux<CategoriaResponse> categorias = categoriaService.findAll();

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(categorias, CategoriaResponse.class);
    }
}
