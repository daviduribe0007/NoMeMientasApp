package co.com.softka.softkau.nomemientasapp.domain.round.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.GameId;
import co.com.softka.softkau.nomemientasapp.domain.round.values.identities.DiceId;
import co.com.softka.softkau.nomemientasapp.domain.round.values.valuesobjects.DiceFace;

import java.util.List;
import java.util.Map;

public class DicesThrowes extends DomainEvent {
    private final GameId gameId;
    private final List<Map<DiceId, List<DiceFace>>> dicesList;


    public DicesThrowes(GameId gameId, List<Map<DiceId, List<DiceFace>>> dicesList) {
        super("Nomemientasapp.round.throwdices");
        this.gameId = gameId;
        this.dicesList = dicesList;
    }

    public List<Map<DiceId, List<DiceFace>>> diceFaceList() {
        return dicesList;
    }

    public GameId gameId() {
        return gameId;
    }
}
