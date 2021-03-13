package co.com.softka.softkau.nomemientasapp.domain.game.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.nomemientasapp.domain.game.Player;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.PlayerId;

import java.util.Map;

public class GameCreated extends DomainEvent {
    private final Map<PlayerId, Player> players;

    public GameCreated(Map<PlayerId, Player> players) {
        super("Nomemientasapp.game.created");
        this.players = players;
    }

    public Map<PlayerId, Player> getPlayers() {
        return players;
    }
}
