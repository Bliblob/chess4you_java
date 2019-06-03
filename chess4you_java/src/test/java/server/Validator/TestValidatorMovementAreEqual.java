package server.Validator;

import org.junit.Assert;
import org.junit.Test;
import server.Data.ChessBoard.Board.ChessEnum;
import server.Data.ChessBoard.Movements.base.Movement;
import server.Data.ChessBoard.Movements.base.Position;

import static org.hamcrest.CoreMatchers.is;

public class TestValidatorMovementAreEqual {
    private TurnValidator validator;

    public TestValidatorMovementAreEqual() {
        validator = new TurnValidator();
    }

    @Test
    public void MovementsAreEqual(){
        Movement firstMovement = new Movement(new Position(0,7),
                new Position(0, 0), ChessEnum.Direction.FRDiagonal);
        Movement secondMovement = new Movement(new Position(0,7),
                new Position(0, 0), ChessEnum.Direction.FRDiagonal);

        boolean actualResult = validator.movementAreEqual(firstMovement, secondMovement);

        Assert.assertThat(actualResult, is(true));
    }

    @Test
    public void MovementsNewPositionAreNotEqual(){
        Movement firstMovement = new Movement(new Position(1,7),
                new Position(0, 0), ChessEnum.Direction.FRDiagonal);
        Movement secondMovement = new Movement(new Position(0,7),
                new Position(0, 0), ChessEnum.Direction.FRDiagonal);

        boolean actualResult = validator.movementAreEqual(firstMovement, secondMovement);

        Assert.assertThat(actualResult, is(false));
    }

    @Test
    public void MovementsOldPositionAreNotEqual(){
        Movement firstMovement = new Movement(new Position(0,7),
                new Position(1, 0), ChessEnum.Direction.FRDiagonal);
        Movement secondMovement = new Movement(new Position(0,7),
                new Position(0, 0), ChessEnum.Direction.FRDiagonal);

        boolean actualResult = validator.movementAreEqual(firstMovement, secondMovement);

        Assert.assertThat(actualResult, is(false));
    }


    @Test
    public void MovementsDirectionAreNotEqual(){
        Movement firstMovement = new Movement(new Position(0,7),
                new Position(0, 0), ChessEnum.Direction.FRKnight);
        Movement secondMovement = new Movement(new Position(0,7),
                new Position(0, 0), ChessEnum.Direction.FRDiagonal);

        boolean actualResult = validator.movementAreEqual(firstMovement, secondMovement);

        Assert.assertThat(actualResult, is(false));
    }
}
