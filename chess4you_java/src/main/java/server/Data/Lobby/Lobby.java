package server.Data.Lobby;

import server.Data.Game.Player;

import java.util.UUID;

public class Lobby {
    private UUID Name;
    private boolean StartGame = false;
    private Player PlayerOne;
    private Player PlayerTwo;

    public Lobby(){
        Name = UUID.randomUUID();
    }

    public UUID getName() {
        return Name;
    }
    public Player getPlayerTwo() {
        return PlayerTwo;
    }
    public void setPlayerTwo(Player playerTwo) {
        PlayerTwo = playerTwo;
        StartGame = true;
    }
    public boolean getStartGame(){
        return StartGame;
    }
    public Player getPlayerOne() {
        return PlayerOne;
    }
    public void setPlayerOne(Player playerOne) {
        PlayerOne = playerOne;
    }
}
