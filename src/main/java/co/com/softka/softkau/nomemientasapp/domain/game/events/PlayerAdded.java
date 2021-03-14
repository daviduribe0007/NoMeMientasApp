package co.com.softka.softkau.nomemientasapp.domain.game.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.PlayerId;
import co.com.softka.softkau.nomemientasapp.domain.game.values.valuesObjects.Capital;
import co.com.softka.softkau.nomemientasapp.domain.game.values.valuesObjects.Name;

public class PlayerAdded extends DomainEvent {
    private final PlayerId playerId;
    private final Name name;
    private final Capital capital;

    public PlayerAdded(PlayerId playerId, Name name, Capital capital) {
        super("Nomemientasapp.game.playeradded");
        this.playerId = playerId;
        this.name = name;
        this.capital = capital;
    }

    public PlayerId getPlayerId() {
        return playerId;
    }

    public Capital getCapital() {
        return capital;
    }

    public Name getName() {
        return name;
    }
}
