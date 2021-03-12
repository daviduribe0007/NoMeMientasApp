package co.com.softka.softkau.Nomemientasapp.domain.game.command;

import co.com.sofka.domain.generic.Command;
import co.com.softka.softkau.Nomemientasapp.domain.game.entities.Player;

import java.util.Set;

public class CreateGame implements Command {
    private final Set<Player> players;

    public CreateGame(Set<Player> players) {
        this.players = players;
    }

    public Set<Player> getPlayers() {
        return players;
    }
}
