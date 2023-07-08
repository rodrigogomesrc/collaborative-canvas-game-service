package br.ufrn.dimap.collaborativecanvas.reactivegameservice.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.ufrn.dimap.collaborativecanvas.reactivegameservice.model.JogadaPlayerDTO;
import br.ufrn.dimap.collaborativecanvas.reactivegameservice.model.PaintingDTO;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;
import reactor.util.function.Tuple2;

@Service
public class GameService {

    @Autowired
	private WebClient.Builder webClient;
    @Autowired
    private WebClient.Builder webClient2;
    
    private final ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
    private final Scheduler virtualScheduler = Schedulers.fromExecutorService(executorService);
    
    public Mono<Tuple2<PaintingDTO, Void>> play(PaintingDTO paint){
    	
    
       // return Mono.fromCallable(() -> {
        	Mono<Void> responsePlayer = this.webClient.build().post()
    				.uri("http://PLAYER-SERVICE/player/play")
    				.body(Mono.just(new JogadaPlayerDTO(paint.getPlayerId())), JogadaPlayerDTO.class)
    				.retrieve()
    				.bodyToMono(Void.class).subscribeOn(virtualScheduler);
        	
        	Mono<PaintingDTO> responseCanva = this.webClient2.build().post()
                    .uri("http://CANVAS-SERVICE/painting")
                    .body(Mono.just(paint), PaintingDTO.class)
                    .retrieve()
                    .bodyToMono(PaintingDTO.class).subscribeOn(virtualScheduler);
        	
        	return Mono.zip(responseCanva, responsePlayer);
        	
        }
    /*
    	
      
            	
    	Mono<PaintingDTO> responseCanva = jogarCanva(paint).subscribeOn(virtualScheduler);
    	JogadaPlayerDTO jogada = new JogadaPlayerDTO(paint.getPlayerId());
    	Mono<Void> responsePlayer = jogarPlayer(jogada).subscribeOn(virtualScheduler);
	

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
    	return this.webClient2.post()
                .uri("http://localhost:8093/painting")
                .body(Mono.just(paint), PaintingDTO.class)
                .retrieve()
                .bodyToMono(PaintingDTO.class);
            */    
    
    
}