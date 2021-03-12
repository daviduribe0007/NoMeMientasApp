package co.com.softka.softkau.Nomemientasapp.domain.juego.values;

import co.com.sofka.domain.generic.Identity;

public class PlayerId extends Identity {

    private PlayerId(String uid) {
        super(uid);
    }

    public PlayerId() {
    }

    public static PlayerId of(String uid) {
        return new PlayerId(uid);
    }
}
