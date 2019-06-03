package server.Data.ChessBoard.Pieces;

import server.Data.ChessBoard.Board.ChessEnum;

public class King extends Piece {
    public King(ChessEnum.Color color) {
        super(color);
        this.setDirections(new ChessEnum.DirectionType[]{
                ChessEnum.DirectionType.Rochade,
                ChessEnum.DirectionType.Linear,
                ChessEnum.DirectionType.Diagonal,
        });
        this.setType(ChessEnum.Piece.King);
    }
}
