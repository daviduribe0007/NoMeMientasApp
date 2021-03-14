package co.com.softka.softkau.nomemientasapp.domain.round;

import co.com.sofka.domain.generic.Entity;
import co.com.softka.softkau.nomemientasapp.domain.round.values.identities.DiceId;
import co.com.softka.softkau.nomemientasapp.domain.round.values.valuesobjects.DiceFace;

import java.util.List;

public class Dice extends Entity<DiceId> {
    private List<DiceFace> diceFaces;
    public Dice(DiceId entityId) {
        super(entityId);
    }

    public void throwDice(){
        for (int i = 0;i <6;i++ ) {
            diceFaces.add(new DiceFace((int)Math.ceil(Math.random()*6)));
        }
    }

}
