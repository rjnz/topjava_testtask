package com.game.controller;

import com.game.entity.Player;
import com.game.entity.Profession;
import com.game.entity.Race;
import com.game.service.PlayerService;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/rest")
public class PlayerController {
    PlayerService service;

    public PlayerController(PlayerService service) {
        this.service = service;
    }

    @GetMapping(value = "/players")
    public List<Player> getAll(
            @RequestParam(defaultValue = "ID") PlayerOrder order,
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "3") Integer pageSize,
            @RequestParam @Nullable String name,
            @RequestParam @Nullable String title,
            @RequestParam @Nullable Race race,
            @RequestParam @Nullable Profession profession,
            @RequestParam @Nullable Long after,
            @RequestParam @Nullable Long before,
            @RequestParam @Nullable Boolean banned,
            @RequestParam @Nullable Integer minExperience,
            @RequestParam @Nullable Integer maxExperience,
            @RequestParam @Nullable Integer minLevel,
            @RequestParam @Nullable Integer maxLevel
    ) {
        return service.getAll(
                order,
                pageNumber,
                pageSize,
                name,
                title,
                race,
                profession,
                after,
                before,
                banned,
                minExperience,
                maxExperience,
                minLevel,
                maxLevel
        );
    }

    @GetMapping(value = "/players/count")
    public Integer count(
            @RequestParam @Nullable String name,
            @RequestParam @Nullable String title,
            @RequestParam @Nullable Race race,
            @RequestParam @Nullable Profession profession,
            @RequestParam @Nullable Long after,
            @RequestParam @Nullable Long before,
            @RequestParam @Nullable Boolean banned,
            @RequestParam @Nullable Integer minExperience,
            @RequestParam @Nullable Integer maxExperience,
            @RequestParam @Nullable Integer minLevel,
            @RequestParam @Nullable Integer maxLevel
    ) {
        return service.count(
                name,
                title,
                race,
                profession,
                after,
                before,
                banned,
                minExperience,
                maxExperience,
                minLevel,
                maxLevel
        );
    }
}
