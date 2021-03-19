package co.com.softka.softkau.nomemientasapp.usecase.round;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.softka.softkau.nomemientasapp.domain.game.events.GameStarted;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.GameId;
import co.com.softka.softkau.nomemientasapp.domain.round.Round;
import co.com.softka.softkau.nomemientasapp.domain.round.values.identities.RoundId;

public class CreateRoundUseCase extends UseCase<TriggeredEvent<GameStarted>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<GameStarted> input) {
        var event = input.getDomainEvent();
        var roundId = new RoundId();
        if (event.getPlayersIds().size() < 2) {
            throw new BusinessException(roundId.value(), "The round can't create for lack of players");
        }
        var gameId = GameId.of(event.aggregateRootId());
        var round = new Round(roundId, gameId, event.getPlayersIds());
        round.createRound();
        emit().onResponse(new ResponseEvents(round.getUncommittedChanges()));
    }
}
