package server.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.Data.Game.Player;
import server.Repository.IPlayerRepository;

import java.util.HashMap;
@Service
public class PlayerService {

    private HashMap<String, Player> ListPlayer = new HashMap<>();
    private IPlayerRepository playerRepository;

    @Autowired
    public PlayerService(IPlayerRepository playerRepository) {
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
            playerRepository.insert(player);
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
