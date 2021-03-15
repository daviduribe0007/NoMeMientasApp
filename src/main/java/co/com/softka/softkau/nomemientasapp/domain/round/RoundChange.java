package co.com.softka.softkau.nomemientasapp.domain.round;

import co.com.sofka.domain.generic.EventChange;
import co.com.softka.softkau.nomemientasapp.domain.round.events.DicesThrowes;
import co.com.softka.softkau.nomemientasapp.domain.round.events.RoundCreated;
import co.com.softka.softkau.nomemientasapp.domain.round.events.StageCreated;
import co.com.softka.softkau.nomemientasapp.domain.round.values.identities.DiceId;

import java.util.HashMap;

public class RoundChange extends EventChange {
    public RoundChange(Round round) {
        apply((RoundCreated event) -> {
            round.gameId = event.getJuegoId();
            round.dice = new HashMap<>();
            round.stagues = new HashMap<>();
            round.points = new HashMap<>();
            round.playerIds = event.playerIds();
            for (var i = 1; i <= 6; i++) {//inicializar dados
                round.dice.put(DiceId.of(i), new Dice(DiceId.of(i)));
            }
        });

        apply((DicesThrowes event) -> {
            round.dice.values().forEach(Dice::throwDice);
        });

        apply((StageCreated event) -> {
            round.stagues.put(event.stageId(),
                    new Stage(event.stageId(), event.visiblesDiceFace())
            );
        });
    }
}
