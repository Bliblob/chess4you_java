package server.Controller;

import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.Handler.MainHandler;



@Slf4j
@RestController
@Api(description = "Controller for creating or retrieving Lobbies")
public class LobbyController {

    private MainHandler mainHandler;

    @Autowired
    LobbyController(MainHandler mainHandler) {
        this.mainHandler = mainHandler;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAllLobby")
    @ApiOperation("Return a List of all Lobbies")
    String getListLobby(){
        return mainHandler.getListLobby();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getLobby")
    @ResponseBody
    @ApiOperation("Return a specific Lobby by their uuid.")
    String getLobby(@ApiParam("The uuid of the lobby Cannot be null!") @RequestParam("lobbyUuid") String lobbyUuid){
        return mainHandler.getLobby(lobbyUuid);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/initLobby")
    @ResponseBody
    @ApiOperation("Initialize a Lobby")
    String initLobby(@ApiParam("The serialized DataInit Object. Cannot be null!") @RequestBody String dataInit){
        var gson = new Gson();
        var  object = gson.fromJson(dataInit,DataInit.class);
        return mainHandler.initLobby(object.getPlayerName(), object.getColor());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/joinLobby")
    @ResponseBody
    @ApiOperation("Join a specific Lobby by their uuid")
    String joinLobby(@ApiParam("The serialized DataJoin Object. Cannot be null!") @RequestBody String dataJoin){
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
