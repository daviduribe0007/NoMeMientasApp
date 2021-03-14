package co.com.softka.softkau.nomemientasapp.domain.round.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.GameId;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.PlayerId;

import java.util.Set;

public class RoundCreated extends DomainEvent {
    private final Set<PlayerId> playerIds;
    private final GameId gameId;

    public RoundCreated(Set<PlayerId> playerIds, GameId gameId) {
        super("Nomemientasapp.round.create");
        this.playerIds = playerIds;
        this.gameId = gameId;
    }

    public Set<PlayerId> playerIds() {
        return playerIds;
    }

    public GameId getJuegoId() {
        return gameId;
    }
}
