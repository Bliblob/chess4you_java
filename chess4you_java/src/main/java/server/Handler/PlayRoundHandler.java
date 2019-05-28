package server.Handler;

import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import server.Data.ChessBoard.Board.Field;
import server.Data.ChessBoard.Movements.base.Movement;
import server.Data.ChessBoard.Movements.base.Position;
import server.Data.Game.Info;
import server.Game.Game;
import server.Service.GameDataService;
import server.Validator.TurnValidator;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class PlayRoundHandler {

    private GameDataService gameDataService;
    private LobbyHandler lobbyHandler;
    private TurnHandler turnHandler;
    private TurnValidator turnValidator;
    private List<Movement> tmpList;

    @Autowired
    public PlayRoundHandler(GameDataService gameDataService, LobbyHandler lobbyHandler, TurnHandler turnHandler, TurnValidator turnValidator){
        this.gameDataService = gameDataService;
        this.lobbyHandler = lobbyHandler;
        this.turnHandler = turnHandler;
        this.turnValidator = turnValidator;
    }


    public Info info(String lobbyUuid) {
        var game = gameDataService.getGame(UUID.fromString(lobbyUuid));
        return new Info(game.getCurrentPlayer(), game.getLastChange());
    }

    public List<Movement> getPossibleTurnFor(String lobbyUuid, String playerUuid, Position position) throws Exception {
        var game = gameDataService.getGame(UUID.fromString(lobbyUuid));
        var duration = game.getLastChange();
        duration.setMinutes(10);
        if(game.getLastChange().getTime() < gameDataService.getCurrentDate() &&
                gameDataService.getCurrentDate() > duration.getTime()) {
            if (game.getCurrentPlayer().getId() == playerUuid) {
                var listPiece = game.getBoard().getListPosPiece();
                var piece = listPiece.get(position);
                if(piece != null){
                    throw new Exception();
                }
                tmpList =  turnHandler.getPossibleTurnFor(listPiece, piece);
                return tmpList;
            } else {
                throw  new Exception();
            }
        } else {
            throw new Exception();
        }
    }

    /*public List<List<Field>> doTurn(String lobbyUuid, String playerUuid, Movement tmpMovement) {
        var inList = tmpList.stream()
                .filter(movement ->  turnValidator.movementAreEqual(movement, tmpMovement))
                .findFirst();
        if(inList != null){
            var game = gameDataService.getGame(UUID.fromString(lobbyUuid));
            var duration = game.getLastChange();
            duration.setMinutes(10);
            if(game.getLastChange().getTime() < gameDataService.getCurrentDate() &&
            gameDataService.getCurrentDate() > duration.getTime()) {
                if (game.getCurrentPlayer().getId() == playerUuid) {
                    var oldPiece = game.getBoard()
                            .getChessBoard()
                            .get(inList.get().getOldPosition().getPosY())
                            .get(inList.get().getOldPosition().getPosX()).getPiece();
                    var newPiece = game.getBoard()
                            .getChessBoard()
                            .get(inList.get().getNewPosition().getPosY())
                            .get(inList.get().getNewPosition().getPosX()).getPiece();
                    game.getBoard()
                            .getChessBoard()
                            .get(inList.get().getOldPosition().getPosY())
                            .get(inList.get().getOldPosition().getPosX()).setPiece(newPiece);
                    game.getBoard()
                            .getChessBoard()
                            .get(inList.get().getNewPosition().getPosY())
                            .get(inList.get().getNewPosition().getPosX()).setPiece(oldPiece);
                    game.setLastChange(new Date());
                    var lobby = lobbyHandler.getLobby(UUID.fromString(lobbyUuid));
                    if(lobby.getPlayerTwo().getId() == playerUuid) {
                        game.setCurrentPlayer(lobby.getPlayerOne());
                    } else {
                        game.setCurrentPlayer(lobby.getPlayerTwo());
                    }
                    game.setKingIsThreatenedResult(turnHandler.getPossibleThreadedPositionsForKing(game.getBoard(),game.getCurrentPlayer()));
                    return game.getBoard().getChessBoard();
                }
            }
        }
        return null;
    }*/

    public Field[][] getBoardState(String lobbyUuid) {
        return gameDataService.getGame(UUID.fromString(lobbyUuid)).getBoard().generateChessBoard();
    }

    public Game startGame(String lobbyUuid) {
        var lobby = lobbyHandler.getLobby(UUID.fromString(lobbyUuid));
        if(lobby != null && lobby.getPlayerTwo() != null) {
            gameDataService.setGame(lobby);
        }
        return gameDataService.getGame(UUID.fromString(lobbyUuid));
    }
}
