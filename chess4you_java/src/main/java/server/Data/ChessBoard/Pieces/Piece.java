package server.Data.ChessBoard.Pieces;

import lombok.Data;
import server.Data.ChessBoard.Board.ChessEnum;
import server.Data.ChessBoard.Movements.Position;

import java.util.UUID;
@Data
public abstract class Piece {
    public UUID Uuid;
    public String name;
    public Position position;
    public ChessEnum.Color color;
    public ChessEnum.Piece type;

    public Piece(ChessEnum.Color color){
        this.color = color;
        name = this.getClass().getName() + color.name();
        Uuid = UUID.randomUUID();
    }
}

