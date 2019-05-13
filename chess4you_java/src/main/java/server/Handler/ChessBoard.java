package server.Handler;

import server.Data.Chess.Piece;

import java.util.List;
import java.util.UUID;

public class ChessBoard {

    public List<Line> Board;

    public List<Line> getBoard(){
        return Board;
    }

    private Piece getPieceOnBoard(UUID Uuid) {
        return null;
    }
    public boolean tryToSetPiece(Piece piece){
        return validatePosition(getPieceOnBoard(piece.Uuid), piece) ? setPiece(piece) : false;
    }

    private boolean setPiece(Piece iPiece){
        /*Piece piece = Board.stream()
                .filter(element -> element);*/
        if(null == null) {
            return true;
        }
        return false;
    }

    private boolean validatePosition(Piece oldPiece, Piece newPiece) {
        return false;
    }
}
