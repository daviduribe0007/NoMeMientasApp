package co.com.softka.softkau.nomemientasapp.usecase.round;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.softka.softkau.nomemientasapp.domain.game.Player;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.PlayerId;
import co.com.softka.softkau.nomemientasapp.domain.round.Round;
import co.com.softka.softkau.nomemientasapp.domain.round.events.BetOnStageAdded;
import co.com.softka.softkau.nomemientasapp.domain.round.events.DicesThrowes;
import co.com.softka.softkau.nomemientasapp.domain.round.events.StageCreated;
import co.com.softka.softkau.nomemientasapp.domain.round.values.identities.RoundId;

public class AddBetOnStage extends UseCase<TriggeredEvent<StageCreated>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<StageCreated> input) {
        var event =input.getDomainEvent();
        var round = Round.from(RoundId.of(event.aggregateRootId()), retrieveEvents());



    }



}
