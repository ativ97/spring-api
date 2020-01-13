package com.example.consumer;

import com.example.consumer.controller.Controller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.ws.rs.core.Application;
import java.io.IOException;

@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerApplication {

	public static void main(String[] args) throws IOException {
		ApplicationContext ctx = SpringApplication.run(ConsumerApplication.class, args);

		Controller controller = ctx.getBean(Controller.class);
		controller.getAll();

	}

	@Bean
	public Controller controller(){
		return new Controller();
	}

}
