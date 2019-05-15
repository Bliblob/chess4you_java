package server.Service;

import org.springframework.stereotype.Service;
import server.Data.Lobby.Lobby;
import server.Game.Game;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.UUID;

@Service
public class GameService {

    Dictionary<UUID, Game> ListGame;
    Dictionary<UUID, Lobby> ListLobby;

    public GameService(){
        ListGame = new Hashtable<>();
    }

    public void setGame(Lobby lobby){
        ListGame.put(lobby.getName(), new Game(lobby.getName()));
        ListLobby.put(lobby.getName(), lobby);
    }

    public Game getGame(UUID LobbyUuid){
        return ListGame.get(LobbyUuid);
    }

    public Lobby getLobby(UUID LobbyUuid) {
        return ListLobby.get(LobbyUuid);
    }

    public List<Lobby> getAllLobby() {
        return (List<Lobby>) ListLobby.elements();
    }
}
