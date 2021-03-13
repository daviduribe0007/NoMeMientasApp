package co.com.softka.softkau.nomemientasapp.domain.game.values.identities;

import co.com.sofka.domain.generic.Identity;

public class GameId extends Identity {
    private GameId(String uid) {
        super(uid);
    }

    public GameId() {
    }

    public static GameId of(String uid) {
        return new GameId(uid);
    }
}
