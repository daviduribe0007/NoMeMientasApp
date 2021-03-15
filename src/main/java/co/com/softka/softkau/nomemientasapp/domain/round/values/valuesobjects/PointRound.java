package co.com.softka.softkau.nomemientasapp.domain.round.values.valuesobjects;

import co.com.sofka.domain.generic.ValueObject;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.PlayerId;

public class PointRound implements ValueObject<Integer> {
    private Integer value;
    private PlayerId playerId;

    public PointRound(PlayerId playerId) {
        this.value = 0;
        this.playerId = playerId;
    }

    public void aumentPoints(Integer value, PlayerId playerId) {
        validationValue(value);
        this.playerId = playerId;
        this.value += value;
    }

    private void validationValue(Integer value) {
        if (value == null) {
            throw new IllegalArgumentException("You can´t add null values");
        }
        if (0 > value) {
            throw new IllegalArgumentException("You can´t add negatives values");
        }
    }

    @Override
    public Integer value() {
        return value;
    }

}
