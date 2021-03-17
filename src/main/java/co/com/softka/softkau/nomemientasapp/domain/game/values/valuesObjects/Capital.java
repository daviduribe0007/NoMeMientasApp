package co.com.softka.softkau.nomemientasapp.domain.game.values.valuesObjects;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Capital implements ValueObject<Integer> {
    private final Integer value;

    public Capital(Integer capital) {
        this.value = Objects.requireNonNull(capital);
        if (capital < 0) {
            throw new IllegalArgumentException("The capital can´t be negative capital");
        }
    }

    public Capital aumentCapital(Integer value) {
        return new Capital(this.value + value);
    }

    public Capital subtractCapital(Integer value) {
        if (value > this.value) {
            throw new IllegalArgumentException("The subtrac capital can´t excend your current capital ");
        }
        return new Capital(this.value - value);

    }

    @Override
    public Integer value() {
        return value;
    }

}
