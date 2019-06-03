package server.Data.ChessBoard.Board;

import lombok.Getter;
import lombok.Setter;
import lombok.var;
import server.Data.ChessBoard.Movements.base.Position;
import server.Data.ChessBoard.Pieces.*;
import server.Data.Game.Player;

import java.util.*;

public class ChessBoard {
    @Getter @Setter
    private Dictionary<Position, Piece> listPosPiece = new Hashtable<>();

    public ChessBoard() {
        initListPosPiece();
    }

    private void initListPosPiece() {
        listPosPiece.put(new Position(0,0), new Rock(ChessEnum.Color.Black));
        listPosPiece.put(new Position(1,0), new Knight(ChessEnum.Color.Black));
        listPosPiece.put(new Position(2,0), new Bishop(ChessEnum.Color.Black));
        listPosPiece.put(new Position(3,0), new King(ChessEnum.Color.Black));
        listPosPiece.put(new Position(4,0), new Queen(ChessEnum.Color.Black));
        listPosPiece.put(new Position(5,0), new Bishop(ChessEnum.Color.Black));
        listPosPiece.put(new Position(6,0), new Knight(ChessEnum.Color.Black));
        listPosPiece.put(new Position(7,0), new Rock(ChessEnum.Color.Black));
        listPosPiece.put(new Position(0,1), new Pawn(ChessEnum.Color.Black));
        listPosPiece.put(new Position(1,1), new Pawn(ChessEnum.Color.Black));
        listPosPiece.put(new Position(2,1), new Pawn(ChessEnum.Color.Black));
        listPosPiece.put(new Position(3,1), new Pawn(ChessEnum.Color.Black));
        listPosPiece.put(new Position(4,1), new Pawn(ChessEnum.Color.Black));
        listPosPiece.put(new Position(5,1), new Pawn(ChessEnum.Color.Black));
        listPosPiece.put(new Position(6,1), new Pawn(ChessEnum.Color.Black));
        listPosPiece.put(new Position(7,1), new Pawn(ChessEnum.Color.Black));
        listPosPiece.put(new Position(0,6), new Pawn(ChessEnum.Color.White));
        listPosPiece.put(new Position(1,6), new Pawn(ChessEnum.Color.White));
        listPosPiece.put(new Position(2,6), new Pawn(ChessEnum.Color.White));
        listPosPiece.put(new Position(3,6), new Pawn(ChessEnum.Color.White));
        listPosPiece.put(new Position(4,6), new Pawn(ChessEnum.Color.White));
        listPosPiece.put(new Position(5,6), new Pawn(ChessEnum.Color.White));
        listPosPiece.put(new Position(6,6), new Pawn(ChessEnum.Color.White));
        listPosPiece.put(new Position(7,6), new Pawn(ChessEnum.Color.White));
        listPosPiece.put(new Position(0,7), new Rock(ChessEnum.Color.White));
        listPosPiece.put(new Position(1,7), new Knight(ChessEnum.Color.White));
        listPosPiece.put(new Position(2,7), new Bishop(ChessEnum.Color.White));
        listPosPiece.put(new Position(3,7), new Queen(ChessEnum.Color.White));
        listPosPiece.put(new Position(4,7), new King(ChessEnum.Color.White));
        listPosPiece.put(new Position(5,7), new Bishop(ChessEnum.Color.White));
        listPosPiece.put(new Position(6,7), new Knight(ChessEnum.Color.White));
        listPosPiece.put(new Position(7,7), new Rock(ChessEnum.Color.White));
    }

    public void updateDictionaryPosPiece(Piece piece, Position position) {
        listPosPiece.remove(piece);
        listPosPiece.put(position, piece);
    }

    public Field[][] generateChessBoard(boolean reverse) {
        int boardSize = 8;
        Field[][] chessBoard = new Field[boardSize][boardSize];
        for (int y = 0; y < boardSize; y++) {
            for (int x = 0; x < boardSize; x++) {
             chessBoard[y][x] = new Field(false);
            }
        }
        if(reverse) {
            var reverseList = Collections.list(listPosPiece.keys());
            Collections.reverse(reverseList);
            for(var entry : reverseList) {
                chessBoard[entry.getPosY()][ entry.getPosX()] = new Field(listPosPiece.get(entry), true);
            }
        } else {
            for (var entry : Collections.list(listPosPiece.keys())) {
                chessBoard[entry.getPosY()][entry.getPosX()] = new Field(listPosPiece.get(entry), true);
            }
        }
        return chessBoard;
    }

    public Piece getKingOfOpponent(Player player){
        return (Piece) Collections.list(listPosPiece.elements())
                .stream()
                .filter(tmpPiece -> tmpPiece.getColor() == player.getColor())
                .filter(tmpPiece -> tmpPiece.getType() == ChessEnum.Piece.King)
                .toArray()[0];
    }
}
