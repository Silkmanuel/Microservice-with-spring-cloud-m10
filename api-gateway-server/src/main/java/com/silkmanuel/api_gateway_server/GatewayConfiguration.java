package com.silkmanuel.api_gateway_server;

import static org.springframework.cloud.gateway.server.mvc.filter.LoadBalancerFilterFunctions.lb;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.HandlerFilterFunction;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;


@Configuration
public class GatewayConfiguration {

    @Bean
    public RouterFunction<ServerResponse> currencyExchangeRoute(
            HandlerFilterFunction<ServerResponse, ServerResponse> loggingFilter) {

        return GatewayRouterFunctions.route("currency-exchange")
                .route(
                    request -> request.path()
                        .startsWith("/currency-exchange/"),
                    HandlerFunctions.http()
                )
                .filter(lb("currency-exchange-service"))
                .filter(loggingFilter)
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> currencyConversionRoute(
            HandlerFilterFunction<ServerResponse, ServerResponse> loggingFilter) {

        return GatewayRouterFunctions.route("currency-conversion")
                .route(
                    request -> request.path()
                        .startsWith("/currency-converter/"),
                    HandlerFunctions.http()
                )
                .filter(lb("currency-conversion-service"))
                .filter(loggingFilter)
                .build();
    }
}
