package co.com.softka.softkau.Nomemientasapp.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.softka.softkau.Nomemientasapp.domain.game.command.CreateGame;
import co.com.softka.softkau.Nomemientasapp.domain.game.entities.Player;
import co.com.softka.softkau.Nomemientasapp.domain.game.events.GameCreated;
import co.com.softka.softkau.Nomemientasapp.domain.game.values.identities.PlayerId;
import co.com.softka.softkau.Nomemientasapp.domain.game.values.valuesObjects.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

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

}