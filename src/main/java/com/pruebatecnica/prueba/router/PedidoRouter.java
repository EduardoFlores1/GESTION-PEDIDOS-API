package com.pruebatecnica.prueba.router;

import com.pruebatecnica.prueba.router.handler.PedidoHandler;
import com.pruebatecnica.prueba.router.handler.ProductoHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class PedidoRouter {

    private static final String PATH = "api/v1/pedidos";

    @Bean
    RouterFunction<ServerResponse> pedidoFunction(PedidoHandler pedidoHandler) {
        return RouterFunctions.route()
                .GET(PATH, pedidoHandler::findAll)
                .GET(PATH + "/{pedidoId}", pedidoHandler::findById)
                .POST(PATH, pedidoHandler::save)
                .build();
    }
}
