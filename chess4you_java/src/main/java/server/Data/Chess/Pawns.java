package server.Data.Chess;

public class Pawns extends Piece {

    public Pawns(Position position, e.Color color) {
        super(position, color);
    }

    public Movement FL() {
        Movement move = new Movement();
        move.setDirection(e.Direction.FLPawn);
        return move;
    }
}
