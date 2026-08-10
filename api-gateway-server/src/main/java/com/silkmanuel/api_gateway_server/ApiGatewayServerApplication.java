package com.silkmanuel.api_gateway_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class ApiGatewayServerApplication {

	public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(
                        ApiGatewayServerApplication.class,
                        args
                );
        Environment environment =
                context.getBean(Environment.class);

        System.out.println(
                "INIT API GATEWAY SERVER - PORT: "
                        + environment.getProperty("local.server.port")
        );	
	}

}
