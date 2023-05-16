package br.ufrn.dimap.collaborativecanvas.reactivegameservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import br.ufrn.dimap.collaborativecanvas.reactivegameservice.model.JogadaCanvaDTO;
import br.ufrn.dimap.collaborativecanvas.reactivegameservice.model.JogadaPlayerDTO;
import br.ufrn.dimap.collaborativecanvas.reactivegameservice.model.PaintingDTO;
import br.ufrn.dimap.collaborativecanvas.reactivegameservice.model.Player;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.util.function.Tuple2;

@Service
public class GameService {

    @Autowired
	private WebClient webClient;
    @Autowired
    private WebClient webClient2;
    
    public Mono<Tuple2<PaintingDTO, Void>> play(PaintingDTO paint){
        
    	/*
        return this.webClient.post()
            .uri("http://localhost:8093/painting")
            .body(Mono.just(paint), PaintingDTO.class)
            .retrieve()
            .bodyToMono(PaintingDTO.class);
            	*/
    	Mono<PaintingDTO> responseCanva = jogarCanva(paint).subscribeOn(Schedulers.boundedElastic());
    	JogadaPlayerDTO jogada = new JogadaPlayerDTO(paint.getPlayerId());
    	Mono<Void> responsePlayer = jogarPlayer(jogada).subscribeOn(Schedulers.boundedElastic());
	
						
    	return Mono.zip(responseCanva, responsePlayer);
    }
    
    private Mono<Void> jogarPlayer(JogadaPlayerDTO paint) {
    	return this.webClient.post()
				.uri("http://localhost:8085/player/play")
				.body(Mono.just(paint), JogadaPlayerDTO.class)
				.retrieve()
				.bodyToMono(Void.class);
    }
    private Mono<PaintingDTO> jogarCanva(PaintingDTO paint){
    	return this.webClient.post()
                .uri("http://localhost:8093/painting")
                .body(Mono.just(paint), PaintingDTO.class)
                .retrieve()
                .bodyToMono(PaintingDTO.class);
    }
}