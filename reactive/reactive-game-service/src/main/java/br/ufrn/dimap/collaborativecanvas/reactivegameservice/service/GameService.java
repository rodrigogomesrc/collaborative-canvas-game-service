package br.ufrn.dimap.collaborativecanvas.reactivegameservice.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import br.ufrn.dimap.collaborativecanvas.reactivegameservice.model.JogadaPlayerDTO;
import br.ufrn.dimap.collaborativecanvas.reactivegameservice.model.PaintingDTO;
import reactor.core.publisher.Mono;

@Service
public class GameService {

	@Autowired
	private StreamBridge streamBridge;

	public Mono<String> play(PaintingDTO paint){
		streamBridge.send("play", new JogadaPlayerDTO(paint.getPlayerId()));
		streamBridge.send("painting", paint);
		return Mono.just("ok");

	}
}