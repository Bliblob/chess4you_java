package server.Handler;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import server.Data.ChessBoard.Board.ChessEnum;
import server.Data.Game.Player;
import server.Data.Lobby.Lobby;
import server.Service.GameDataService;
import server.Service.PlayerService;

import java.util.List;
import java.util.UUID;

@Component
public class LobbyHandler {
    private PlayerService playerHandler;
    public GameDataService gameService;

    @Autowired
    public LobbyHandler(PlayerService playerHandler, GameDataService gameService) {
        this.playerHandler = playerHandler;
        this.gameService = gameService;
    }

    public List<Lobby> getListLobby() {
        return gameService.getAllLobby();
    }

    public Lobby getLobby(UUID uuid) {
        return gameService.getLobby(uuid);
    }

    public Lobby initLobby(String playerName, String iColor) {
        Lobby lobby;
        Player player = GetPlayer(playerName);
        var color = iColor == "black" ? ChessEnum.Color.Black : ChessEnum.Color.White;
        if(!PlayerExistsInLobby(player)) {
            player.setColor(color);
            lobby = new Lobby(player);
            gameService.setGame(lobby);
        } else {
            lobby = GetLobbyFromPlayer(player);
        }
        return lobby;
    }

    private boolean PlayerExistsInLobby(Player player) {
        if(gameService.getAllLobby() == null){
            return false;
        }
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

    public Lobby JoinLobby(String playerName, String correctUuid) {
        Lobby lobby = getLobby(UUID.fromString(correctUuid));
        Player player = GetPlayer(playerName);
        if (lobby.getPlayerOne().getName() == player.getName()) {
        } else {
            lobby.setPlayerTwo(player);
            gameService.setLobby(UUID.fromString(correctUuid),  lobby);
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
