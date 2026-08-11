// package com.silkmanuel.api_gateway_server;

// import io.micrometer.observation.ObservationRegistry;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.filter.ServerHttpObservationFilter;

// @Configuration(proxyBeanMethods = false)
// public class TracingConfig {

//     @Bean
//     public ServerHttpObservationFilter observationFilter(ObservationRegistry observationRegistry) {
//         return new ServerHttpObservationFilter(observationRegistry);
//     }
// }