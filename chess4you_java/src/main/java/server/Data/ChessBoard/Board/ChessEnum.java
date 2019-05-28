package server.Data.ChessBoard.Board;

public class ChessEnum {
    public enum DirectionType {
        Linear, Diagonal,Knight, Pawn, Rochade
    }
    public enum Direction {
        FLEnPasse, FREnPasse, FLDiagonal,
        Backward, Forward, Left, FRPawn, FLPawn, FRDiagonal, BLDiagonal, BRDiagonal, FLKnight, BRKnight, BLKnight, FRKnight, smallRochade, bigRochade, Right
    }
    public enum Color {
        Black, White
    }

    public enum Piece {
        Pawn, Rock, Knight, Bishop, Queen, King
    }
    public enum PositionType{
        Enemeny, Friendly, Nothing
    }
}
