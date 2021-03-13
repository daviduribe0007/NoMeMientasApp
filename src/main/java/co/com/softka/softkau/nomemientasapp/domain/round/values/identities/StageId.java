package co.com.softka.softkau.nomemientasapp.domain.round.values.identities;

import co.com.sofka.domain.generic.Identity;

public class StageId extends Identity {
    private StageId(String uid) {
        super(uid);
    }

    public StageId() {
    }

    public static StageId of(String uid) {
        return new StageId(uid);
    }
}
