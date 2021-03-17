package co.com.softka.softkau.nomemientasapp.domain.round;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.PlayerId;
import co.com.softka.softkau.nomemientasapp.domain.round.events.*;
import co.com.softka.softkau.nomemientasapp.domain.round.values.identities.RoundId;
import co.com.softka.softkau.nomemientasapp.domain.round.values.identities.DiceId;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.GameId;
import co.com.softka.softkau.nomemientasapp.domain.round.values.identities.StageId;
import co.com.softka.softkau.nomemientasapp.domain.round.values.valuesobjects.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class Round extends AggregateEvent<RoundId> {

    protected GameId gameId;
    protected Map<DiceId, Dice> dice;
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

    public void createFirstStage() {
        List<DiceFace> diceFaces = new ArrayList<>();
        appendChange(new StageCreated(gameId, StageId.of(1), diceFaces)).apply();
    }
    public void addBetOnStage(PlayerId playerId, Integer numberDiceFace, Integer repetition,Integer toBetMount) {
        Riddle riddle = new Riddle(numberDiceFace,repetition);
        ToBet toBet = new ToBet(toBetMount);
        BetOnStage betOnStage = new BetOnStage(riddle,toBet);
        appendChange(new BetOnStageAdded(gameId, StageId.of(1), playerId,betOnStage)).apply();
    }



    public void throwDice() {
        var diceFaceList = this.dice
                .values()
                .stream()
                .map(dice -> Map.of(dice.identity(), dice.getDiceFaces()))
                .collect(Collectors.toList());
        appendChange(new DicesThrowes(gameId, diceFaceList)).apply();
    }
}
