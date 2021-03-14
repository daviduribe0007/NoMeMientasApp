package co.com.softka.softkau.nomemientasapp.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.softka.softkau.nomemientasapp.domain.round.Round;
import co.com.softka.softkau.nomemientasapp.domain.round.events.RoundStart;
import co.com.softka.softkau.nomemientasapp.domain.round.values.identities.RoundId;

public class ThrowDiceUseCase extends UseCase<TriggeredEvent<RoundStart>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<RoundStart> input) {

        var event = input.getDomainEvent();
        var round = Round.from(RoundId.of(event.aggregateRootId()), retrieveEvents());

        round.throwDice();

        emit().onResponse(new ResponseEvents(round.getUncommittedChanges()));
    }
}
