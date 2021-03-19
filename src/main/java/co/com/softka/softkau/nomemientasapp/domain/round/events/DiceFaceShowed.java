package co.com.softka.softkau.nomemientasapp.domain.round.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.nomemientasapp.domain.round.values.identities.DiceId;
import co.com.softka.softkau.nomemientasapp.domain.round.values.identities.RoundId;
import co.com.softka.softkau.nomemientasapp.domain.round.values.valuesobjects.DiceFace;

import java.util.List;
import java.util.Map;

public class DiceFaceShowed extends DomainEvent {
    private final RoundId roundId;
    private final Integer numberShowFaces;
    private final Map<DiceId,DiceFace> dicesList;


    public DiceFaceShowed(RoundId roundId, Integer numberShowFaces, Map<DiceId,DiceFace> dicesList) {
        super("Nomemientasapp.round.showface");
        this.roundId = roundId;
        this.numberShowFaces = numberShowFaces;
        this.dicesList = dicesList;
    }

    public RoundId getRoundId() {
        return roundId;
    }

    public Integer getNumberShowFaces() {
        return numberShowFaces;
    }

    public Map<DiceId,DiceFace> getDicesList() {
        return dicesList;
    }
}
