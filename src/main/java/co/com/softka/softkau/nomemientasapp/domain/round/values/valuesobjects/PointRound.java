package co.com.softka.softkau.nomemientasapp.domain.round.values.valuesobjects;

import co.com.sofka.domain.generic.ValueObject;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.PlayerId;
import co.com.softka.softkau.nomemientasapp.domain.round.values.identities.RoundId;

public class PointRound implements ValueObject<Integer> {
    private Integer value;
    private PlayerId playerId;

    public PointRound(Integer value, PlayerId playerId) {
        this.value = 0;
        this.playerId = playerId;
    }

    public void aumentPoints(Integer value, PlayerId playerId) {
        if (value.equals(null)) {
            throw new IllegalArgumentException("You can´t add null values");
        }
        if (0 > value) {
            throw new IllegalArgumentException("You can´t add negatives values");
        }
        this.playerId = playerId;
        this.value += value;
    }

    @Override
    public Integer value() {
        return value;
    }

}
