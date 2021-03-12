package co.com.softka.softkau.Nomemientasapp.domain.juego.values.valuesObjects;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Capital implements ValueObject<Double> {

    private final Double value;

    public Capital(Double capital) {
        this.value = Objects.requireNonNull(capital);
        if (capital <= 0) {
            throw new IllegalArgumentException("The capital can´t be 0 or negative capital");
        }
    }

    public Double value() {
        return value;
    }
}
