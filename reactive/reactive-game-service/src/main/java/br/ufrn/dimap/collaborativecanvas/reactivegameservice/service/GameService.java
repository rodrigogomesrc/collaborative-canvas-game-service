package br.ufrn.dimap.collaborativecanvas.reactivegameservice.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import br.ufrn.dimap.collaborativecanvas.reactivegameservice.model.JogadaPlayerDTO;
import br.ufrn.dimap.collaborativecanvas.reactivegameservice.model.PaintingDTO;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@Service
public class GameService {


	@Autowired
	private StreamBridge streamBridge;

    private final ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
    private final Scheduler virtualScheduler = Schedulers.fromExecutorService(executorService);

	public Mono<String> play(PaintingDTO paint){
		streamBridge.send("play", new JogadaPlayerDTO(paint.getPlayerId()));
		streamBridge.send("painting", paint);
		return Mono.just("ok");

	}
}