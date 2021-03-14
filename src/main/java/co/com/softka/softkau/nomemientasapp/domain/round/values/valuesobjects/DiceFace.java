package co.com.softka.softkau.nomemientasapp.domain.round.values.valuesobjects;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DiceFace implements ValueObject<Integer> {
    private final Integer value;

    public DiceFace(Integer value) {
        this.value = Objects.requireNonNull(value,"The value of the dice face are requeried");
        if(value < 0 || 6> value){
         throw new IllegalArgumentException("The dice face only can contain numbers into 1 or 6");
        }
    }

    @Override
    public Integer value() {
        return value;
    }
}
