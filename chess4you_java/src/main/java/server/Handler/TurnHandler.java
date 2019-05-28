package server.Handler;

import lombok.var;
import org.springframework.stereotype.Component;
import server.Data.ChessBoard.Board.ChessBoard;
import server.Data.ChessBoard.Board.ChessEnum;
import server.Data.ChessBoard.Movements.*;
import server.Data.ChessBoard.Movements.base.Movement;
import server.Data.ChessBoard.Movements.base.Position;
import server.Data.ChessBoard.Pieces.Piece;
import server.Data.Game.Player;
import server.Validator.TurnValidator;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class TurnHandler {

    private TurnValidator validator = new TurnValidator();
    private LinearMovement linearMovements = new LinearMovement();
    private DiagonalMovement diagonalMovements = new DiagonalMovement();
    private KnightMovement knightMovements = new KnightMovement();
    private RochadeMovement rochadeMovement = new RochadeMovement();


    public List<Movement> getPossibleTurnFor(Dictionary<Position, Piece> listPiece, Piece piece) {
        var listMovements = new ArrayList<Movement>();
        for (int i = 0; i < piece.getDirections().length; i++) {
          switch (piece.getDirections()[i]) {
              case Linear:
                  listMovements.addAll(linearMovements(listPiece, piece));
                  break;
              case Diagonal:
                  listMovements.addAll(diagonalMovements(listPiece, piece));
                  break;
              case Pawn:
                  listMovements.addAll(enPasse(listPiece, piece, true));
                  break;
              case Knight:
                  listMovements.addAll(knightMovements(listPiece, piece));
                  break;
              case Rochade:
                  listMovements.addAll(rochadeMovements(listPiece, piece));
          }
        }
        return listMovements;
    }

    private List<Movement> rochadeMovements(Dictionary<Position, Piece> listPiece, Piece piece) {
        if(piece.getType() == ChessEnum.Piece.Knight) {
            var tmp = new ArrayList<Movement>();
            if(validator.rochadePossible(listPiece, piece)) {
                var indexRock =  Collections.list(listPiece.keys())
                        .stream()
                        .filter(position ->
                                position.getPosY() == piece.getPosition().getPosY()
                                        && position.getPosX() != piece.getPosition().getPosX()
                        )
                        .collect(Collectors.toList());
                var rock = listPiece.get(indexRock.get(0));
                switch (validator.rochadeType(listPiece, piece)) {
                    case smallRochade:
                        tmp.addAll(Arrays.asList(rochadeMovement.smallRochade(piece.getPosition(), rock.getPosition())));
                        break;
                    case bigRochade:
                        tmp.addAll(Arrays.asList(rochadeMovement.bigRochade(piece.getPosition(), rock.getPosition())));
                        break;
                }
            }
            return tmp;
        } else {
            return null;
        }
    }

    public List<Movement> diagonalMovements(Dictionary<Position, Piece> listPiece, Piece piece) {
        int number;
        switch (piece.getType()){
            case King:
                number = 1;
                break;
            default:
                number = 8;
                break;
        }
        var tmp = new ArrayList<Movement>();
        for(var method : diagonalMovements.getClass().getMethods()){
            if(method.getReturnType() == Movement.class) {
                tmp.addAll(movementsGeneral(diagonalMovements, method, 0, number, listPiece, piece, new ArrayList<>()));
            } else {
                break;
            }
        }
        return tmp;
    }

    public List<Movement> linearMovements(Dictionary<Position, Piece> listPiece, Piece piece) {
        int number;
        switch (piece.getType()){
            case King:
                number = 1;
                break;
            case Pawn:
                number = validator.onStartPosition(piece) ? 2 : 1;
            default:
                number = 8;
                break;
        }
        var tmp = new ArrayList<Movement>();
        for(var method : linearMovements.getClass().getMethods()){
            if(method.getReturnType() == Movement.class) {
                tmp.addAll(movementsGeneral(diagonalMovements, method, 0, number, listPiece, piece, new ArrayList<>()));
            } else {
                break;
            }
        }
        return tmp;
    }

    public List<Movement> enPasse(Dictionary<Position, Piece> listPiece, Piece piece, boolean reverse) {
        var tmp = new ArrayList<Movement>();
        if(reverse) {
            var result = validator.enPassePossible(listPiece, piece);
            if(result.isEnPassePossible) {
                for(var position :  Collections.list(listPiece.keys())) {
                    for(var movement : result.getMovements()) {
                        if(position.getPosY() == movement.getOldPosition().getPosY()
                        && position.getPosX() == movement.getOldPosition().getPosX()) {
                            if(validator.onStartPosition(listPiece.get(position))) {
                                tmp.add(movement);
                            }
                        }
                    }
                }
            }
        } else {
            if(validator.onStartPosition(piece)) {
                var result = validator.enPassePossible(listPiece, piece);
                if(result.isEnPassePossible) {
                    tmp.addAll(result.movements);
                }
            }
        }
        return tmp;
    }

    public List<Movement> knightMovements(Dictionary<Position, Piece> listPiece, Piece piece) {
        int number = 1;
        var tmp = new ArrayList<Movement>();
        for(var method : knightMovements.getClass().getMethods()){
            if(method.getReturnType() == Movement.class) {
                tmp.addAll(movementsGeneral(diagonalMovements, method, 0, number, listPiece, piece, new ArrayList<>()));
            } else {
                break;
            }
        }
        return tmp;
    }

    public List<Movement> movementsGeneral(Object instance, Method method, int counter, int number, Dictionary<Position, Piece> listPiece, Piece piece, List<Movement> listMovements){
        counter = counter == 0 ? 1 : counter;
        try{
            Object tmp = number == 0 ? method.invoke(instance, piece.getPosition()) :
                    method.invoke(instance, piece.getPosition(), counter);
            Movement movement = (Movement) tmp;
           var type = validator.pieceOnPosition(listPiece, movement.getNewPosition(), piece);
            switch (type) {
                case Friendly:
                    return listMovements;
                case Enemeny:
                    listMovements.add(movement);
                    return listMovements;
                case Nothing:
                    if(validator.possibleMovementOnBoard(movement)) {
                        listMovements.add(movement);
                        if(counter < number){
                            movementsGeneral(instance, method, ++counter, number, listPiece, piece, listMovements);
                        }
                        return listMovements;
                    }
                    return  listMovements;
            }
            return listMovements;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    public List<Movement> getPossibleThreadedPositionsForKing(ChessBoard chessBoard, Player player) {
        Piece king = chessBoard.getKingOfOpponent(player);
        var listMovements = new ArrayList<Movement>();
        Dictionary<Position, Piece> listPosPiece = chessBoard.getListPosPiece();
        listPosPiece.remove(king);
        for (int i = 0; i < king.getDirections().length; i++) {
            switch (king.getDirections()[i]) {
                case Linear:
                    listMovements.addAll(linearMovements(listPosPiece, king));
                    break;
                case Diagonal:
                    listMovements.addAll(diagonalMovements(listPosPiece, king));
                    break;
                case Pawn:
                    listMovements.addAll(enPasse(listPosPiece, king, true));
                    break;
                case Knight:
                    listMovements.addAll(knightMovements(listPosPiece, king));
                    break;
                case Rochade:
                    listMovements.addAll(rochadeMovements(listPosPiece, king));
            }
        }
        return listMovements;
    }
}
