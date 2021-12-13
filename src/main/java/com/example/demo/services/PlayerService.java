package com.example.demo.services;

import com.example.demo.collection.Player;
import com.example.demo.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Objects;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository repository;

    public Flux<Player> getPlayers(){
        return repository.findAll();
    }

    public Flux<Player> getPlayersByAge(){
        return getPlayers()
                .filter(player -> Objects.nonNull(player.getAge()))
                .filter(player -> player.getAge() >= 35);
    }

    public Flux<Player> getPlayerAndFilterByClub(String club){
        return getPlayers()
                .filter(player -> Objects.nonNull(player.getClub()))
                .filter(player -> player.getClub().equals(club));
    }

    public Flux<Player> getPlayerByNational(String national){
        return getPlayers()
                .filter(player -> Objects.nonNull(player.getNational()))
                .filter(player -> player.getNational().equals(national));
    }

}
