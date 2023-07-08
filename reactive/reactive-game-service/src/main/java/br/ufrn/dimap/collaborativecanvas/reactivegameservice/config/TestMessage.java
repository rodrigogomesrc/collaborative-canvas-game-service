package br.ufrn.dimap.collaborativecanvas.reactivegameservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
public class TestMessage implements ApplicationRunner {

    @Autowired
    private StreamBridge streamBridge;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Hello World from Application Runner");
        streamBridge.send("saida", "Hello World from Application Runner");
    }
}

