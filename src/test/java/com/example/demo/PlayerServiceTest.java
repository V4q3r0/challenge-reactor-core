package com.example.demo;

import com.example.demo.services.PlayerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.test.StepVerifier;

public class PlayerServiceTest {

    @Autowired
    PlayerService service;

    @Test
    void totalPlayers(){
        var players = service.getPlayers();

        StepVerifier.create(players)
                .expectNextCount(18207)
                .verifyComplete();
    }
}
