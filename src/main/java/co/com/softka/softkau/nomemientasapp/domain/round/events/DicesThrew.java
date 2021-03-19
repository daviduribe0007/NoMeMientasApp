package co.com.softka.softkau.nomemientasapp.domain.round.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.GameId;
import co.com.softka.softkau.nomemientasapp.domain.round.values.identities.DiceId;
import co.com.softka.softkau.nomemientasapp.domain.round.values.valuesobjects.DiceFace;

import java.util.List;
import java.util.Map;

public class DicesThrew extends DomainEvent {
    private final GameId gameId;
    private final Map<DiceId,DiceFace> dicesList;


    public DicesThrew(GameId gameId, Map<DiceId,DiceFace> dicesList) {
        super("Nomemientasapp.round.throwdices");
        this.gameId = gameId;
        this.dicesList = dicesList;
    }

    public GameId getGameId() {
        return gameId;
    }

    public Map<DiceId, DiceFace> getDicesList() {
        return dicesList;
    }
}
