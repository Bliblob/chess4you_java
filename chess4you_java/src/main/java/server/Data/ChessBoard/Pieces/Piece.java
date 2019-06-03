package server.Data.ChessBoard.Pieces;

import lombok.*;
import server.Data.ChessBoard.Board.ChessEnum;
import server.Data.ChessBoard.Movements.base.Position;

import java.util.UUID;
@Data
public abstract class Piece {
    @Setter(AccessLevel.NONE)
    private UUID Uuid = UUID.randomUUID();
    @Setter(AccessLevel.NONE)
    @NonNull private ChessEnum.Color color;
    private String name;
    private Position position;
    private ChessEnum.Piece type;
    private ChessEnum.DirectionType[] directions;
    public Piece(ChessEnum.Color color){
        name = this.getClass().getName() + color.toString();
        this.color = color;
    }
}

