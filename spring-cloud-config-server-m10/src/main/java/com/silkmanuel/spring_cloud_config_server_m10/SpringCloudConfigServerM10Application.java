package com.silkmanuel.spring_cloud_config_server_m10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringCloudConfigServerM10Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigServerM10Application.class, args);
		System.out.println("INIT CONFIG SERVER");
	}
}
