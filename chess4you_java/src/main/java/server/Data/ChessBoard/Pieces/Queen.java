package server.Data.ChessBoard.Pieces;

import server.Data.ChessBoard.Board.ChessEnum;

public class Queen extends Piece {
    public Queen(ChessEnum.Color color) {
        super(color);
        this.setDirections(new ChessEnum.DirectionType[]{
                ChessEnum.DirectionType.Diagonal,
                ChessEnum.DirectionType.Linear,
        });
        this.setType(ChessEnum.Piece.Queen);
    }
}
