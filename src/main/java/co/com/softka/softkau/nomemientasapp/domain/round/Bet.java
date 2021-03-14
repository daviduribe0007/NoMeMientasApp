package co.com.softka.softkau.nomemientasapp.domain.round;


import co.com.sofka.domain.generic.ValueObject;
import co.com.softka.softkau.nomemientasapp.domain.round.values.valuesobjects.Riddle;

import java.util.Objects;

public class Bet implements ValueObject<Bet.Values> {
    private final Riddle riddle;
    private final ToBet toBet;

    public Bet(Riddle riddle, ToBet toBet) {
        this.riddle = Objects.requireNonNull(riddle);
        this.toBet = Objects.requireNonNull(toBet);
    }

    @Override
    public Values value() {
        return new Values() {
            @Override
            public Riddle riddle() {
                return riddle;
            }

            @Override
            public ToBet toBet() {
                return toBet;
            }
        };
    }

    public interface Values {
        Riddle riddle();
        ToBet toBet();
    }

}
