package server;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import server.Data.ChessBoard.Board.ChessEnum;
import server.Data.ChessBoard.Movements.base.Position;
import server.Data.ChessBoard.Pieces.Pawn;
import server.Data.ChessBoard.Pieces.Piece;
import server.Validator.TurnValidator;

@RunWith(MockitoJUnitRunner.class)
public class TestsGameHandler {

    Piece testPieceBlack = new Pawn(ChessEnum.Color.Black);
    Piece testPieceWhite = new Pawn(ChessEnum.Color.White);

    TurnValidator turnValidator;
    @Before
    public void init(){
        turnValidator = new TurnValidator();
    }

    @Test
    public void PawnIsOnStartPositionWhite(){
        testPieceWhite.setPosition(new Position(2, 3));
        Assert.assertTrue(turnValidator.onStartPosition(testPieceWhite));
    }

    @Test
    public void PawnIsOnStartPositionBlack(){
        testPieceBlack.setPosition(new Position(7, 3));
        Assert.assertTrue(turnValidator.onStartPosition(testPieceBlack));
    }

    @Test
    public void PawnIsNotOnStartPositionWhite(){
        testPieceWhite.setPosition(new Position(4, 3));
        Assert.assertFalse(turnValidator.onStartPosition(testPieceWhite));
    }

    @Test
    public void PawnIsNotOnStartPositionBlack(){
        testPieceBlack.setPosition(new Position(8, 3));
        Assert.assertFalse(turnValidator.onStartPosition(testPieceBlack));
    }

    @Test
    public void GetPossibleTurn(){
    }
}
