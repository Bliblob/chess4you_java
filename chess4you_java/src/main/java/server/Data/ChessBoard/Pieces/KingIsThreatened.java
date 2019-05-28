package server.Data.ChessBoard.Pieces;

import server.Data.ChessBoard.Board.ChessEnum;

public class KingIsThreatened extends Piece{
    public KingIsThreatened(ChessEnum.Color color) {
        super(color);
        this.setDirections(new ChessEnum.DirectionType[]{
                ChessEnum.DirectionType.Rochade,
                ChessEnum.DirectionType.Linear,
                ChessEnum.DirectionType.Diagonal,
                ChessEnum.DirectionType.Pawn,
                ChessEnum.DirectionType.Knight,
                ChessEnum.DirectionType.Diagonal,
        });
    }
}
