package co.com.softka.softkau.nomemientasapp.domain.game.command;

import co.com.sofka.domain.generic.Command;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.GameId;

public class StartGame implements Command {

    private final GameId gameId;

    public StartGame(GameId gameId) {
        this.gameId = gameId;
    }

    public GameId getGameId() {
        return gameId;
    }
}
