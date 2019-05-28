package server.Data.ChessBoard.Movements;

import server.Data.ChessBoard.Board.ChessEnum;
import server.Data.ChessBoard.Movements.base.Movement;
import server.Data.ChessBoard.Movements.base.Position;

public class LinearMovement {
    public Movement F(Position position, int Numbers) {
        return new Movement(
                new Position(
                        position.getPosX(),
                        position.getPosY()  + Numbers),
                position, ChessEnum.Direction.Forward);

    }
    public Movement B(Position position,int Numbers) {
        return new Movement(
                new Position(
                        position.getPosX(),
                        position.getPosY() - Numbers),
                position, ChessEnum.Direction.Backward);

    }
    public Movement L(Position position,int Numbers) {
        return new Movement(
                new Position(
                        position.getPosX() - Numbers,
                        position.getPosY()),
                position, ChessEnum.Direction.Left);

    }
    public Movement R(Position position,int Numbers) {
        return new Movement(
                new Position(
                        position.getPosX() + Numbers,
                        position.getPosY()),
                position, ChessEnum.Direction.Right);

    }
}
