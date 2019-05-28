package server.Controller;

import com.google.gson.Gson;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.Handler.MainHandler;



@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LobbyController {

    private MainHandler mainHandler;

    @Autowired
    LobbyController(MainHandler mainHandler) {
        this.mainHandler = mainHandler;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAllLobby")
    String getListLobby(){
        return mainHandler.getListLobby();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getLobby")
    @ResponseBody
    String getLobby(@RequestParam("lobbyUuid") String lobbyUuid){
        return mainHandler.getLobby(lobbyUuid);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/initLobby")
    @ResponseBody
    String initLobby(@RequestBody String dataInit){
        var gson = new Gson();
        var  object = gson.fromJson(dataInit,DataInit.class);
        return mainHandler.initLobby(object.getPlayerName(), object.getColor());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/joinLobby")
    @ResponseBody
    String joinLobby(@RequestBody String dataJoin){
        var gson = new Gson();
        var  object = gson.fromJson(dataJoin, DataJoin.class);
        return mainHandler.joinLobby(object.getPlayerName(), object.getLobbyUuid());
    }

}
@Data
class DataInit {
    String playerName;
    String color;
}

@Data
class DataJoin {
    String lobbyUuid;
    String playerName;
}
