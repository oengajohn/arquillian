package io.jotech.arquillian.repository.impl;

import java.util.List;

import io.jotech.arquillian.model.Game;
import io.jotech.arquillian.repository.GameRepository;

public class GameRepositoryImpl extends JpaRepositoryImpl<Game, Long> implements GameRepository {

    public GameRepositoryImpl() {
        super(Game.class);
    }

    @Override
    public List<Game> allGames() {
        return em.createQuery("select g from Game g ",Game.class).getResultList();
    }
}
