package com.silkmanuel.api_gateway_server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.HandlerFilterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class LogginFilter {
    @Bean
    public HandlerFilterFunction<ServerResponse, ServerResponse> loggingFilter() {

        return (request, next) -> {

            System.out.println(
                "REQUEST RECEIVED: "
                + request.method()
                + " "
                + request.uri()
            );

            ServerResponse response = next.handle(request);

            System.out.println(
                "RESPONSE STATUS: "
                + response.statusCode()
            );

            return response;
        };
    }
}
