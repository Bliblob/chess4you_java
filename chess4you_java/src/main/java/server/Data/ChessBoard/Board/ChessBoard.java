package server.Data.ChessBoard.Board;

import lombok.Getter;
import lombok.Setter;
import server.Data.ChessBoard.Movements.Position;
import server.Data.ChessBoard.Pieces.*;

import java.util.*;

public class ChessBoard {
    @Getter @Setter
    public List<List<Field>> ChessBoard;
    public Dictionary<Position, Piece> listPiece;

    public ChessBoard() {
        ChessBoard = initBoard();
    }

    public  List<List<Field>> initBoard() {
        List<List<Field>> tmp = new ArrayList<>();
        for (int Y = 0; Y < 8; Y++) {
            switch (Y) {
                case 7:
                    tmp.add(getLinePiece(ChessEnum.Color.Black));
                    break;
                case 6:
                    tmp.add(getLinePawn(ChessEnum.Color.Black));
                    break;
                case 0:
                    tmp.add(getLinePiece(ChessEnum.Color.White));
                    break;
                case 1:
                    tmp.add(getLinePawn(ChessEnum.Color.White));
                    break;
                default:
                    tmp.add(getEmptyLine());
                    break;
            }
        }
        return tmp;
    }

    private List<Field> getLinePiece(ChessEnum.Color color) {
        List<Field> line = new ArrayList<>();
        for (int X = 8; X > 0; X--) {
            switch (X){
                case 1:
                case 8:
                    line.add(new Field(new Rock(color)));
                    break;
                case 2:
                case 7:
                    line.add(new Field(new Knight(color)));
                    break;
                case 3:
                case 6:
                    line.add(new Field(new Bishop(color)));
                    break;
                case 4:
                    if(ChessEnum.Color.Black == color) {
                        line.add(new Field(new King(color)));
                    } else {
                        line.add(new Field(new Queen(color)));
                    }
                    break;
                case 5:
                    if(ChessEnum.Color.Black == color) {
                        line.add(new Field(new Queen(color)));
                    } else {
                        line.add(new Field(new King(color)));
                    }
                    break;
            }
        }
        return line;
    }

    private List<Field> getLinePawn(ChessEnum.Color color){
        List<Field> line = new ArrayList<>();
        for (int X = 8; X > 0; X--) {
            line.add(new Field(new Pawn(color)));
        }
        return line;
    }

    private List<Field> getEmptyLine(){
        List<Field> line = new ArrayList<>();
        for (int X = 8; X > 0; X--) {
            line.add(new Field());
        }
        return line;
    }
}
