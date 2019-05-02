package server.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import server.repository.PlayerRepository;

import java.util.HashMap;
@Component
public class PlayerHandler {

    private HashMap<String, Player> ListPlayer = new HashMap<>();
    private PlayerRepository playerRepository;

    @Autowired
    public PlayerHandler(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
        for(Player player : this.playerRepository.findAll()){
            ListPlayer.put(player.getName(), player);
        }
    }

    public boolean PlayerExists (String playerName){
        if(ListPlayer.containsKey(playerName)){
            return true;
        } else {
            return false;
        }
    }

    public boolean SetPlayer(Player player) {
        if(!PlayerExists(player.getName())){
            ListPlayer.put(player.getName(), player);
            return true;
        } else {
            return false;
        }
    }

    public Player GetPlayer(String playerName) {
        try {
            return ListPlayer.get(playerName);
        } catch (Exception e){
            return null;
        }
    }
}
