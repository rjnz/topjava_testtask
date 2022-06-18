package com.game.controller;

import com.game.service.PlayerService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {
    PlayerService service;

    public PlayerController(PlayerService service) {
        this.service = service;
    }
}
