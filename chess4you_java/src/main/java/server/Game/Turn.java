package server.Game;

import lombok.AllArgsConstructor;
import lombok.Data;
import server.Data.ChessBoard.Movements.Position;
import server.Data.ChessBoard.Pieces.Piece;
import server.Data.Game.Player;

@Data
@AllArgsConstructor
public class Turn {
    public Player player;
    public Piece piece;
    public Position position;
}
