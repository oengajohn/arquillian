package io.jotech.arquillian.repository;

import java.util.List;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.ArgumentUtils;

import static org.junit.jupiter.api.Assertions.*;
import io.jotech.arquillian.Calculator;
import io.jotech.arquillian.model.Game;
import io.jotech.arquillian.repository.impl.GameRepositoryImpl;
import io.jotech.arquillian.repository.impl.JpaRepositoryImpl;
import io.jotech.arquillian.util.ArquillianWarUtils;

@ExtendWith(ArquillianExtension.class)
class GameRepositoryTest {

    @Deployment
    public static Archive<?> createTestArchive() {
        var webArchive = ArquillianWarUtils.getBasicWebArchive()
                .addClasses(
                        Game.class,
                        JpaRepository.class,
                        JpaRepositoryImpl.class,
                        GameRepository.class,
                        GameRepositoryImpl.class
                );
        System.out.println(webArchive.toString(true));
        return webArchive;
    }

    @Inject
    GameRepository gameRepository;

    @Test
    void allGames() {
        var games = gameRepository.allGames();
        assertEquals(4, games.size());
    }

    @Test
    void save() {
        var gm1 = new Game("Football");
        var gm2 = new Game("Table Tennis");
        var gm3 = new Game("Rugby");
        var gm4 = new Game("Hand ball");
        var game1Saved = gameRepository.save(gm1);
        var game2Saved = gameRepository.save(gm2);
        var game3Saved = gameRepository.save(gm3);
        var game4Saved = gameRepository.save(gm4);
        assertAll("Insertion",
                () -> assertNotNull(game1Saved.getId()),
                () -> assertNotNull(game2Saved.getId()),
                () -> assertNotNull(game3Saved.getId()),
                () -> assertNotNull(game4Saved.getId())
        );


    }

    @Test
    void update() {
        //TODO: save an entity

        //TODO: update entity field

        // TODO: assert that the old entity that has been returned contains the updated changes

    }

    @Test
    void delete() {
        //TODO: save list of entities

        //TODO: assert that the list contains the saved entities count

        //TODO: delete an entity from the ones saved

        //TODO: assert that the list contains the saved entities count less one


    }


}