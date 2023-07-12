package br.ufrn.dimap.collaborativecanvas.reactivegameservice.controller;


import br.ufrn.dimap.collaborativecanvas.reactivegameservice.model.JogadaPlayerDTO;
import br.ufrn.dimap.collaborativecanvas.reactivegameservice.model.PaintingDTO;
import br.ufrn.dimap.collaborativecanvas.reactivegameservice.service.GameService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Controller
public class GameController {

    private final ObjectMapper objectMapper;

    private final GameService gameService;

    public GameController(@Autowired GameService gameService, ObjectMapper objectMapper){
        this.gameService = gameService;
        this.objectMapper = objectMapper;
    }

    @Bean
    public Function<String, String> play() {
        return message -> {
            System.out.println("Message received in game-service: " + message);
            PaintingDTO jogada;
            try {
                jogada = objectMapper.readValue(message, PaintingDTO.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

            return this.gameService.play(jogada).subscribe().toString();
        };
    }
}
