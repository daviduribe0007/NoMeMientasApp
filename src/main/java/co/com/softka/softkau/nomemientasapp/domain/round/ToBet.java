package co.com.softka.softkau.nomemientasapp.domain.round;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ToBet implements ValueObject<Integer> {
    private final Integer value;

    public ToBet(Integer value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Integer value() {
        return value;
    }
}
