package server.Handler;

import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import server.Data.ChessBoard.Board.ChessEnum;
import server.Data.ChessBoard.Board.Field;
import server.Data.ChessBoard.Movements.base.Movement;
import server.Data.ChessBoard.Movements.base.Position;
import server.Data.Game.Info;
import server.Data.Lobby.Lobby;
import server.Game.Game;
import server.Service.GameDataService;
import server.Validator.TurnValidator;

import java.util.Collections;
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

    public Field[][] doTurn(String lobbyUuid, String playerUuid, Movement tmpMovement) {
        var inList = tmpList.stream()
                .filter(movement ->  turnValidator.movementAreEqual(movement, tmpMovement))
                .findFirst();
        var lobby = lobbyHandler.getLobby(UUID.fromString(lobbyUuid));
        var game = gameDataService.getGame(UUID.fromString(lobbyUuid));
        if(inList != null){

            var duration = game.getLastChange();
            duration.setMinutes(10);
            if(game.getLastChange().getTime() < gameDataService.getCurrentDate() &&
            gameDataService.getCurrentDate() > duration.getTime()) {
                if (game.getCurrentPlayer().getId() == playerUuid) {
                    var piece = Collections.list(game.getBoard().getListPosPiece().elements())
                            .stream()
                            .filter(element -> element.getPosition() == inList.get().getOldPosition())
                            .findFirst();

                    game.getBoard().getListPosPiece()
                            .put(inList.get().getNewPosition(), piece.get());

                    game.setLastChange(new Date());

                    if(lobby.getPlayerTwo().getId() == playerUuid) {
                        game.setCurrentPlayer(lobby.getPlayerOne());
                    } else {
                        game.setCurrentPlayer(lobby.getPlayerTwo());
                    }
                    game.setKingIsThreatenedResult(turnHandler.getPossibleThreadedPositionsForKing(game.getBoard(),game.getCurrentPlayer()));
                    return generateBoardForDoTurn(game, lobby);
                }
            }
        }
        return generateBoardForDoTurn(game, lobby);
    }

    private Field[][] generateBoardForDoTurn(Game game, Lobby lobby) {
        if(game.getCurrentPlayer().getId() == lobby.getPlayerTwo().getId()) {
            if(lobby.getPlayerTwo().getColor() == ChessEnum.Color.White) {
                return game.getBoard().generateChessBoard(true);
            } else {
                return game.getBoard().generateChessBoard(false);
            }
        } else {
            if(lobby.getPlayerOne().getColor() ==  ChessEnum.Color.White) {
                return game.getBoard().generateChessBoard(true);
            } else {
                return game.getBoard().generateChessBoard(false);
            }
        }
    }

    public Field[][] getBoardState(String lobbyUuid, String playerUuid) {
        var game =  gameDataService.getGame(UUID.fromString(lobbyUuid));
        if(game.getCurrentPlayer().getColor() == ChessEnum.Color.White)  {
            return game.getBoard().generateChessBoard(true);
        } else {
            return game.getBoard().generateChessBoard(false);
        }
    }

    public Game startGame(String lobbyUuid) {
        var lobby = lobbyHandler.getLobby(UUID.fromString(lobbyUuid));
        if(lobby != null && lobby.getPlayerTwo() != null) {
            gameDataService.setGame(lobby);
        }
        return gameDataService.getGame(UUID.fromString(lobbyUuid));
    }
}
