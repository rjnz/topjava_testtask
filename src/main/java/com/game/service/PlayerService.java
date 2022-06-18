package com.game.service;

import com.game.repository.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    PlayerRepository repository;

    public PlayerService(PlayerRepository repository) {
        this.repository = repository;
    }
}
