package co.com.softka.softkau.nomemientasapp.domain.round.values.valuesobjects;


import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class BetOnStage implements ValueObject<BetOnStage.Values> {
    private final Riddle riddle;
    private final ToBet toBet;

    public BetOnStage(Riddle riddle, ToBet toBet) {
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
