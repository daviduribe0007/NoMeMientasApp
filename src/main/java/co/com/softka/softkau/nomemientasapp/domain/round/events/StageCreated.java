package co.com.softka.softkau.nomemientasapp.domain.round.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.GameId;
import co.com.softka.softkau.nomemientasapp.domain.round.values.identities.StageId;
import co.com.softka.softkau.nomemientasapp.domain.round.values.valuesobjects.DiceFace;

import java.util.List;

public class StageCreated extends DomainEvent {
    private final GameId gameId;
    private final StageId stageId;
    private final List<DiceFace> visiblesDiceFace;

    public StageCreated(GameId gameId, StageId stageId, List<DiceFace> diceFaces) {
        super("Nomemientasapp.round.stageCreated");
        this.gameId = gameId;
        this.stageId = stageId;
        this.visiblesDiceFace = diceFaces;
    }

    public GameId gameId() {
        return gameId;
    }

    public StageId stageId() {
        return stageId;
    }

    public List<DiceFace> visiblesDiceFace() {
        return visiblesDiceFace;
    }
}
