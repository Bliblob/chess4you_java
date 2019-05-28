package server.Handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import server.Service.GameDataService;

@Component
public class GameHandler {

    private GameDataService gameService;

    @Autowired
    public GameHandler(GameDataService gameService) {
        this.gameService = gameService;
    }





}
