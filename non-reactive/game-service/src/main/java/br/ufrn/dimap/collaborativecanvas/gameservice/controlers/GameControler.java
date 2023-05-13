package br.ufrn.dimap.collaborativecanvas.gameservice.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.ufrn.dimap.collaborativecanvas.gameservice.gameservice.GameService;
import br.ufrn.dimap.collaborativecanvas.gameservice.models.PaintingDTO;


@RestController
@RequestMapping("/play")
public class GameControler {

    @Autowired
    public GameService gameService;

    @PostMapping
    public ResponseEntity<PaintingDTO> play(@RequestBody PaintingDTO paint) {
        PaintingDTO jogada = gameService.play(paint);
        if (jogada != null) {
            return ResponseEntity.ok(paint);
        } else {
            return ResponseEntity.internalServerError().build();
        }
        
    }

    
}
