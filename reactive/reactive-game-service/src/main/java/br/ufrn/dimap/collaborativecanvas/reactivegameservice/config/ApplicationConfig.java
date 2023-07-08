package br.ufrn.dimap.collaborativecanvas.reactivegameservice.config;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

@Configuration
public class ApplicationConfig {
	
	@Bean
    public WebClient.Builder webClient() {
        //return WebClient.create();
		String connectionProviderName = "myConnectionProvider";
        HttpClient httpClient = HttpClient.create(ConnectionProvider.builder(connectionProviderName)
                .maxConnections(10_000)
                .pendingAcquireMaxCount(10_000)
                .pendingAcquireTimeout(Duration.of(100, ChronoUnit.SECONDS))
                .build()
        );
        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient));
    
    }
}

