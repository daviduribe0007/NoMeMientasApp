package co.com.softka.softkau.nomemientasapp.usecase.round;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.GameId;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.PlayerId;
import co.com.softka.softkau.nomemientasapp.domain.round.events.DicesThrew;
import co.com.softka.softkau.nomemientasapp.domain.round.events.RoundCreated;
import co.com.softka.softkau.nomemientasapp.domain.round.events.RoundStarted;
import co.com.softka.softkau.nomemientasapp.domain.round.events.StageCreated;
import co.com.softka.softkau.nomemientasapp.domain.round.values.identities.DiceId;
import co.com.softka.softkau.nomemientasapp.domain.round.values.identities.RoundId;
import co.com.softka.softkau.nomemientasapp.domain.round.values.valuesobjects.DiceFace;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;


import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateCeroStageUseCaseTest {

    private final Set<PlayerId> playerIds = Set.of(
            PlayerId.of("gggg"), PlayerId.of("ttttt")
    );
    private final GameId gameId = GameId.of("ffff");
    private final RoundId roundId = RoundId.of("aaaaa");


    @Mock
    private DomainEventRepository repository;

    @Test
    void createFirstStage() {


        var roundId = RoundId.of("aaaaa");
        var event = createTriggeredEventWith(roundId);
        var useCase = new CreateCeroStageUseCase();
        when(repository.getEventsBy(roundId.value())).thenReturn(eventStored());
        useCase.addRepository(repository);

        var events = executor(roundId, event, useCase);
        var stageCreate = (StageCreated) events.get(0);

        Assertions.assertEquals(gameId, stageCreate.gameId());
        Assertions.assertEquals(0, stageCreate.visiblesDiceFace().size());
        Assertions.assertTrue(Objects.nonNull(stageCreate.stageId()));
    }


    private DicesThrew createTriggeredEventWith(RoundId roundId) {

        Map<DiceId,DiceFace> listDiceFace= (Map.of(
                DiceId.of(1), new DiceFace(),
                DiceId.of(2), new DiceFace(),
                DiceId.of(3), new DiceFace(),
                DiceId.of(4), new DiceFace(),
                DiceId.of(5), new DiceFace(),
                DiceId.of(6), new DiceFace()
        ));
        var event = new DicesThrew(gameId, listDiceFace);
        event.setAggregateRootId(roundId.value());
        return event;
    }

    private List<DiceFace> generateDiceFace() {
        List<DiceFace> diceFacesList = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            diceFacesList.add(new DiceFace());
        }
        return diceFacesList;
    }

    private List<DomainEvent> executor(RoundId rondaId, DicesThrew event, CreateCeroStageUseCase useCase) {
        return UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(rondaId.toString())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();
    }

    private List<DomainEvent> eventStored() {
        return List.of(
                new RoundCreated(gameId,playerIds),
                new RoundStarted(roundId, playerIds)
        );
    }

}