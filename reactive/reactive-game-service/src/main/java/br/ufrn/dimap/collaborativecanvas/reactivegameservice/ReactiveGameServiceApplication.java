package br.ufrn.dimap.collaborativecanvas.reactivegameservice;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableDiscoveryClient
@SpringBootApplication
@EnableWebFlux
public class ReactiveGameServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveGameServiceApplication.class, args);
	}

}
