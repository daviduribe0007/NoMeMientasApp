package co.com.softka.softkau.nomemientasapp.usecase.game;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.softka.softkau.nomemientasapp.domain.game.command.CreateGame;
import co.com.softka.softkau.nomemientasapp.domain.game.events.GameCreated;
import co.com.softka.softkau.nomemientasapp.domain.game.events.PlayerAdded;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.PlayerId;
import co.com.softka.softkau.nomemientasapp.domain.game.values.valuesObjects.Capital;
import co.com.softka.softkau.nomemientasapp.domain.game.values.valuesObjects.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.Map;
import java.util.Objects;


class CreateGameUseCaseTest {


    @Test
    void crearUnJuego() {
        var names = Map.of(
                PlayerId.of("111"), new Name("Raul Alzate"),
                PlayerId.of("222"), new Name("Andres"),
                PlayerId.of("333"), new Name("camila"),
                PlayerId.of("666"), new Name("oscar"),
                PlayerId.of("777"), new Name("juan"),
                PlayerId.of("888"), new Name("camilo"),
                PlayerId.of("999"), new Name("pipe")
        );
        var capiltals = Map.of(
                PlayerId.of("111"), new Capital(500),
                PlayerId.of("222"), new Capital(500),
                PlayerId.of("333"), new Capital(500),
                PlayerId.of("666"), new Capital(500),
                PlayerId.of("777"), new Capital(500),
                PlayerId.of("888"), new Capital(500),
                PlayerId.of("999"), new Capital(500)
        );
        var command = new CreateGame(capiltals, names);
        var useCase = new CreateGameUseCase();

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var gameCreated = (GameCreated) events.get(0);
        var playerAddedToRaul = (PlayerAdded) events.get(7);
        var playerAddedToAndres = (PlayerAdded) events.get(1);
        var playerAddedToCamila = (PlayerAdded) events.get(2);
        var playerAddedToOscar = (PlayerAdded) events.get(3);
        var playerAddedToJuan = (PlayerAdded) events.get(4);
        var playerAddedToCamilo = (PlayerAdded) events.get(5);
        var playerAddedToPipe = (PlayerAdded) events.get(6);

        Assertions.assertTrue(Objects.nonNull(gameCreated.getGameId().value()));

        Assertions.assertEquals("Raul Alzate", playerAddedToRaul.getName().value());
        Assertions.assertEquals(500, playerAddedToRaul.getCapital().value());
        Assertions.assertEquals("111", playerAddedToRaul.getPlayerId().value());

        Assertions.assertEquals("Andres", playerAddedToAndres.getName().value());
        Assertions.assertEquals(500, playerAddedToAndres.getCapital().value());
        Assertions.assertEquals("222", playerAddedToAndres.getPlayerId().value());

        Assertions.assertEquals("camila", playerAddedToCamila.getName().value());
        Assertions.assertEquals(500, playerAddedToCamila.getCapital().value());
        Assertions.assertEquals("333", playerAddedToCamila.getPlayerId().value());

        Assertions.assertEquals("oscar", playerAddedToOscar.getName().value());
        Assertions.assertEquals(500, playerAddedToOscar.getCapital().value());
        Assertions.assertEquals("666", playerAddedToOscar.getPlayerId().value());

        Assertions.assertEquals("juan", playerAddedToJuan.getName().value());
        Assertions.assertEquals(500, playerAddedToJuan.getCapital().value());
        Assertions.assertEquals("777", playerAddedToJuan.getPlayerId().value());

        Assertions.assertEquals("camilo", playerAddedToCamilo.getName().value());
        Assertions.assertEquals(500, playerAddedToCamilo.getCapital().value());
        Assertions.assertEquals("888", playerAddedToCamilo.getPlayerId().value());

        Assertions.assertEquals("pipe", playerAddedToPipe.getName().value());
        Assertions.assertEquals(500, playerAddedToPipe.getCapital().value());
        Assertions.assertEquals("999", playerAddedToPipe.getPlayerId().value());
    }


    @Test
    void errorAlCrearJuego() {
        var name = Map.of(
                PlayerId.of("111"), new Name("Raul Alzate")
        );
        var capiltals = Map.of(
                PlayerId.of("111"), new Capital(500)
        );
        var command = new CreateGame(capiltals, name);
        var useCase = new CreateGameUseCase();


        Assertions.assertThrows(BusinessException.class, () -> {
            UseCaseHandler.getInstance()
                    .syncExecutor(useCase, new RequestCommand<>(command))
                    .orElseThrow();
        }, "The minimun number of players to start is two players and the maximum 24");

    }

}