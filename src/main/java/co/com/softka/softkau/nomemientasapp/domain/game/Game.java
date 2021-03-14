package co.com.softka.softkau.nomemientasapp.domain.game;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.nomemientasapp.domain.game.events.GameCreated;
import co.com.softka.softkau.nomemientasapp.domain.game.events.GameStarted;
import co.com.softka.softkau.nomemientasapp.domain.game.events.PlayerAdded;
import co.com.softka.softkau.nomemientasapp.domain.game.factory.PlayerFactory;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.GameId;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.PlayerId;
import co.com.softka.softkau.nomemientasapp.domain.game.values.valuesObjects.Capital;
import co.com.softka.softkau.nomemientasapp.domain.game.values.valuesObjects.Name;
import co.com.softka.softkau.nomemientasapp.domain.round.values.identities.RoundId;

import java.util.List;
import java.util.Map;

public class Game extends AggregateEvent<GameId> {

    protected Map<PlayerId, Player> players;
    protected RoundId roundId;
    protected Boolean startedGame;
    protected Boolean endGame;

    public Game(GameId entityId, PlayerFactory playerFactory) {
        super(entityId);
        appendChange(new GameCreated(entityId)).apply();
        playerFactory.players()
                .forEach(player -> addPlayer(player.identity(), player.name(), player.capital()));
    }

    public static Game from(GameId entityId, List<DomainEvent> events) {
        var game = new Game(entityId);
        events.forEach(game::applyEvent);
        return game;
    }

    public void addPlayer(PlayerId playerId, Name name, Capital capital) {
        appendChange(new PlayerAdded(playerId, name, capital)).apply();
    }

    public Game(GameId entityId) {
        super(entityId);
        subscribe(new GameChange(this));
    }

    public void startGame() {
        var playersIds = players.keySet();
        appendChange(new GameStarted(playersIds)).apply();
    }

    public Boolean isStartedGame() {
        return startedGame;
    }

    public Map<PlayerId, Player> players() {
        return players;
    }

    public RoundId roundId() {
        return roundId;
    }

    public Boolean endGame() {
        return endGame;
    }
}
