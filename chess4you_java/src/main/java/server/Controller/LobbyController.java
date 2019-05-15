package server.Controller;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import server.Handler.LobbyHandler;

import java.util.UUID;


@Slf4j
@RestController
public class LobbyController {

    private LobbyHandler lobbyHandler;
    private Gson gson;

    @Autowired
    LobbyController(LobbyHandler lobbyHandler) {
        this.lobbyHandler = lobbyHandler;
        gson = new Gson();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getListLobby")
    String getListLobby(){
        return gson.toJson(lobbyHandler.getListLobby());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getLobby/{uuid}")
    String getLobby(@PathVariable String uuid){
        UUID correctUuid = UUID.fromString(uuid);
        return gson.toJson(lobbyHandler.getLobby(correctUuid));
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/initLobby/{playerName}/{color}")
    String initLobby(@PathVariable("playerName") String playerName, @PathVariable("color") String color){
        return gson.toJson(lobbyHandler.initLobby(playerName, color));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/joinLobby/{playerName}/{uuid}")
    String joinLobby(@PathVariable("playerName") String playerName, @PathVariable("uuid") String uuid){
        UUID correctUuid = UUID.fromString(uuid);
        return gson.toJson(lobbyHandler.JoinLobby(playerName, correctUuid));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("getUpdateLobby/{uuid}")
    String getUpdateLobby(@PathVariable String uuid){
        UUID correctUuid = UUID.fromString(uuid);
        return gson.toJson(lobbyHandler.getLobby(correctUuid));
    }

}

