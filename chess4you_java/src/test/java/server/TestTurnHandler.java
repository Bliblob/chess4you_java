package server;

import lombok.var;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import server.Data.ChessBoard.Board.ChessEnum;
import server.Data.ChessBoard.Movements.DiagonalMovement;
import server.Data.ChessBoard.Movements.base.Movement;
import server.Data.ChessBoard.Movements.base.Position;
import server.Data.ChessBoard.Pieces.Bishop;
import server.Handler.TurnHandler;

import java.util.ArrayList;
import java.util.Hashtable;

@RunWith(MockitoJUnitRunner.class)
public class TestTurnHandler {

    private TurnHandler turnHandler;
    @Before
    public void init(){
        turnHandler = new TurnHandler();
    }

    @Test
    public void TestMovements() {
        // init used objects
        var diagonalMovements = new DiagonalMovement();
        var testList = new ArrayList<Movement>();
        var testListCorrect = new ArrayList<Movement>();
        var testPiece = new Bishop(ChessEnum.Color.Black);
        var testDictionary = new Hashtable();

        // set data for objects
        testPiece.setPosition(new Position(1, 1));
        testListCorrect.add(new Movement(new Position(2, 2), new Position(1, 1), ChessEnum.Direction.FRDiagonal));
        testDictionary.put(new Position(3, 3), new Bishop(ChessEnum.Color.Black));

        // get data for testList
        for(var method : diagonalMovements.getClass().getMethods()){
            if(method.getReturnType() == Movement.class) {
                testList.addAll(turnHandler.movementsGeneral(diagonalMovements, method, 0, 3, testDictionary, testPiece, new ArrayList<>()));
            } else {
                break;
            }
        }
        // test if Size Equal
        Assert.assertEquals(testListCorrect.size(), testList.size());
        for (int i = 0; i < testListCorrect.size(); i++) {
            // test if new Position was correct
            Assert.assertEquals(testListCorrect.get(i).getNewPosition().getPosX(), testList.get(i).getNewPosition().getPosX());
            Assert.assertEquals(testListCorrect.get(i).getNewPosition().getPosY(), testList.get(i).getNewPosition().getPosY());
            // test if direction was correct
            Assert.assertEquals(testListCorrect.get(i).getDirection(), testList.get(i).getDirection());
            // test if old Position was correct
            Assert.assertEquals(testListCorrect.get(i).getOldPosition().getPosX(), testList.get(i).getOldPosition().getPosX());
            Assert.assertEquals(testListCorrect.get(i).getOldPosition().getPosY(), testList.get(i).getOldPosition().getPosY());
        }

    }
}
