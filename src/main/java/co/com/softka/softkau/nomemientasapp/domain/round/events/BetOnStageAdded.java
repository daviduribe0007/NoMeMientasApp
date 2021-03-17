package co.com.softka.softkau.nomemientasapp.domain.round.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.GameId;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.PlayerId;
import co.com.softka.softkau.nomemientasapp.domain.round.values.identities.StageId;
import co.com.softka.softkau.nomemientasapp.domain.round.values.valuesobjects.BetOnStage;

import java.util.UUID;


public class BetOnStageAdded extends DomainEvent {
    private final GameId gameId;
    private final StageId stageId;
    private final PlayerId playerId;
    private final BetOnStage betOnStage;


    public BetOnStageAdded(GameId gameId, StageId stageId, PlayerId playerId, BetOnStage betOnStage) {
        super("Nomemientasapp.round.betonstage");
        this.gameId = gameId;
        this.stageId = stageId;
        this.playerId = playerId;
        this.betOnStage = betOnStage;
    }

    public GameId getGameId() {
        return gameId;
    }

    public StageId getStageId() {
        return stageId;
    }

    public PlayerId getPlayerId() {
        return playerId;
    }

    public BetOnStage getBetOnStage() {
        return betOnStage;
    }
}
