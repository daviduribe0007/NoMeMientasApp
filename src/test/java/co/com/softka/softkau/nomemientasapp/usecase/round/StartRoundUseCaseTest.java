package co.com.softka.softkau.nomemientasapp.usecase.round;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.nomemientasapp.domain.game.events.GameStarted;
import co.com.softka.softkau.nomemientasapp.domain.game.events.PlayerAdded;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.GameId;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.PlayerId;
import co.com.softka.softkau.nomemientasapp.domain.game.values.valuesObjects.Capital;
import co.com.softka.softkau.nomemientasapp.domain.game.values.valuesObjects.Name;
import co.com.softka.softkau.nomemientasapp.domain.round.events.RoundCreated;
import co.com.softka.softkau.nomemientasapp.domain.round.events.RoundStarted;
import co.com.softka.softkau.nomemientasapp.domain.round.values.identities.RoundId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StartRoundUseCaseTest {

    @Test
    void startRound() {
        RoundId roundId = RoundId.of("aaaaa");
        GameId gameId = GameId.of("ffff");
        var event = new RoundCreated(gameId, Set.of(PlayerId.of("xxx"), PlayerId.of("hhh")));
        event.setAggregateRootId("222");
        var useCase = new StartRoundUseCase();
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var roundStarted = (RoundStarted) events.get(0);
        Assertions.assertEquals("222", roundStarted.getRoundId().value());
        Assertions.assertEquals(2, roundStarted.getPlayerIds().size());
    }
}