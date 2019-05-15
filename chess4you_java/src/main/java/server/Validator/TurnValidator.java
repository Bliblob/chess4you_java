package server.Validator;

import lombok.var;
import org.springframework.stereotype.Service;
import server.Data.ChessBoard.Board.ChessBoard;
import server.Data.ChessBoard.Board.ChessEnum;
import server.Data.ChessBoard.Movements.Position;
import server.Data.ChessBoard.Pieces.Piece;
import server.Game.Turn;

import java.util.Dictionary;
import java.util.List;

@Service
public class TurnValidator {
   private Turn turn;
   private ChessBoard board;

   public boolean Validate(ChessBoard board, Turn turn) {

       return true;

   }

   private boolean TestIfPosIsValid() {
       boolean isValid = false;
       switch (turn.getPiece().getType()) {
           case Pawn:
               isValid = checkPawn();
               break;
           case Rock:
               isValid = checkPawn();
               break;
           case Knight:
               isValid = checkPawn();
               break;
           case Bishop:
               isValid = checkPawn();
               break;
           case Queen:
               isValid = checkPawn();
               break;
           case King:
               isValid = checkPawn();
               break;
       }
       return isValid;
   }

    private boolean checkPawn() {
       return false;
    }

    private boolean isFriedlyPieceOnPlace(Piece piece){
       var list = (List<Position>) board.listPiece.keys();
       for (var pos : list){
           if(pos.getPosX() == piece.getPosition().getPosX() &&
                   pos.getPosY() == piece.getPosition().getPosY()){
               if(board.listPiece.get(pos).name != null)
               return false;
           }
       }
       return true;
   }
}
