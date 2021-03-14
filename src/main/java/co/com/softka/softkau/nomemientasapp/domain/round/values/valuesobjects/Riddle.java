package co.com.softka.softkau.nomemientasapp.domain.round.values.valuesobjects;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Riddle implements ValueObject<Riddle.Value> {
    private final Integer number;
    private final Integer repetitions;

    public Riddle(Integer number, Integer repetitions) {

        this.number = Objects.requireNonNull(number);
        this.repetitions = Objects.requireNonNull(repetitions);

        validateNumber(number, 0, "The number only can be into 1 and 6");

        validateNumber(repetitions, 2, "The repetitions number only can be into 3 and 6");

    }

    private void validateNumber(Integer number, int i, String s) {
        if (i > number || 6 > number) {
            throw new IllegalArgumentException(s);
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
