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
    private final RoundId roundId = RoundId.of("aaaaa");

    @Mock
    private DomainEventRepository repository;

    @Test
    void ThrowDiceOnRound() {
        var roundId = RoundId.of("aaaaa");
        var event = new RoundStarted(roundId, Set.of(PlayerId.of("xxx"), PlayerId.of("hhh")));
        event.setAggregateRootId("zzz");

        var useCase = new ThrowDiceUseCase();

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var threwDice = (DicesThrew) events.get(0);

        Assertions.assertEquals(6, threwDice.getDicesList().size());
        threwDice.getDicesList().forEach((diceId, diceFace) ->
                Assertions.assertTrue(() -> diceFace.value() > 0 && 6 >= diceFace.value(), "The dice face only can contain numbers into 1 or 6"));


    }
}