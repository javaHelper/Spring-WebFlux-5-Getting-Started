package com.example.demo.config;

import com.example.demo.handler.ProductHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.TEXT_EVENT_STREAM;

@Component
public class AppConfig {

    @Bean
    public RouterFunction<ServerResponse> routes(ProductHandler handler){
        return RouterFunctions.route()
                .path("/products",
                        builder -> builder
                                .nest(RequestPredicates.accept(APPLICATION_JSON)
                                                .or(RequestPredicates.contentType(APPLICATION_JSON))
                                                .or(RequestPredicates.accept(TEXT_EVENT_STREAM)),
                                        nestedBuilder -> nestedBuilder
                                                .GET("/events", handler::getProductEvents)
                                                .GET("/{id}", handler::getProduct)
                                                .GET(handler::getAllProducts)
                                                .PUT("/{id}", handler::updateProduct)
                                                .POST(handler::saveProduct)
                                )
                                .DELETE("/{id}", handler::deleteProduct)
                                .DELETE(handler::deleteAllProducts)
                ).build();
    }
}
