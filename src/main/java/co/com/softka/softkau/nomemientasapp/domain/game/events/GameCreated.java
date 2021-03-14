package co.com.softka.softkau.nomemientasapp.domain.game.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.GameId;


public class GameCreated extends DomainEvent {
    private final GameId gameId;
    public GameCreated(GameId gameId) {
        super("Nomemientasapp.game.created");
        this.gameId = gameId;
    }

    public GameId getGameId() {
        return gameId;
    }
}
