package server.Service;

import lombok.var;
import org.springframework.stereotype.Service;
import server.Data.ChessBoard.Board.ChessBoard;
import server.Data.Lobby.Lobby;
import server.Game.Game;

import java.util.*;

@Service

public class GameDataService {

    private Dictionary<UUID, Game> ListGame;
    private Dictionary<UUID, Lobby> ListLobby;

    public GameDataService(){
        ListGame = new Hashtable<>();
        ListLobby = new Hashtable<>();
    }

    public Long getCurrentDate(){
        return new Date().getTime();
    }

    public void setGame(Lobby lobby){
        var game = new Game();
        game.setBoard(new ChessBoard());
        game.setCurrentPlayer(lobby.getPlayerOne());
        game.setLastChange(new Date());
        ListGame.put(lobby.getName(), game);
        ListLobby.put(lobby.getName(), lobby);
    }

    public Game getGame(UUID LobbyUuid){
        return ListGame.get(LobbyUuid);
    }

    public Lobby getLobby(UUID LobbyUuid) {

        return ListLobby.get(LobbyUuid);
    }

    public List<Lobby> getAllLobby() {
        return Collections.list(ListLobby.elements());
    }

    public void setLobby(UUID LobbyUuid, Lobby lobby) {
        ListLobby.put(LobbyUuid, lobby);
    }
}
