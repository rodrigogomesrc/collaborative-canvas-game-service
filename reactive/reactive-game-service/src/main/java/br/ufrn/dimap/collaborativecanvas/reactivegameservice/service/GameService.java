package br.ufrn.dimap.collaborativecanvas.reactivegameservice.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.ufrn.dimap.collaborativecanvas.reactivegameservice.model.JogadaPlayerDTO;
import br.ufrn.dimap.collaborativecanvas.reactivegameservice.model.PaintingDTO;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;
import reactor.util.function.Tuple2;

@Service
public class GameService {
	
    @Autowired
	private WebClient.Builder webClient;
   
    
    private final ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
    private final Scheduler virtualScheduler = Schedulers.fromExecutorService(executorService);
    
    @RateLimiter(name = "playerRateLimiter")
    @Retry(name="playerRetry")
    @Bulkhead(name="playerBulkhead", type = Bulkhead.Type.THREADPOOL)
    @CircuitBreaker(name="player-service")
    private Mono<Void> playerPlay(PaintingDTO paint){
        return this.webClient.build().post()
    				.uri("http://PLAYER-SERVICE/player/play")
    				.body(Mono.just(new JogadaPlayerDTO(paint.getPlayerId())), JogadaPlayerDTO.class)
    				.retrieve()
    				.bodyToMono(Void.class).subscribeOn(virtualScheduler);
    }
    @RateLimiter(name = "canvaRateLimiter")
    @Retry(name="canvaRetry")
    @Bulkhead(name="canvaBulkhead", type = Bulkhead.Type.THREADPOOL)
    @CircuitBreaker(name="canva-service")
    private Mono<PaintingDTO> canvaPlay(PaintingDTO paint){
        return this.webClient.build().post()
                    .uri("http://CANVAS-SERVICE/painting")
                    .body(Mono.just(paint), PaintingDTO.class)
                    .retrieve()
                    .bodyToMono(PaintingDTO.class).subscribeOn(virtualScheduler);
        	
    }
    
    public Mono<Tuple2<PaintingDTO, Void>> play(PaintingDTO paint){
    	
        Mono<PaintingDTO> responseCanva = canvaPlay(paint);
        Mono<Void> responsePlayer = playerPlay(paint);
        
        return Mono.zip(responseCanva, responsePlayer);	
        }
    
}