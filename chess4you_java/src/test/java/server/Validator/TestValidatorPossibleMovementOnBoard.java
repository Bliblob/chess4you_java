package server.Validator;

import org.junit.Assert;
import org.junit.Test;
import server.Data.ChessBoard.Board.ChessEnum;
import server.Data.ChessBoard.Movements.base.Movement;
import server.Data.ChessBoard.Movements.base.Position;

import static org.hamcrest.CoreMatchers.is;

public class TestValidatorPossibleMovementOnBoard {
    private TurnValidator validator;

    public TestValidatorPossibleMovementOnBoard() {
        validator = new TurnValidator();
    }

    @Test
    public void OnBoardLeftForward(){
        Movement movement = new Movement(new Position(0,7),
                new Position(0, 0), ChessEnum.Direction.FRDiagonal);

        boolean actualResult = validator.possibleMovementOnBoard(movement);

        Assert.assertThat(actualResult, is(true));
    }

    @Test
    public void OnBoardRightForward(){
        Movement movement = new Movement(new Position(7,7),
                new Position(0, 0), ChessEnum.Direction.FRDiagonal);

        boolean actualResult = validator.possibleMovementOnBoard(movement);

        Assert.assertThat(actualResult, is(true));
    }

    @Test
    public void OnBoardLeftBackward(){
        Movement movement = new Movement(new Position(0,0),
                new Position(0, 0), ChessEnum.Direction.FRDiagonal);

        boolean actualResult = validator.possibleMovementOnBoard(movement);

        Assert.assertThat(actualResult, is(true));
    }

    @Test
    public void OnBoardRightBackward(){
        Movement movement = new Movement(new Position(7,7),
                new Position(0, 0), ChessEnum.Direction.FRDiagonal);

        boolean actualResult = validator.possibleMovementOnBoard(movement);

        Assert.assertThat(actualResult, is(true));
    }

    @Test
    public void NotOnBoardLeftForward(){
        Movement movement = new Movement(new Position(-1,8),
                new Position(0, 0), ChessEnum.Direction.FRDiagonal);

        boolean actualResult = validator.possibleMovementOnBoard(movement);

        Assert.assertThat(actualResult, is(false));
    }

    @Test
    public void NotOnBoardRightForward(){
        Movement movement = new Movement(new Position(8,8),
                new Position(0, 0), ChessEnum.Direction.FRDiagonal);

        boolean actualResult = validator.possibleMovementOnBoard(movement);

        Assert.assertThat(actualResult, is(false));
    }

    @Test
    public void NotOnBoardLeftBackward(){
        Movement movement = new Movement(new Position(-5,-1),
                new Position(0, 0), ChessEnum.Direction.FRDiagonal);

        boolean actualResult = validator.possibleMovementOnBoard(movement);

        Assert.assertThat(actualResult, is(false));
    }

    @Test
    public void NotOnBoardRightBackward(){
        Movement movement = new Movement(new Position(14,-1),
                new Position(0, 0), ChessEnum.Direction.FRDiagonal);

        boolean actualResult = validator.possibleMovementOnBoard(movement);

        Assert.assertThat(actualResult, is(false));
    }
}
