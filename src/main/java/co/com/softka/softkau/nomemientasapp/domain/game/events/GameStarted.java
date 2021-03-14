package co.com.softka.softkau.nomemientasapp.domain.game.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.PlayerId;

import java.util.Set;

public class GameStarted extends DomainEvent {
   private final Set<PlayerId> playersIds;
    public GameStarted(Set<PlayerId> playersIds1) {
        super("Nomemientasapp.game.inicialiced");
        this.playersIds = playersIds1;

    }

    public Set<PlayerId> getPlayersIds() {
        return playersIds;
    }
}
