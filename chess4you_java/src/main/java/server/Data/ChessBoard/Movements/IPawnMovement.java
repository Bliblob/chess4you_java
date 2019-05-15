package server.Data.ChessBoard.Movements;

import server.Data.ChessBoard.Board.ChessEnum;

public interface IPawnMovement {
    static Movement FLEnPasse(Position position) {
        return new Movement(
                new Position(
                        position.getPosX() - 1,
                        position.getPosY() + 1),
                position, ChessEnum.Direction.FLDiagonal);
    }

    static Movement FREnPasse(Position position) {
        return new Movement(
                new Position(
                        position.getPosX() + 1,
                        position.getPosY() + 1),
                position, ChessEnum.Direction.FLDiagonal);
    }
}
