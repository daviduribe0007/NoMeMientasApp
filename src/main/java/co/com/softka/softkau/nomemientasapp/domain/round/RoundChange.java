package co.com.softka.softkau.nomemientasapp.domain.round;

import co.com.sofka.domain.generic.EventChange;
import co.com.softka.softkau.nomemientasapp.domain.round.events.DicesThrowes;

public class RoundChange extends EventChange {
    public RoundChange(Round round) {

        apply((DicesThrowes event) -> {
            round.dice.values().forEach(Dice::throwDice);
        });
    }
}
