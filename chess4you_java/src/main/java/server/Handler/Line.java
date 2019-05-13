package server.Handler;

import server.Data.Chess.Piece;

import java.util.List;

public class Line {
    public List<Piece> getPieceList() {
        return pieceList;
    }

    public void setPieceList(List<Piece> pieceList) {
        this.pieceList = pieceList;
    }

    public List<Piece> pieceList;

}
