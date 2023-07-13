package br.ufrn.dimap.collaborativecanvas.reactivegameservice.controller;

import br.ufrn.dimap.collaborativecanvas.reactivegameservice.model.PaintingDTO;
import br.ufrn.dimap.collaborativecanvas.reactivegameservice.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import java.util.function.Function;

@Controller
public class GameController {

    private final GameService gameService;

    public GameController(@Autowired GameService gameService){
        this.gameService = gameService;
    }

    @Bean
    public Function<PaintingDTO, String> play() {
        return message -> {
            //System.out.println("Message received in game-service: " + message);
            return this.gameService.play(message).subscribe().toString();
        };
    }
}
