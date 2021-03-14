package co.com.softka.softkau.nomemientasapp.domain.game.command;

import co.com.sofka.domain.generic.Command;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.PlayerId;
import co.com.softka.softkau.nomemientasapp.domain.game.values.valuesObjects.Capital;
import co.com.softka.softkau.nomemientasapp.domain.game.values.valuesObjects.Name;

import java.util.Map;

public class CreateGame implements Command {
    private final Map<PlayerId, Capital> capitals;
    private final Map<PlayerId, Name> names;

    public CreateGame(Map<PlayerId, Capital> capitals, Map<PlayerId, Name> names) {

        this.capitals = capitals;
        this.names = names;
    }

    public Map<PlayerId, Capital> getCapitals() {
        return capitals;
    }

    public Map<PlayerId, Name> getNames() {
        return names;
    }
}
