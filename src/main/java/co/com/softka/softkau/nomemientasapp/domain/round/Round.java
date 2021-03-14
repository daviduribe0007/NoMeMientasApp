package co.com.softka.softkau.nomemientasapp.domain.round;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.softka.softkau.nomemientasapp.domain.round.values.identities.RoundId;
import co.com.softka.softkau.nomemientasapp.domain.round.values.identities.DiceId;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.GameId;
import co.com.softka.softkau.nomemientasapp.domain.round.values.identities.StageId;

import java.util.Map;


public class Round extends AggregateEvent<RoundId> {

    protected GameId gameId;
    protected Map<DiceId,Dice> dice;
    protected Map<StageId, Stage> stagues;
    protected Map<RoundId, PointRound> points;




    public Round(RoundId entityId) {
        super(entityId);
        subscribe(new RoundChange(this));
    }
}
