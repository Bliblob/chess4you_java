package server.GameHandler;

public class Game {

    private GameData gameData;
    private GameHandler gameHandler;
    private boolean isRegistered = false;
    private boolean isNotCheckmated = true;
    private Player currentPlayer;
    private Turn turn;

    public void registerGame(GameData gameData, GameHandler gameHandler) {
        this.gameHandler = gameHandler;
        this.gameData = gameData;
        isRegistered = true;
        turn = new Turn();
    }

    public void initGame() {
        currentPlayer = gameData.PlayerOne;
        if(isRegistered) {
            while(isNotCheckmated){
                doTurn(currentPlayer);
                isNotCheckmated = false;
            }
        }
    }

    private void doTurn(Player player){
        showTurnOptions(player);
        currentPlayer = gameData.PlayerTwo == player ? gameData.PlayerOne : gameData.PlayerTwo;

    }
    private void showTurnOptions(Player player){
        gameHandler.notifyClient("Game Started");
    }
}
