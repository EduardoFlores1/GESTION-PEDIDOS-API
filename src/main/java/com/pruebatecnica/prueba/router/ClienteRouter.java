package com.pruebatecnica.prueba.router;

import com.pruebatecnica.prueba.router.handler.ClienteHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class ClienteRouter {

    private static final String PATH = "api/v1/clientes";

    @Bean
    RouterFunction<ServerResponse> clienteFunction(ClienteHandler clienteHandler) {
        return RouterFunctions.route()
                .GET(PATH, clienteHandler::findAll)
                .GET(PATH + "/{clienteId}", clienteHandler::findById)
                .POST(PATH, clienteHandler::save)
                .build();
    }
}
