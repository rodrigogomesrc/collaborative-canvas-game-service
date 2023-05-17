package br.ufrn.dimap.collaborativecanvas.gameservice.gameservice;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.ufrn.dimap.collaborativecanvas.gameservice.models.JogadaCanvaDTO;
import br.ufrn.dimap.collaborativecanvas.gameservice.models.JogadaPlayerDTO;
import br.ufrn.dimap.collaborativecanvas.gameservice.models.PaintingDTO;

@Service
public class GameService {
    public PaintingDTO play(PaintingDTO paint){
        RestTemplate restTemplate = new RestTemplate();
        String jogadaPlayerURL = "http://localhost:8085/player/play";
        String joagadaCanvaURL = "http://localhost:8093/painting";
        HttpEntity<JogadaPlayerDTO> requestPlayer = new HttpEntity<>(new JogadaPlayerDTO(paint.getPlayerId()));
        HttpEntity<JogadaCanvaDTO> requestCanva= new HttpEntity<>(new JogadaCanvaDTO(paint.getPixelId(), paint.getPlayerId(), paint.getCanvasId(), paint.getcolor()));
        ResponseEntity<Void> responsePlayer = restTemplate.exchange(jogadaPlayerURL, HttpMethod.POST, requestPlayer, Void.class);
        ResponseEntity<Void> responseCanva = restTemplate.exchange(joagadaCanvaURL, HttpMethod.POST, requestCanva, Void.class);
        if( responsePlayer.getStatusCode().equals(HttpStatus.OK) && responseCanva.getStatusCode().equals(HttpStatus.OK)){
            return paint;
        }else {
            return null;
        }

    }
}
