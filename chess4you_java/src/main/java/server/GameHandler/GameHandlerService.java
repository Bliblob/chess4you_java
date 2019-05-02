package server.GameHandler;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import server.Data.LobbyHandler;

import java.util.UUID;


@Slf4j
@RestController
public class GameHandlerService {

    private LobbyHandler lobbyHandler;
    private Gson gson;

    @Autowired
    GameHandlerService(LobbyHandler lobbyHandler) {
        this.lobbyHandler = lobbyHandler;
        gson = new Gson();
    }
    @CrossOrigin
    @GetMapping("/getListLobby")
    String getListLobby(){
        return gson.toJson(lobbyHandler.getListLobby());
    }

    @CrossOrigin
    @GetMapping("/getLobby/{uuid}")
    String getLobby(@PathVariable String uuid){
        UUID correctUuid = UUID.fromString(uuid);
        return gson.toJson(lobbyHandler.getLobby(correctUuid));
    }
    @CrossOrigin
    @GetMapping("/initLobby/{playerName}")
    String initLobby(@PathVariable String playerName){
        return gson.toJson(lobbyHandler.initLobby(playerName));
    }

    @CrossOrigin
    @GetMapping("/joinLobby/{playerName}/{uuid}")
    String joinLobby(@PathVariable("playerName") String playerName, @PathVariable("uuid") String uuid){
        UUID correctUuid = UUID.fromString(uuid);
        return gson.toJson(lobbyHandler.joinLobby(playerName, correctUuid));
    }

    @CrossOrigin
    @GetMapping("getUpdateLobby/{uuid}")
    String getUpdateLobby(@PathVariable String uuid){
        UUID correctUuid = UUID.fromString(uuid);
        return gson.toJson(lobbyHandler.getLobby(correctUuid));
    }

}

