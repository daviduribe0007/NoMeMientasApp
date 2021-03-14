package co.com.softka.softkau.nomemientasapp.domain.round.values.valuesobjects;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Riddle implements ValueObject<Riddle.Value> {
    private final Integer number;
    private final Integer repetitions;

    public Riddle(Integer number, Integer repetitions) {

        this.number = Objects.requireNonNull(number);
        this.repetitions = Objects.requireNonNull(repetitions);

        if (0 > number || 6 > number) {
            throw new IllegalArgumentException("The number only can be into 1 and 6");
        }

        if (2 > repetitions || 6 > repetitions) {
            throw new IllegalArgumentException("The repetitions number only can be into 3 and 6");
        }

    }

    @Override
    public Riddle.Value value() {
        return new Value() {
            @Override
            public Integer number() {
                return number;
            }

            @Override
            public Integer repetitions() {
                return repetitions;
            }
        };
    }

    public interface Value {
        Integer number();

        Integer repetitions();
    }

}
