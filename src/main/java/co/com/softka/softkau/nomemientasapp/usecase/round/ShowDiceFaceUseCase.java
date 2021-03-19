package co.com.softka.softkau.nomemientasapp.usecase.round;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.softka.softkau.nomemientasapp.domain.round.Round;
import co.com.softka.softkau.nomemientasapp.domain.round.Stage;
import co.com.softka.softkau.nomemientasapp.domain.round.values.identities.RoundId;

import java.util.List;
//import co.com.softka.softkau.nomemientasapp.domain.round.events.DiceFaceShowed;
/*
public class ShowDiceFaceUseCase extends UseCase<TriggeredEvent<StageStarted>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<StageStarted> input) {
        var event = input.getDomainEvent();
        var round = Round.from(RoundId.of(event.aggregateRootId()), List.of(event) );
        var number = 6;
        try {
            round.showFace(number);
            emit().onResponse(new ResponseEvents(round.getUncommittedChanges()));
        } catch (RuntimeException e){
            emit().onError(new BusinessException(round.identity().value(), e.getMessage()));
        }
    }
}*/
