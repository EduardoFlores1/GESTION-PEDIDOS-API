package com.pruebatecnica.prueba.router.handler;

import com.pruebatecnica.prueba.model.dto.product.ProductoCreate;
import com.pruebatecnica.prueba.model.dto.product.ProductoResponse;
import com.pruebatecnica.prueba.service.ProductoService;
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
public class ProductoHandler {

    private final ProductoService productoService;
    private final ObjectValidator objectValidator;

    public Mono<ServerResponse> findAll(ServerRequest request) {
        Flux<ProductoResponse> productos = productoService.findAll();

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(productos, ProductoResponse.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        Long id = Long.parseLong(request.pathVariable("productoId"));
        Mono<ProductoResponse> producto = productoService.findById(id);

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(producto, ProductoResponse.class);
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        Mono<ProductoCreate> dtoMono = request
                .bodyToMono(ProductoCreate.class)
                .doOnNext(objectValidator::validate);

        return dtoMono.flatMap(dto ->
                ServerResponse.status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(productoService.save(dto), ProductoResponse.class)
                );
    }
}
