package com.silkmanuel.currency_exchange_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class CurrencyExchangeServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
		Environment environment = context.getBean(Environment.class);
		System.out.println(
			"INIT CURRENCY EXCHANGE SERVICE - PORT: "
			+ environment.getProperty("local.server.port")
		);

	}

}
