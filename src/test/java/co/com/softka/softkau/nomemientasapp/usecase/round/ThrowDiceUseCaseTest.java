package co.com.softka.softkau.nomemientasapp.usecase.round;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.GameId;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.PlayerId;
import co.com.softka.softkau.nomemientasapp.domain.round.events.DicesThrowes;
import co.com.softka.softkau.nomemientasapp.domain.round.events.RoundCreated;
import co.com.softka.softkau.nomemientasapp.domain.round.events.RoundStart;
import co.com.softka.softkau.nomemientasapp.domain.round.values.identities.RoundId;
import co.com.softka.softkau.nomemientasapp.domain.round.values.valuesobjects.DiceFace;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;


import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ThrowDiceUseCaseTest {


    private final Set<PlayerId> playerIds = Set.of(
            PlayerId.of("gggg"), PlayerId.of("ttttt")
    );
    private final GameId gameId = GameId.of("ffff");

    @Mock
    private DomainEventRepository repository;

    @Test
    void ThrowDiceOnRound() {
        var roundId = RoundId.of("aaaaa");
        var event = createTriggeredEventWith(roundId);
        var useCase = new ThrowDiceUseCase();
        when(repository.getEventsBy(roundId.value())).thenReturn(eventStored());
        useCase.addRepository(repository);
        var events = executor(roundId, event, useCase);
        var dicesThrowes = (DicesThrowes) events.get(0);

        Assertions.assertEquals(gameId, dicesThrowes.gameId());
        Assertions.assertEquals(6, dicesThrowes.diceFaceList().size());
        dicesThrowes.diceFaceList().forEach(dadoIdListMap -> {
            List<DiceFace> list = ((List<DiceFace>) dadoIdListMap.values().toArray()[0]);
            Assertions.assertEquals(6, list.size(), "Don´t Have the 6 dice face");
            for (DiceFace diceFace : list) {
                Assertions.assertTrue(() -> diceFace.value() > 0 && 6 >= diceFace.value(), "The dice face only can contain numbers into 1 or 6");
            }
        });
    }

    private RoundStart createTriggeredEventWith(RoundId rondaId) {
        var event = new RoundStart(gameId, playerIds);
        event.setAggregateRootId(rondaId.value());
        return event;
    }

    private List<DomainEvent> executor(RoundId roundId, RoundStart event, ThrowDiceUseCase useCase) {
        return UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(roundId.toString())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();
    }

    private List<DomainEvent> eventStored() {
        return List.of(
                new RoundCreated(playerIds, gameId),
                new RoundStart(gameId, playerIds)
        );
    }
}