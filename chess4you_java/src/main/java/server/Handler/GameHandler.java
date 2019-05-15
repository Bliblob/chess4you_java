package server.Handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.Game.Game;
import server.Service.GameService;

import java.util.UUID;

@Service
public class GameHandler {

    private GameService gameService;

    @Autowired
    public GameHandler(GameService gameService) {
        this.gameService = gameService;
    }

    public Game getGame(String lobbyUuid) {
        return gameService.getGame(UUID.fromString(lobbyUuid));
    }
}
