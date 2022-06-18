package com.game.service;

import com.game.controller.PlayerOrder;
import com.game.entity.Player;
import com.game.entity.Profession;
import com.game.entity.Race;
import com.game.repository.PlayerRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PlayerService {
    PlayerRepository repository;

    public PlayerService(PlayerRepository repository) {
        this.repository = repository;
    }

    public List<Player> getAll(
            PlayerOrder order,
            Integer pageNumber,
            Integer pageSize,
            String name,
            String title,
            Race race,
            Profession profession,
            Long after,
            Long before,
            Boolean banned,
            Integer minExperience,
            Integer maxExperience,
            Integer minLevel,
            Integer maxLevel
    ) {
        return repository.getPlayers(
                PageRequest.of(pageNumber, pageSize, Sort.by(order.getFieldName())),
                name,
                title,
                race,
                profession,
                after == null ? null : new Date(after),
                before == null ? null : new Date(before),
                banned,
                minExperience,
                maxExperience,
                minLevel,
                maxLevel
        );
    }
}
