package server.Data.ChessBoard.Movements;

import server.Data.ChessBoard.Board.ChessEnum;

public interface IKnightMovement {
    static Movement FLK(Position position) {
        return new Movement(
                new Position(
                        position.getPosX() - 1,
                        position.getPosY() + 3),
                position, ChessEnum.Direction.FLDiagonal);
    }

    static Movement FRK(Position position) {
        return new Movement(
                new Position(
                        position.getPosX() + 1,
                        position.getPosY() + 3),
                position, ChessEnum.Direction.FLDiagonal);
    }

    static Movement BLK(Position position) {
        return new Movement(
                new Position(
                        position.getPosX() - 1,
                        position.getPosY() - 3),
                position, ChessEnum.Direction.FLDiagonal);
    }

    static Movement BRK(Position position) {
        return new Movement(
                new Position(
                        position.getPosX() + 1,
                        position.getPosY() - 3),
                position, ChessEnum.Direction.FLDiagonal);
    }
}
