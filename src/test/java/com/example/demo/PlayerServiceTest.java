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

    @Test
    void filter_PlayersByAge(){
        var players = service.getPlayersByAge();

        StepVerifier.create(players)
                .expectNextMatches(player -> player.age >= 35)
                .verifyComplete();
    }

    @Test
    void filter_PlayerByClub(){
        var playersByClub = service.getPlayerAndFilterByClub("FC Barcelona");

        StepVerifier.create(playersByClub)
                .expectNextMatches(player -> player.club.equals("FC Barcelona"))
                .verifyComplete();
    }

    @Test
    void filter_PlayerByNational(){
        var playersByNational = service.getPlayerByNational("Argentina");

        StepVerifier.create(playersByNational)
                .expectNextMatches(player -> player.national.equals("Argentina"))
                .verifyComplete();
    }
}
