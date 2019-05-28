package server.Data.ChessBoard.Movements;

import server.Data.ChessBoard.Board.ChessEnum;
import server.Data.ChessBoard.Movements.base.Movement;
import server.Data.ChessBoard.Movements.base.Position;

public class PawnMovement {
    public Movement FLEnPasse(Position position) {
        return new Movement(
                new Position(
                        position.getPosX() - 1,
                        position.getPosY() + 1),
                position, ChessEnum.Direction.FLEnPasse);
    }

    public Movement FREnPasse(Position position) {
        return new Movement(
                new Position(
                        position.getPosX() + 1,
                        position.getPosY() + 1),
                position, ChessEnum.Direction.FREnPasse);
    }
}
