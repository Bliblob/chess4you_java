package server.Data.ChessBoard.Pieces;

import lombok.NonNull;
import server.Data.ChessBoard.Board.ChessEnum;

public class Rock extends Piece {
    public Rock(ChessEnum.@NonNull Color color) {
        super(color);
        this.setDirections(new ChessEnum.DirectionType[]{
                ChessEnum.DirectionType.Linear,
        });
        this.setType(ChessEnum.Piece.Rock);
    }
}
