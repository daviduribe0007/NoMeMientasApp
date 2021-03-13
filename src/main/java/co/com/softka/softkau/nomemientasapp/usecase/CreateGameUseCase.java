package co.com.softka.softkau.nomemientasapp.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.softka.softkau.nomemientasapp.domain.game.Game;
import co.com.softka.softkau.nomemientasapp.domain.game.command.CreateGame;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.GameId;

public class CreateGameUseCase extends UseCase<RequestCommand<CreateGame>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateGame> input) {

        var command = input.getCommand();
        var gameId = new GameId();

        if (validateNumbersOfPlayers(command)) {
            throw new BusinessException(gameId.value(), "The minimun number of players to start is two players and the maximum 24");
        }

        var game = new Game(new GameId(), command.getPlayers());
        emit().onResponse(new ResponseEvents(game.getUncommittedChanges()));
    }

    private boolean validateNumbersOfPlayers(CreateGame command) {
        return command.getPlayers().size() < 3 || command.getPlayers().size() > 25;
    }
}
