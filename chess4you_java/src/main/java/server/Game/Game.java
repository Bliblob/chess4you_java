package server.Game;

import lombok.Data;
import server.Data.ChessBoard.Board.ChessBoard;
import server.Data.ChessBoard.Movements.base.Movement;
import server.Data.Game.Player;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class Game {
    private List<Turn> history;
    private UUID lobby;
    private Player currentPlayer;
    private ChessBoard board;
    private Date lastChange;
    private List<Movement> kingIsThreatenedResult;
}
