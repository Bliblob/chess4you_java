package server.Data.ChessBoard.Pieces;

import lombok.Getter;
import server.Data.ChessBoard.Board.ChessEnum;

public class Pawn extends Piece {
    public Pawn(ChessEnum.Color color) {
        super(color);
        this.setDirections(new ChessEnum.DirectionType[]{
                ChessEnum.DirectionType.Pawn,
                ChessEnum.DirectionType.Linear,
        });
    }
}
