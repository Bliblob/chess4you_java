package server.Data.ChessBoard.Pieces;

import server.Data.ChessBoard.Board.ChessEnum;

public class Knight extends Piece {
    public Knight(ChessEnum.Color color) {
        super(color);
        this.setDirections(new ChessEnum.DirectionType[]{
                ChessEnum.DirectionType.Knight
        });
        this.setType(ChessEnum.Piece.Knight);
    }
}
