package co.com.softka.softkau.Nomemientasapp.domain.game;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.softka.softkau.Nomemientasapp.domain.game.GameChange;
import co.com.softka.softkau.Nomemientasapp.domain.game.entities.Player;
import co.com.softka.softkau.Nomemientasapp.domain.game.events.GameCreated;
import co.com.softka.softkau.Nomemientasapp.domain.game.values.identities.GameId;
import co.com.softka.softkau.Nomemientasapp.domain.game.values.identities.PlayerId;
import co.com.softka.softkau.Nomemientasapp.domain.game.values.identities.RoundId;

import java.util.HashMap;
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


    public Game(GameId entityId) {
        super(entityId);
        subscribe(new GameChange(this));
    }
}
