package co.com.softka.softkau.nomemientasapp.domain.round;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.PlayerId;
import co.com.softka.softkau.nomemientasapp.domain.round.events.RoundCreated;
import co.com.softka.softkau.nomemientasapp.domain.round.events.RoundStart;
import co.com.softka.softkau.nomemientasapp.domain.round.values.identities.RoundId;
import co.com.softka.softkau.nomemientasapp.domain.round.values.identities.DiceId;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.GameId;
import co.com.softka.softkau.nomemientasapp.domain.round.values.identities.StageId;
import co.com.softka.softkau.nomemientasapp.domain.round.values.valuesobjects.PointRound;

import java.util.List;
import java.util.Map;
import java.util.Set;


public class Round extends AggregateEvent<RoundId> {

    protected GameId gameId;
    protected Map<DiceId,Dice> dice;
    protected Map<StageId, Stage> stagues;
    protected Map<RoundId, PointRound> points;
    protected Set<PlayerId> playerIds;




    public Round(RoundId entityId) {
        super(entityId);
        subscribe(new RoundChange(this));
    }

    public Round(RoundId entityId, GameId gameId, Set<PlayerId> playerIds) {
        super(entityId);
        appendChange(new RoundCreated(playerIds, gameId)).apply();
    }

    public static Round from(RoundId entityId, List<DomainEvent> events) {
        var round = new Round(entityId);
        events.forEach(round::applyEvent);
        return round;
    }

    public void startRound() {
        appendChange(new RoundStart(gameId, playerIds)).apply();
    }
}
