package server.Handler;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import server.Data.Game.Player;
import server.Data.Lobby.Lobby;
import server.Service.GameService;

import java.util.ArrayList;
import java.util.UUID;

@Component
public class LobbyHandler {
    private PlayerHandler playerHandler;
    public GameService gameService;

    @Autowired
    public LobbyHandler(PlayerHandler playerHandler, GameService gameService) {
        this.playerHandler = playerHandler;
        this.gameService = gameService;
    }

    public ArrayList<Lobby> getListLobby() {
        return new ArrayList<>(gameService.getAllLobby());
    }

    public Lobby getLobby(UUID uuid) {
        return gameService.getLobby(uuid);
    }

    public Lobby initLobby(String playerName, String iColor) {
        Lobby lobby;
        Player player = GetPlayer(playerName);
        var color = iColor == "black" ? true : false;
        lobby = new Lobby();
        player.setColor(color);
        lobby.setPlayerOne(player);
        gameService.setGame(lobby);
        /*if(!PlayerExistsInLobby(player)) {
            lobby = new Lobby();
            player.setColor(color);
            lobby.setPlayerOne(player);
            gameService.setGame(lobby);
        } else {
            lobby = GetLobbyFromPlayer(player);
        }*/
        return lobby;
    }

    private boolean PlayerExistsInLobby(Player player) {
        var list = gameService.getAllLobby().stream()
                .filter(data -> data.getPlayerOne().getName() == player.getName())
                .toArray();
        return list.length == 0 ? false : true;
    }

    private Lobby GetLobbyFromPlayer(Player player) {
        return  gameService.getAllLobby().stream()
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
            //ListLobby.put(correctUuid, lobby);
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
