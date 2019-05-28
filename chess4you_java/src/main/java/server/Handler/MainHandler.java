package server.Handler;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.Data.ChessBoard.Movements.base.Movement;
import server.Data.ChessBoard.Movements.base.Position;

import java.util.UUID;

@Service
public class MainHandler {
    private Gson gson = new Gson();
    private LobbyHandler lobbyHandler;
    private GameHandler gameHandler;
    private PlayRoundHandler playRoundHandler;

    @Autowired
    public MainHandler(LobbyHandler lobbyHandler, GameHandler gameHandler, PlayRoundHandler playRoundHandler){
        this.lobbyHandler = lobbyHandler;
        this.gameHandler = gameHandler;
        this.playRoundHandler = playRoundHandler;
    }

    public String getListLobby() {
        return gson.toJson(lobbyHandler.getListLobby());
    }

    public String getLobby(String lobbyUuid) {
        UUID correctUuid = UUID.fromString(lobbyUuid);
        return gson.toJson(lobbyHandler.getLobby(correctUuid));
    }

    public String initLobby(String playerName, String color) {
        return gson.toJson(lobbyHandler.initLobby(playerName, color));
    }

    public String joinLobby(String playerName, String lobbyUuid) {
        return gson.toJson(lobbyHandler.JoinLobby(playerName, lobbyUuid));
    }

    public String getInfo(String lobbyUuid) {
        return gson.toJson(playRoundHandler.info(lobbyUuid));
    }

    public String getBoard(String lobbyUuid) {
        return gson.toJson(playRoundHandler.getBoardState(lobbyUuid));
    }

    public String getTurn(String lobbyUuid, String playerUuid, String tmpPosition) throws Exception {
        Position position = gson.fromJson(tmpPosition, Position.class);
        return gson.toJson(playRoundHandler.getPossibleTurnFor(lobbyUuid, playerUuid, position));
    }

    public String startGame(String lobbyUuid) {
        return gson.toJson(playRoundHandler.startGame(lobbyUuid));
    }

    public String doTurn(String lobbyUuid, String playerName, Movement movement) {
        /*playRoundHandler.doTurn(lobbyUuid, playerName, movement)*/
        return gson.toJson("ad");
    }
}
