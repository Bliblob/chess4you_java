package server.Data.ChessBoard.Movements;

import lombok.var;
import server.Data.ChessBoard.Board.ChessBoard;
import server.Data.ChessBoard.Board.ChessEnum;
import server.Data.ChessBoard.Pieces.Piece;

import java.util.List;

public interface IKingMovement {
    static boolean IsSmallRochadePossible(ChessBoard chessBoard, Piece King, Piece Rock){
        List<Piece> pieceList = (List<Piece>) chessBoard.listPiece.elements();
        // check for King pos
        if(King.color == ChessEnum.Color.Black && Rock.color == ChessEnum.Color.Black) {
           // check if line only contains two pieces
            if(chessBoard.ChessBoard
                   .get(8).size() == 2) {
                if(KingNRockOnBoard(chessBoard, King, Rock)) {
                    //check if the pieces wasn't moved
                    var posKing = pieceList.get(pieceList.indexOf(King)).getPosition();
                    var posRock = pieceList.get(pieceList.indexOf(Rock)).getPosition();
                    if(King.getPosition().getPosX() == posKing.getPosX() &&
                            King.getPosition().getPosY() == posKing.getPosY() &&
                            Rock.getPosition().getPosX() == posRock.getPosX() &&
                            Rock.getPosition().getPosY() == posRock.getPosY()
                    ) {
                        return true;
                    }
               } else {
                    return false;
                }

           } else {
                return false;
            }

       } else if(King.color == ChessEnum.Color.White && Rock.color == ChessEnum.Color.White) {

            return true;
       }
        return false;
    }

    static boolean KingNRockOnBoard(ChessBoard chessBoard, Piece King, Piece Rock) {

        boolean boardContains = false;
        for (int i = 0; i < chessBoard.ChessBoard.get(8).size(); i++) {

            //check if the two pieces are a king and a rock
            if (chessBoard.ChessBoard
                    .get(8)
                    .get(i)
                    .getPiece()
                    .getName()
                    .equals(King.name)) {
                boardContains = boardContains ? true : false;
            } else if (chessBoard.ChessBoard
                    .get(8)
                    .get(i)
                    .getPiece()
                    .getName()
                    .equals(Rock.name)) {
                boardContains = boardContains ? false : true;
            }
        }
        if (!boardContains) {
            return true;
        }
        return false;
    }

    static boolean IsBigRochadePossible(){
        return true;
    }

    static Movement[] smallRochade(Position positionKing, Position positionRock) {
        return new Movement[]{
                new Movement(
                        new Position(
                                positionKing.getPosX() - 2,
                                positionKing.getPosY()),
                        positionKing, ChessEnum.Direction.FLDiagonal
                ),
                new Movement(
                        new Position(
                                positionRock.getPosX() + 3,
                                positionRock.getPosY()),
                        positionRock, ChessEnum.Direction.FLDiagonal
                )
        };
    }
    static Movement[] bigRochade(Position positionKing, Position positionRock) {
        return new Movement[]{
                new Movement(
                        new Position(
                                positionKing.getPosX() + 2,
                                positionKing.getPosY()),
                        positionKing, ChessEnum.Direction.FLDiagonal
                ),
                new Movement(
                        new Position(
                                positionRock.getPosX() - 2,
                                positionRock.getPosY()),
                        positionRock, ChessEnum.Direction.FLDiagonal
                )
        };
    }
}