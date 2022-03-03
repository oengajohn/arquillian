package io.jotech.arquillian.repository;

import java.util.List;

import io.jotech.arquillian.model.Game;

public interface GameRepository extends JpaRepository<Game,Long>{
    List<Game> allGames();
}
