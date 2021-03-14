package co.com.softka.softkau.nomemientasapp.domain.game.factory;

import co.com.softka.softkau.nomemientasapp.domain.game.Player;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.PlayerId;
import co.com.softka.softkau.nomemientasapp.domain.game.values.valuesObjects.Capital;
import co.com.softka.softkau.nomemientasapp.domain.game.values.valuesObjects.Name;

import java.util.HashSet;
import java.util.Set;

public class PlayerFactory {
    private final Set<Player> players;

    private PlayerFactory() {
        players = new HashSet<>();
    }

    public static PlayerFactory builder() {
        return new PlayerFactory();
    }

    public PlayerFactory newPlayer(PlayerId playerId, Name name, Capital capital) {
        players.add(new Player(playerId, name, capital));
        return this;
    }

    public Set<Player> players() {
        return players;
    }
}
