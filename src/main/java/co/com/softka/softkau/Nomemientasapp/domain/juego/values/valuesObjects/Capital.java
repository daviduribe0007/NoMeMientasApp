package co.com.softka.softkau.Nomemientasapp.domain.juego.values.valuesObjects;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Capital implements ValueObject<Double> {

    private final Double value;

    public Capital(Double capital) {
        this.value = Objects.requireNonNull(capital);
        if (capital < 0) {
            throw new IllegalArgumentException("The capital can´t be negative capital");
        }
    }

    public Capital aumentCapital(Double value) {
        return new Capital(this.value + value);
    }

    public Capital subtractCapital(Double value) {
        if (value > this.value) {
            throw new IllegalArgumentException("The subtrac capital can´t excend your current capital ");
        } else {
            return new Capital(this.value - value);
        }
    }

    @Override
    public Double value() {
        return value;
    }

}
