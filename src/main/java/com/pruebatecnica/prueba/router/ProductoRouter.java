package com.pruebatecnica.prueba.router;

import com.pruebatecnica.prueba.router.handler.ProductoHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class ProductoRouter {

    private static final String PATH = "api/v1/productos";

    @Bean
    RouterFunction<ServerResponse> productoFunction(ProductoHandler productoHandler) {
        return RouterFunctions.route()
                .GET(PATH, productoHandler::findAll)
                .GET(PATH + "/{productoId}", productoHandler::findById)
                .POST(PATH, productoHandler::save)
                .build();
    }
}
