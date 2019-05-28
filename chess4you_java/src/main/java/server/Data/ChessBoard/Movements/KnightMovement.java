package server.Data.ChessBoard.Movements;

import server.Data.ChessBoard.Board.ChessEnum;
import server.Data.ChessBoard.Movements.base.Movement;
import server.Data.ChessBoard.Movements.base.Position;

public class KnightMovement {

    public Movement FLKnight (Position position) {
        return new Movement(
                new Position(
                        position.getPosX() - 1,
                        position.getPosY() + 2),
                position, ChessEnum.Direction.FLKnight);

    }

    public Movement FRKnight (Position position) {
        return new Movement(
                new Position(
                        position.getPosX() + 1,
                        position.getPosY() + 2),
                position, ChessEnum.Direction.FRKnight);

    }

    public Movement BLKnight (Position position) {
        return new Movement(
                new Position(
                        position.getPosX() - 1,
                        position.getPosY() - 2),
                position, ChessEnum.Direction.BLKnight);

    }

    public Movement BRKnight (Position position) {
        return new Movement(
                new Position(
                        position.getPosX() + 1,
                        position.getPosY() - 2),
                position, ChessEnum.Direction.BRKnight);

    }
}
