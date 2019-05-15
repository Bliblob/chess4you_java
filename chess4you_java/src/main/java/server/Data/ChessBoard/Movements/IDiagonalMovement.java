package server.Data.ChessBoard.Movements;

import server.Data.ChessBoard.Board.ChessEnum;

public interface IDiagonalMovement {

    static public Movement FLD(Position position,int Numbers) {
        return new Movement(
                new Position(
                        position.getPosX() - Numbers,
                        position.getPosY() + Numbers),
                position, ChessEnum.Direction.FLDiagonal);

    }

    static public Movement FRD(Position position,int Numbers){
        return new Movement(
                new Position(
                        position.getPosX() + Numbers,
                        position.getPosY() + Numbers),
                position, ChessEnum.Direction.FLDiagonal);
    }

    static public Movement BLD(Position position,int Numbers){
        return new Movement(
                new Position(
                        position.getPosX() - Numbers,
                        position.getPosY() - Numbers),
                position, ChessEnum.Direction.FLDiagonal);
    }

    static public Movement BRD(Position position,int Numbers){
        return new Movement(
                new Position(
                        position.getPosX() + Numbers,
                        position.getPosY() - Numbers),
                position, ChessEnum.Direction.FLDiagonal);
    }
}
