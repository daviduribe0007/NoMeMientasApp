package co.com.softka.softkau.nomemientasapp.domain.game;

import co.com.sofka.domain.generic.EventChange;
import co.com.softka.softkau.nomemientasapp.domain.game.events.GameCreated;

public class GameChange extends EventChange {

    public GameChange(Game game) {

        apply((GameCreated event) -> {
            game.players = event.getPlayers();
            game.endGame = Boolean.FALSE;
            game.startedGame = Boolean.FALSE;
        });
    }
}
