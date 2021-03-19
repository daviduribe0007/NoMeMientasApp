package co.com.softka.softkau.nomemientasapp.domain.round.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.GameId;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.PlayerId;

import java.util.Set;

public class RoundCreated extends DomainEvent {
        private final GameId gameId;
    private final Set<PlayerId> playerIds;

    public RoundCreated( GameId gameId, Set<PlayerId> playerIds) {
        super("Nomemientasapp.round.create");
        this.gameId = gameId;
        this.playerIds = playerIds;
    }

    public Set<PlayerId> playerIds() {
        return playerIds;
    }

    public GameId getJuegoId() {
        return gameId;
    }
}
