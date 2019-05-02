package server.GameHandler;

import java.util.ArrayList;

public class GameHandler {

    private GameHandlerService gameHandlerService;
    private ArrayList<GameClient> gameClients = new ArrayList<>();

    public GameHandler(){
    }

    public void registerGame(){
        Game game = new Game();
        game.registerGame(new GameData(new Player("d"), new Player("a")), this);
        game.initGame();
    }

    public void notifyClient(String data) {

    }

    public void notifyServer(String result) {

    }

    public void registerGameClient(GameClient gameClient) {

        gameClients.add(gameClient);
    }

    public boolean checkIfPossibleOpponentExists(GameClient gameClient) {

        if(gameClients.size() >= 2) {
            return true;
        } else {
            return false;
        }
    }
}
