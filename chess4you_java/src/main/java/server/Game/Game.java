package server.Game;

import lombok.Getter;
import server.Data.ChessBoard.Board.ChessBoard;
import server.Data.Game.Player;
import server.Data.Lobby.Lobby;

import java.util.List;
import java.util.UUID;

@Getter
public class Game {

    private List<Turn> history;
    private UUID lobby;
    private Player turn;
    private ChessBoard board;
    private boolean isChanged;

    public Game(UUID lobby){
        board = new ChessBoard();
        isChanged = false;
        this.lobby = lobby;
    }
    public boolean doTurn(Turn turn) {

        return true;
    }
}
