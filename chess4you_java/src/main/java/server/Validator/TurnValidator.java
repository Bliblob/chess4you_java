package server.Validator;

import lombok.var;
import org.springframework.stereotype.Service;
import server.Data.ChessBoard.Board.ChessEnum;
import server.Data.ChessBoard.Movements.base.Movement;
import server.Data.ChessBoard.Movements.base.Position;
import server.Data.ChessBoard.Pieces.Piece;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TurnValidator {

    public boolean onStartPosition(Piece piece) {
        switch (piece.getType()) {
            case Pawn:
                return piece.getPosition().getPosY() == 1
                        || piece.getPosition().getPosY() == 6;
            case Knight:
                return (piece.getPosition().getPosY() == 0
                        && piece.getPosition().getPosX() == 4)
                        || (piece.getPosition().getPosY() == 7
                        && piece.getPosition().getPosX() == 3);
            case Rock:
                return (piece.getPosition().getPosY() == 0
                        && piece.getPosition().getPosX() == 0)
                        || (piece.getPosition().getPosY() == 0
                        && piece.getPosition().getPosX() == 7)
                        || (piece.getPosition().getPosY() == 7
                        && piece.getPosition().getPosX() == 0)
                        || (piece.getPosition().getPosY() == 7
                        && piece.getPosition().getPosX() == 7);
            default:
                return false;
        }
    }

    public ChessEnum.PositionType pieceOnPosition(Dictionary<Position, Piece> listPiece, Position position, Piece piece) {
       ArrayList<Position> listPosition = Collections.list(listPiece.keys());
       for(var position2 : listPosition) {
            if( position2.getPosX() == position.getPosX() &&
                    position2.getPosY() == position.getPosY()) {
                if(listPiece.get(position2).getColor() == piece.getColor()) {
                    return ChessEnum.PositionType.Friendly;
                } else {
                    return ChessEnum.PositionType.Enemeny;
                }
            }
        }
        return ChessEnum.PositionType.Nothing;
    }

    public boolean possibleMovementOnBoard(Movement movement) {
       return movement.getNewPosition().getPosY() >= 1
               && movement.getNewPosition().getPosY() <= 8
               && movement.getNewPosition().getPosX() >= 1
               && movement.getNewPosition().getPosX() <= 8;
    }

    public boolean movementAreEqual(Movement firstMovement, Movement secondMovement) {
       if((firstMovement.getNewPosition().getPosY() == secondMovement.getNewPosition().getPosY())
               && (firstMovement.getNewPosition().getPosX() == secondMovement.getNewPosition().getPosX())
               && (firstMovement.getOldPosition().getPosY() == secondMovement.getOldPosition().getPosY())
               && (firstMovement.getOldPosition().getPosX() == secondMovement.getOldPosition().getPosX())
               && (firstMovement.getDirection() == secondMovement.getDirection())) {
           return true;
       } else  {
           return false;
       }
    }

    public boolean rochadePossible(Dictionary<Position, Piece> listPiece, Piece piece) {
        List<Position> listPosition =  Collections.list(listPiece.keys()).stream()
                .filter(position ->
                    position.getPosY() == piece.getPosition().getPosY()
                )
                .collect(Collectors.toList());
        if(listPosition.size() == 2){
            if(onStartPosition(piece)) {
                if(onStartPosition(listPiece.get(listPosition.remove(piece.getPosition())))) {
                    return true;
                }
            }
        }
        return false;
   }

    public ChessEnum.Direction rochadeType(Dictionary<Position, Piece> listPiece, Piece piece) {
        List<Position> listPosition =  Collections.list(listPiece.keys()).stream()
                .filter(position ->
                        position.getPosY() == piece.getPosition().getPosY()
                )
                .collect(Collectors.toList());
        listPosition.remove(piece.getPosition());
        return (listPosition.get(0).getPosX() == 0 && listPosition.get(0).getPosY() == 0)
                || (listPosition.get(0).getPosX() == 7 && listPosition.get(0).getPosY() == 7)
                ? ChessEnum.Direction.bigRochade : ChessEnum.Direction.smallRochade;
    }

    public EnPasseResult enPassePossible(Dictionary<Position, Piece> listPiece, Piece piece) {
        List<Position> listPosition = Collections.list(listPiece.keys());
        listPosition.remove(piece.getPosition());

        Position blackPosForward = piece.getPosition();
        blackPosForward.setPosY(piece.getPosition().getPosY() - 1);

        Position whitePosForward = piece.getPosition();
        whitePosForward.setPosY(piece.getPosition().getPosY() + 1);

        if(listPosition.contains(blackPosForward)) {
            return getPossibleEnPasse(listPosition,piece, ChessEnum.Color.Black);
        } else if(listPosition.contains(whitePosForward)) {
            return getPossibleEnPasse(listPosition,piece, ChessEnum.Color.White);
        } else {
            return new EnPasseResult(false);
        }
    }

    public EnPasseResult getPossibleEnPasse(List<Position> listPosition, Piece piece, ChessEnum.Color color){
        int number = color == ChessEnum.Color.Black ? -1: +1;
        Position posLeft = piece.getPosition();
        Position posRight = piece.getPosition();
        posLeft.setPosX(piece.getPosition().getPosX() - 1);
        posRight.setPosX(piece.getPosition().getPosX() + 1);
        Movement movementOne = null;
        Movement movementTwo = null;

        if(listPosition.contains(posLeft)) {
            posLeft.setPosY(posLeft.getPosY() + number);
            if(listPosition.contains(posLeft)) {
                movementOne = new Movement(posLeft, piece.getPosition(), ChessEnum.Direction.FLEnPasse);
            }
        } else if(listPosition.contains(posRight)) {
            posRight.setPosY(posRight.getPosY() + number);
            if(listPosition.contains(posRight)) {
                movementTwo = new Movement(posLeft, piece.getPosition(), ChessEnum.Direction.FREnPasse);
            }
        } else {
            return new EnPasseResult(false);
        }
        if(movementOne != null && movementTwo != null) {
            return new EnPasseResult(true, Arrays.asList(movementOne, movementTwo));
        } else if(movementOne != null && movementTwo == null) {
            return new EnPasseResult(true, Arrays.asList(movementOne));
        } else if(movementOne == null && movementTwo != null) {
            return new EnPasseResult(true, Arrays.asList(movementTwo));
        } else{
            return new EnPasseResult(false);
        }
    }
}
