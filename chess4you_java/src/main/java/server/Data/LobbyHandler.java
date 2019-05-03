package server.Data;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Lobby initLobby(String playerName, String iColor) {
        Lobby lobby;
        Player player = GetPlayer(playerName);
        var color = iColor == "black" ? true : false;
        if(!PlayerExistsInLobby(player)) {
            lobby = new Lobby();
            player.setColor(color);
            lobby.setPlayerOne(player);
            ListLobby.put(lobby.getName(), lobby);
        } else {
            lobby = GetLobbyFromPlayer(player);
        }
        return lobby;
    }

    private boolean PlayerExistsInLobby(Player player) {
        var list = ListLobby.values().stream()
                .filter(data -> data.getPlayerOne().getName() == player.getName())
                .toArray();
        return list.length == 0 ? false : true;
    }

    private Lobby GetLobbyFromPlayer(Player player) {
        return  ListLobby.values().stream()
                .filter(data -> data.getPlayerOne().getName() == player.getName())
                .findFirst()
                .get();
    }

    public Lobby JoinLobby(String playerName, UUID correctUuid) {
        Lobby lobby = getLobby(correctUuid);
        Player player = GetPlayer(playerName);
        if (lobby.getPlayerOne().getName() == player.getName()) {
        } else if(lobby.getStartGame()) {
        } else {
            lobby.setPlayerTwo(player);
            ListLobby.put(correctUuid, lobby);
        }
        return lobby;
    }

    private Player CreatePlayer(String playerName) {
        Player player = new Player(playerName);
        playerHandler.SetPlayer(player);
        return player;
    }

    private Player GetPlayer(String playerName) {
        return playerHandler.PlayerExists(playerName) ?
                playerHandler.GetPlayer(playerName) : CreatePlayer(playerName);
    }
}
