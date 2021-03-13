package co.com.softka.softkau.nomemientasapp.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.softka.softkau.nomemientasapp.domain.game.command.CreateGame;
import co.com.softka.softkau.nomemientasapp.domain.game.Player;
import co.com.softka.softkau.nomemientasapp.domain.game.events.GameCreated;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.PlayerId;
import co.com.softka.softkau.nomemientasapp.domain.game.values.valuesObjects.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.Set;


class CreateGameUseCaseTest {

    @Test
    void CrateGame(){
        var command = new CreateGame(Set.of(
                new Player(PlayerId.of("1234"), new Name("camila")),
                new Player(PlayerId.of("666"), new Name("raul")),
                new Player(PlayerId.of("777"), new Name("juan")),
                new Player(PlayerId.of("888"), new Name("camilo")),
                new Player(PlayerId.of("999"), new Name("pipe"))
        ));
        var createGameUseCase = new CreateGameUseCase();
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(createGameUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var juegoCreado = (GameCreated)events.get(0);

        Assertions.assertEquals(5, juegoCreado.getPlayers().size());
        Assertions.assertEquals("camila", juegoCreado.getPlayers().get(PlayerId.of("1234")).name().value());
        Assertions.assertEquals("raul", juegoCreado.getPlayers().get(PlayerId.of("666")).name().value());
        Assertions.assertEquals("juan", juegoCreado.getPlayers().get(PlayerId.of("777")).name().value());
        Assertions.assertEquals("camilo", juegoCreado.getPlayers().get(PlayerId.of("888")).name().value());
        Assertions.assertEquals("pipe", juegoCreado.getPlayers().get(PlayerId.of("999")).name().value());
    }


    @Test
    void errorCreateGame(){
        var command = new CreateGame(Set.of(
                new Player(PlayerId.of("1234"), new Name("camila"))
        ));
        var createGameUseCase = new CreateGameUseCase();

        Assertions.assertThrows(BusinessException.class, () -> {
            UseCaseHandler.getInstance()
                    .syncExecutor(createGameUseCase, new RequestCommand<>(command))
                    .orElseThrow();
        },"The minimun number of players to start is two players and the maximum 24");
    }

}