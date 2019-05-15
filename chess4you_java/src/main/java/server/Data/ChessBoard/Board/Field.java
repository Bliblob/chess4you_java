package server.Data.ChessBoard.Board;

import lombok.Data;
import server.Data.ChessBoard.Pieces.Piece;

@Data
public class Field {
    public Piece piece;
    public Boolean isActive;

    public Field() {

    }

    public Field(Piece piece) {
        this.piece = piece;
    }
}
