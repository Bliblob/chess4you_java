package server.Data.ChessBoard.Movements;

import server.Data.ChessBoard.Board.ChessEnum;

public interface ILinearMovement {
    static Movement F(Position position,int Numbers) {
        return new Movement(
                new Position(
                        position.getPosX(),
                        position.getPosY()  + Numbers),
                position, ChessEnum.Direction.FLDiagonal);

    }
    static Movement B(Position position,int Numbers) {
        return new Movement(
                new Position(
                        position.getPosX(),
                        position.getPosY() - Numbers),
                position, ChessEnum.Direction.FLDiagonal);

    }
    static Movement L(Position position,int Numbers) {
        return new Movement(
                new Position(
                        position.getPosX() - Numbers,
                        position.getPosY()),
                position, ChessEnum.Direction.FLDiagonal);

    }
    static Movement R(Position position,int Numbers) {
        return new Movement(
                new Position(
                        position.getPosX() + Numbers,
                        position.getPosY()),
                position, ChessEnum.Direction.FLDiagonal);

    }
}
