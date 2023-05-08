package br.ufrn.dimap.collaborativecanvas.gameservice.controlers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.ufrn.dimap.collaborativecanvas.gameservice.models.JogadaPlayerDTO;
import br.ufrn.dimap.collaborativecanvas.gameservice.models.PaintingDTO;


@RestController
@RequestMapping("/play")
public class GameControler {

    @PostMapping
    public ResponseEntity<PaintingDTO> getPlayerById(@RequestBody PaintingDTO paint) {
        
        RestTemplate restTemplate = new RestTemplate();
        String jogadaURL = "http://localhost:8085/player/play";
        HttpEntity<JogadaPlayerDTO> request = new HttpEntity<>(new JogadaPlayerDTO(paint.getPlayerId()));
        ResponseEntity<Void> response = restTemplate.exchange(jogadaURL, HttpMethod.PUT, request, Void.class);
        return ResponseEntity.ok(paint);
    }

    
}
