package co.com.softka.softkau.nomemientasapp.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.nomemientasapp.domain.game.command.StartGame;
import co.com.softka.softkau.nomemientasapp.domain.game.events.GameCreated;
import co.com.softka.softkau.nomemientasapp.domain.game.events.GameStarted;
import co.com.softka.softkau.nomemientasapp.domain.game.events.PlayerAdded;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.GameId;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.PlayerId;
import co.com.softka.softkau.nomemientasapp.domain.game.values.valuesObjects.Capital;
import co.com.softka.softkau.nomemientasapp.domain.game.values.valuesObjects.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class StartGameUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    void startGame(){
        var id = GameId.of("21");
        var command = new StartGame(id);
        var useCase = new StartGameUseCase();

        when(repository.getEventsBy(id.value())).thenReturn(eventStored(id));
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(id.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var gameStarted = (GameStarted)events.get(0);
       Assertions.assertEquals(2, gameStarted.getPlayersIds().size());

    }

    private List<DomainEvent> eventStored(GameId id) {
        return List.of(
                new GameCreated(id),
                new PlayerAdded(PlayerId.of("111"), new Name("Raul Alzate"), new Capital(500.0)),
                new PlayerAdded(PlayerId.of("222"), new Name("Andres"), new Capital(500.0))
        );
    }



}