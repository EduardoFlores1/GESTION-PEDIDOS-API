package com.pruebatecnica.prueba.router;

import com.pruebatecnica.prueba.router.handler.CategoriaHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class CategoriaRouter {

    private static final String PATH = "api/v1/categorias";

    @Bean
    RouterFunction<ServerResponse> categoriaFunction(CategoriaHandler categoriaHandler) {
        return RouterFunctions.route()
                .GET(PATH, categoriaHandler::findAll)
                .build();
    }
}
