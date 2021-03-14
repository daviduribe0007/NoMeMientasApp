package co.com.softka.softkau.nomemientasapp.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.softka.softkau.nomemientasapp.domain.game.Game;
import co.com.softka.softkau.nomemientasapp.domain.game.command.CreateGame;
import co.com.softka.softkau.nomemientasapp.domain.game.factory.PlayerFactory;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.GameId;

public class CreateGameUseCase extends UseCase<RequestCommand<CreateGame>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateGame> input) {
        var command = input.getCommand();
        var gameId = new GameId();

        var factory = PlayerFactory.builder();
        command.getNames()
                .forEach((playerId, name) ->
                        factory.newPlayer(
                                playerId, name, command.getCapitals().get(playerId)
                        ));
        validateBusinessException(gameId, factory);

        var game = new Game(gameId, factory);

        emit().onResponse(new ResponseEvents(game.getUncommittedChanges()));
    }

    private void validateBusinessException(GameId gameId, PlayerFactory factory) {
        if (playersIntoValidRange(factory)) {
            throw new BusinessException(gameId.value(), "The minimun number of players to start is two players and the maximum 24");
        }
    }

    private boolean playersIntoValidRange(PlayerFactory factory) {
        return factory.players().size() < 2 && 24 > factory.players().size();
    }
}
