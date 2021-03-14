package co.com.softka.softkau.nomemientasapp.domain.game;

import co.com.sofka.domain.generic.EventChange;
import co.com.softka.softkau.nomemientasapp.domain.game.events.GameCreated;
import co.com.softka.softkau.nomemientasapp.domain.game.events.GameStarted;
import co.com.softka.softkau.nomemientasapp.domain.game.events.PlayerAdded;

import java.util.HashMap;

public class GameChange extends EventChange {

    public GameChange(Game game) {

        apply((GameCreated event) -> {
            game.players = new HashMap<>();
            game.endGame = Boolean.FALSE;
            game.startedGame = Boolean.FALSE;
        });

        apply((GameStarted event) -> {
            game.startedGame = Boolean.TRUE;
        });

        apply((PlayerAdded event) -> {
            if (game.startedGame.equals(Boolean.TRUE)) {
                throw new IllegalArgumentException("You can´t add players when the game start");
            }
            game.players.put(event.getPlayerId(),
                    new Player(
                            event.getPlayerId(),
                            event.getName(),
                            event.getCapital()
                    )
            );
        });

    }
}
