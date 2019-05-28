package server.Data.ChessBoard.Movements;

import server.Data.ChessBoard.Board.ChessEnum;
import server.Data.ChessBoard.Movements.base.Movement;
import server.Data.ChessBoard.Movements.base.Position;

public class RochadeMovement {

    public Movement[] smallRochade (Position positionKing, Position positionRock) {
        if(positionKing.getPosX() == 4) {
            return new Movement[]{
                    new Movement(
                            new Position(
                                    positionKing.getPosX() + 2,
                                    positionKing.getPosY()),
                            positionKing, ChessEnum.Direction.smallRochade),
                    new Movement(
                            new Position(
                                    positionRock.getPosX() - 2,
                                    positionRock.getPosY()),
                            positionRock, ChessEnum.Direction.smallRochade),
            };
        } else {
            return new Movement[]{
                    new Movement(
                            new Position(
                                    positionKing.getPosX() - 2,
                                    positionKing.getPosY()),
                            positionKing, ChessEnum.Direction.smallRochade),
                    new Movement(
                            new Position(
                                    positionRock.getPosX() + 2,
                                    positionRock.getPosY()),
                            positionRock, ChessEnum.Direction.smallRochade),
            };
        }
    }

    public Movement[] bigRochade (Position positionKing, Position positionRock) {
        if(positionKing.getPosX() == 4) {
            return new Movement[]{
                    new Movement(
                            new Position(
                                    positionKing.getPosX() - 2,
                                    positionKing.getPosY()),
                            positionKing, ChessEnum.Direction.bigRochade),
                    new Movement(
                            new Position(
                                    positionRock.getPosX() + 3,
                                    positionRock.getPosY()),
                            positionRock, ChessEnum.Direction.bigRochade),
            };
        } else {
            return new Movement[]{
                    new Movement(
                            new Position(
                                    positionKing.getPosX() + 2,
                                    positionKing.getPosY()),
                            positionKing, ChessEnum.Direction.bigRochade),
                    new Movement(
                            new Position(
                                    positionRock.getPosX() - 3,
                                    positionRock.getPosY()),
                            positionRock, ChessEnum.Direction.bigRochade),
            };
        }
    }
}
