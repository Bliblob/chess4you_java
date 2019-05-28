package server.Data.ChessBoard.Movements;

import server.Data.ChessBoard.Board.ChessEnum;
import server.Data.ChessBoard.Movements.base.Movement;
import server.Data.ChessBoard.Movements.base.Position;

public class DiagonalMovement {

    public Movement FLD(Position position, int Numbers) {
        return new Movement(
                new Position(
                        position.getPosX() - Numbers,
                        position.getPosY() + Numbers),
                position, ChessEnum.Direction.FLDiagonal);

    }

    public Movement FRD(Position position,int Numbers){
        return new Movement(
                new Position(
                        position.getPosX() + Numbers,
                        position.getPosY() + Numbers),
                position, ChessEnum.Direction.FRDiagonal);
    }

    public Movement BLD(Position position,int Numbers){
        return new Movement(
                new Position(
                        position.getPosX() - Numbers,
                        position.getPosY() - Numbers),
                position, ChessEnum.Direction.BLDiagonal);
    }

    public Movement BRD(Position position,int Numbers){
        return new Movement(
                new Position(
                        position.getPosX() + Numbers,
                        position.getPosY() - Numbers),
                position, ChessEnum.Direction.BRDiagonal);
    }
}
