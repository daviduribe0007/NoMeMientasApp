package co.com.softka.softkau.nomemientasapp.usecase.round;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.softka.softkau.nomemientasapp.domain.game.events.GameStarted;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.PlayerId;
import co.com.softka.softkau.nomemientasapp.domain.round.events.RoundCreated;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

class CreateRoundUseCaseTest {
    @Test
    void crearRonda() {
        var event = new GameStarted(Set.of(PlayerId.of("xxx"), PlayerId.of("fff")));
        event.setAggregateRootId("222");
        var useCase = new CreateRoundUseCase();
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var rondaCreada = (RoundCreated) events.get(0);
        Assertions.assertEquals("222", rondaCreada.getJuegoId().value());
        Assertions.assertEquals(2, rondaCreada.playerIds().size());
    }

}