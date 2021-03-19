package co.com.softka.softkau.nomemientasapp.domain.round.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.GameId;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.PlayerId;
import co.com.softka.softkau.nomemientasapp.domain.round.values.identities.RoundId;

import java.util.Set;
import java.util.UUID;

public class RoundStarted extends DomainEvent {
    private final RoundId roundId;
    private final Set<PlayerId> playerIds;

    public RoundStarted( RoundId roundId, Set<PlayerId> playerIds) {
        super("Nomemientasapp.round.roundstarted");
        this.roundId = roundId;
        this.playerIds = playerIds;
    }

    public RoundId getRoundId() {
        return roundId;
    }

    public Set<PlayerId> getPlayerIds() {
        return playerIds;
    }

}
