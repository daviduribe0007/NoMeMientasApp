package co.com.softka.softkau.nomemientasapp.usecase.round;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.softka.softkau.nomemientasapp.domain.round.Round;
import co.com.softka.softkau.nomemientasapp.domain.round.events.RoundStarted;
import co.com.softka.softkau.nomemientasapp.domain.round.values.identities.RoundId;

import java.util.List;

public class ThrowDiceUseCase extends UseCase<TriggeredEvent<RoundStarted>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<RoundStarted> input) {
        var event = input.getDomainEvent();
        var round = Round.from(RoundId.of(event.aggregateRootId()), List.of(event));
        round.throwDice();
        emit().onResponse(new ResponseEvents(round.getUncommittedChanges()));
    }
}
