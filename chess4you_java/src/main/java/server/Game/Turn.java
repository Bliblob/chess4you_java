package server.Game;

import lombok.AllArgsConstructor;
import lombok.Data;
import server.Data.ChessBoard.Movements.base.Position;
import server.Data.ChessBoard.Pieces.Piece;
import server.Data.Game.Player;

@Data
@AllArgsConstructor
public class Turn {
    private Player player;
    private Piece piece;
    private Position position;
}
