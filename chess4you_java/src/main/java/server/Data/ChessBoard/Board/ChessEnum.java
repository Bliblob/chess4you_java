package server.Data.ChessBoard.Board;

public class ChessEnum {
    public enum Direction {
        Forward, Backward, Left, Right, FLDiagonal, FRDiagonal, BLDiagonal, BRDiagonal,
        FLKnight, FRKnight, BLKnight, BRKnight, smRochade, bigRochade, FLPawn, FRPawn
    }
    public enum Color {
        Black, White
    }

    public enum Piece {
        Pawn, Rock, Knight, Bishop, Queen, King
    }
}
