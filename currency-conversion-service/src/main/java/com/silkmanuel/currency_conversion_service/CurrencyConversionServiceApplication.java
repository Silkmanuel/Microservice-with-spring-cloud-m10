package com.silkmanuel.currency_conversion_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableFeignClients
public class CurrencyConversionServiceApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context =
                SpringApplication.run(
                        CurrencyConversionServiceApplication.class,
                        args
                );

        Environment environment =
                context.getBean(Environment.class);

        System.out.println(
                "INIT CURRENCY CONVERSION SERVICE - PORT: "
                        + environment.getProperty("local.server.port")
        );
    }
}