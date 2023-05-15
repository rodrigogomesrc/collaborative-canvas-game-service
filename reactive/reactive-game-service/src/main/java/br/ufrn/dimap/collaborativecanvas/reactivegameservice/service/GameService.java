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
import reactor.core.publisher.Mono;

@Service
public class GameService {

    @Autowired
	private WebClient webClient;
    
    public Mono<PaintingDTO> play(PaintingDTO paint){
        //RestTemplate restTemplate = new RestTemplate();
        //String jogadaPlayerURL = "http://localhost:8085/player/play";
        //String joagadaCanvaURL = "http://localhost:8093/painting";
        //HttpEntity<JogadaPlayerDTO> requestPlayer = new HttpEntity<>(new JogadaPlayerDTO(paint.getPlayerId()));
        //HttpEntity<JogadaCanvaDTO> requestCanva= new HttpEntity<>(new JogadaCanvaDTO(paint.getPixelId(), paint.getPlayerId(), paint.getCanvasId(), paint.getcolor()));
        //ResponseEntity<Void> responsePlayer = restTemplate.exchange(jogadaPlayerURL, HttpMethod.PUT, requestPlayer, Void.class);
        //ResponseEntity<Void> responseCanva = restTemplate.exchange(joagadaCanvaURL, HttpMethod.POST, requestCanva, Void.class);
        //if( responsePlayer.getStatusCode().equals(HttpStatus.OK) && responseCanva.getStatusCode().equals(HttpStatus.OK)){
        //if(responseCanva.getStatusCode().equals(HttpStatus.OK)){
        //    return paint;
        //}else {
        //    return null;
        //}
        return this.webClient.post()
            .uri("http://localhost:8093/painting")
            .body(Mono.just(paint), PaintingDTO.class)
            .retrieve()
            .bodyToMono(PaintingDTO.class);

    }
}