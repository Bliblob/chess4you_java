package server.Validator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import server.Data.ChessBoard.Board.ChessEnum.PositionType;
import server.Data.ChessBoard.Movements.base.Position;
import server.Data.ChessBoard.Pieces.Pawn;
import server.Data.ChessBoard.Pieces.Piece;

import java.util.Dictionary;
import java.util.Hashtable;

import static org.hamcrest.CoreMatchers.is;
import static server.Data.ChessBoard.Board.ChessEnum.Color.Black;
import static server.Data.ChessBoard.Board.ChessEnum.Color.White;

public class TestValidatorPieceOnPosition {
    private TurnValidator validator;
    private Dictionary<Position, Piece> listPosPiece;

    public TestValidatorPieceOnPosition() {
        listPosPiece = new Hashtable<>();
        validator = new TurnValidator();
    }

    @Before
    public void init(){
        Pawn friendlyPawn = new Pawn(Black);
        friendlyPawn.setPosition(new Position(4,5));
        Pawn hostilePawn = new Pawn(White);
        hostilePawn.setPosition(new Position(6,1));

        listPosPiece.put(friendlyPawn.getPosition(), friendlyPawn);
        listPosPiece.put(hostilePawn.getPosition(), hostilePawn);
    }

    @Test
    public void IfFriendlyPieceOnPosition() {
        Pawn pawn = new Pawn(Black);
        pawn.setPosition(new Position(0,6));

        PositionType actualPositionType = validator.pieceOnPosition(listPosPiece,
                new Position(4,5), pawn );

        Assert.assertThat(actualPositionType, is(PositionType.Friendly));
    }

    @Test
    public void IfEnemyOnPosition() {
        Pawn pawn = new Pawn(Black);
        pawn.setPosition(new Position(0,6));

        PositionType actualPositionType = validator.pieceOnPosition(listPosPiece,
                new Position(6,1), pawn );

        Assert.assertThat(actualPositionType, is(PositionType.Enemeny));
    }

    @Test
    public void IfNothingOnPosition() {
        Pawn pawn = new Pawn(Black);
        pawn.setPosition(new Position(0,6));

        PositionType actualPositionType = validator.pieceOnPosition(listPosPiece,
                new Position(1,0), pawn );

        Assert.assertThat(actualPositionType, is(PositionType.Nothing));
    }
}
