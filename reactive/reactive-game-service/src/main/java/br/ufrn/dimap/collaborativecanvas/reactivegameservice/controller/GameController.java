package br.ufrn.dimap.collaborativecanvas.reactivegameservice.controller;

import br.ufrn.dimap.collaborativecanvas.reactivegameservice.model.PaintingDTO;
import br.ufrn.dimap.collaborativecanvas.reactivegameservice.service.GameService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

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
    public Function<PaintingDTO, String> play() {
        return message -> {
            System.out.println("Message received in game-service: " + message);
            return this.gameService.play(message).subscribe().toString();
        };
    }
}
