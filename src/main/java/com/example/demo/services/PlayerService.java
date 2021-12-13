package com.example.demo.services;

import com.example.demo.Player;
import com.example.demo.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository repository;

    public Flux<Player> getPlayers(){
        return repository.findAll();
    }

    public Flux<Player> getPlayersByAge(){
        return getPlayers().filter(player -> player.age >= 35);
    }

    public Flux<Player> getPlayerAndFilterByClub(String club){
        return getPlayers().filter(player -> player.club.equals(club));
    }

    public Flux<Player> getPlayerByNational(String national){
        return getPlayers().filter(player -> player.national.equals(national));
    }

}
