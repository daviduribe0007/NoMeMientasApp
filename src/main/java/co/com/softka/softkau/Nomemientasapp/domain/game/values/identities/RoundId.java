package co.com.softka.softkau.Nomemientasapp.domain.game.values.identities;

import co.com.sofka.domain.generic.Identity;

public class RoundId extends Identity {
    private RoundId(String uid) {
        super(uid);
    }

    public RoundId(){}

    public static RoundId of(String uid) {
        return new RoundId(uid);
    }
}
