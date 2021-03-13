package co.com.softka.softkau.nomemientasapp.domain.game;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.nomemientasapp.domain.game.events.GameCreated;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.GameId;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.PlayerId;
import co.com.softka.softkau.nomemientasapp.domain.round.values.identities.RoundId;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Game extends AggregateEvent<GameId> {

    protected Map<PlayerId, Player> players;
    protected RoundId roundId;
    protected Boolean startedGame;
    protected Boolean endGame;

    public Game(GameId entityId, Set<Player> players) {
        super(entityId);
        Map<PlayerId, Player> newPlayers = new HashMap<>();
        players.forEach(player -> newPlayers.put(player.identity(), player));
        appendChange(new GameCreated(newPlayers)).apply();
    }

    public static Game from(GameId entityId, List<DomainEvent> events) {
        var game = new Game(entityId);
        events.forEach(game::applyEvent);
        return game;
    }


    public Game(GameId entityId) {
        super(entityId);
        subscribe(new GameChange(this));
    }


}
