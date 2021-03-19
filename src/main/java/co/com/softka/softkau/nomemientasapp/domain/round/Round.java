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
    protected Boolean started;
    protected  Map<DiceId,DiceFace> dicesList;


    private Round(RoundId entityId) {
        super(entityId);
        subscribe(new RoundChange(this));
    }

    public Round(RoundId entityId, GameId gameId, Set<PlayerId> playerIds) {
        super(entityId);
        appendChange(new RoundCreated(gameId,playerIds)).apply();
    }

    public static Round from(RoundId entityId, List<DomainEvent> events) {
        var round = new Round(entityId);
        events.forEach(round::applyEvent);
        return round;
    }

    public void createRound() {
        appendChange(new RoundCreated(gameId, playerIds)).apply();
    }


    public void createCeroStage() {
        List<DiceFace> diceFaces = new ArrayList<>();
        appendChange(new StageCreated(gameId, StageId.of(1), diceFaces)).apply();
    }

    public void startRound(){
        appendChange(new RoundStarted(entityId, playerIds)).apply();

    }
    public void addBetOnStage(PlayerId playerId, Integer numberDiceFace, Integer repetition,Integer toBetMount) {
        Riddle riddle = new Riddle(numberDiceFace,repetition);
        ToBet toBet = new ToBet(toBetMount);
        BetOnStage betOnStage = new BetOnStage(riddle,toBet);
        appendChange(new BetOnStageAdded(gameId, StageId.of(1), playerId,betOnStage)).apply();
    }



    public void throwDice() {
        var diceFaceList = this.dice;

        appendChange(new DicesThrew(gameId, Map.of(DiceId.of(1), new DiceFace(),
                DiceId.of(2), new DiceFace(),
                DiceId.of(3), new DiceFace(),
                DiceId.of(4), new DiceFace(),
                DiceId.of(5), new DiceFace(),
                DiceId.of(6), new DiceFace()))).apply();
    }

    public void showFace(Integer numberFaces){

        appendChange(new DiceFaceShowed(entityId,numberFaces,dicesList));
    }
}
