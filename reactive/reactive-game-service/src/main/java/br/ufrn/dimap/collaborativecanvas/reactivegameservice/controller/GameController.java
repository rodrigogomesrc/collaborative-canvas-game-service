package br.ufrn.dimap.collaborativecanvas.reactivegameservice.controller;


import br.ufrn.dimap.collaborativecanvas.reactivegameservice.model.JogadaPlayerDTO;
import br.ufrn.dimap.collaborativecanvas.reactivegameservice.model.PaintingDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import java.util.function.Function;

@Controller
public class GameController {

    private final StreamBridge streamBridge;
    private final ObjectMapper objectMapper;

    public GameController(@Autowired StreamBridge streamBridge, ObjectMapper objectMapper){
        this.streamBridge = streamBridge;
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

            streamBridge.send("player-play-in", new JogadaPlayerDTO(jogada.getPlayerId()));
            streamBridge.send("canvas-painting-in", jogada);
            return message;
        };
    }

}
