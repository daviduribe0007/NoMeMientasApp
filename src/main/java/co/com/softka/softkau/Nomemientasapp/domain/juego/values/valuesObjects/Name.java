package co.com.softka.softkau.Nomemientasapp.domain.juego.values.valuesObjects;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Name implements ValueObject<String> {

    private final String value;

    public Name(String name) {
        this.value = Objects.requireNonNull(name);
        if (name.isBlank()) {
            throw new IllegalArgumentException("The name can´t be empty");
        }
    }

    @Override
    public String value() {
        return value;
    }
}
