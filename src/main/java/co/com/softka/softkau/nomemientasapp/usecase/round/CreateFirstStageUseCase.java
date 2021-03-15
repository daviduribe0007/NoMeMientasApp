package co.com.softka.softkau.nomemientasapp.usecase.round;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.softka.softkau.nomemientasapp.domain.round.Round;
import co.com.softka.softkau.nomemientasapp.domain.round.events.DicesThrowes;
import co.com.softka.softkau.nomemientasapp.domain.round.values.identities.RoundId;

public class CreateFirstStageUseCase extends UseCase<TriggeredEvent<DicesThrowes>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<DicesThrowes> input) {
        var event = input.getDomainEvent();
        var ronda = Round.from(RoundId.of(event.aggregateRootId()), retrieveEvents());
        ronda.createFirstStage();
        emit().onResponse(new ResponseEvents(ronda.getUncommittedChanges()));
    }
}
