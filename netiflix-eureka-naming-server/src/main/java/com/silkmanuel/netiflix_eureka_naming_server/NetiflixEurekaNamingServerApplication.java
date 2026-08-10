package com.silkmanuel.netiflix_eureka_naming_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableEurekaServer
public class NetiflixEurekaNamingServerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(NetiflixEurekaNamingServerApplication.class, args);
		Environment environment = context.getBean(Environment.class);
		System.out.println(
			"INIT EUREKA NAMING SERVER - PORT: "
			+ environment.getProperty("local.server.port")
		);
	}

}
