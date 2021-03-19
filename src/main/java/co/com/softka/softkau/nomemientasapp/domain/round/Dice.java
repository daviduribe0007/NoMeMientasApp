package co.com.softka.softkau.nomemientasapp.domain.round;

import co.com.sofka.domain.generic.Entity;
import co.com.softka.softkau.nomemientasapp.domain.round.values.identities.DiceId;
import co.com.softka.softkau.nomemientasapp.domain.round.values.valuesobjects.DiceFace;

import java.util.ArrayList;
import java.util.List;

public class Dice extends Entity<DiceId> {
    private List<DiceFace> diceFaces;

    public Dice(DiceId entityId) {
        super(entityId);
        this.diceFaces = new ArrayList<>();
    }


    public List<DiceFace> getDiceFaces() {
        return diceFaces;
    }
}
