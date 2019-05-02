package server.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

@Component
public class LobbyHandler {
    private HashMap<UUID,Lobby> ListLobby;
    private PlayerHandler playerHandler;

    @Autowired
    public LobbyHandler(PlayerHandler playerHandler) {
        this.playerHandler = playerHandler;
        ListLobby = new HashMap<>();
    }

    public ArrayList<Lobby> getListLobby() {
        return new ArrayList<>(ListLobby.values());
    }

    public Lobby getLobby(UUID uuid) {
        return ListLobby.get(uuid);
    }

    public Lobby initLobby(String playerName) {
        Lobby lobby = new Lobby();
        Player player = CreateOrGetPlayer(playerName);
        lobby.setPlayerOne(player);
        ListLobby.put(lobby.getName(), lobby);
        return lobby;
    }

    public Lobby joinLobby(String playerName, UUID correctUuid) {
        Lobby lobby = getLobby(correctUuid);
        Player player = CreateOrGetPlayer(playerName);
        lobby.setPlayerTwo(player);
        ListLobby.put(correctUuid, lobby);
        return lobby;
    }

    private Player CreateOrGetPlayer(String playerName){
        if(playerHandler.PlayerExists(playerName)){
            return playerHandler.GetPlayer(playerName);
        } else {
            Player player = new Player(playerName);
            playerHandler.SetPlayer(player);
            return player;
        }
    }
}
