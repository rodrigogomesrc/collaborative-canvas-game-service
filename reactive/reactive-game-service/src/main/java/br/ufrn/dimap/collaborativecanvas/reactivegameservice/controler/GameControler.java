package br.ufrn.dimap.collaborativecanvas.reactivegameservice.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufrn.dimap.collaborativecanvas.reactivegameservice.model.PaintingDTO;
import br.ufrn.dimap.collaborativecanvas.reactivegameservice.service.GameService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/play")
public class GameControler {

    @Autowired
    public GameService gameService;

    @PostMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<PaintingDTO> play(@RequestBody PaintingDTO paint) {
        if (paint.getCanvasId() == null || paint.getPixelId() == null || paint.getPlayerId() == null || paint.getcolor() == null) {
            return Mono.empty();
        } else {
            return gameService.play(paint);
        }
        
    }

    
}
