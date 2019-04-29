package server.GameHandler;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class GameHandlerService {

    private GameHandler gameHandler;

    GameHandlerService() {

        this.gameHandler = new GameHandler(this);
    }

    @CrossOrigin(origins =  "http://localhost:4200")
    @PutMapping("/register")
    void registerGameClient(@RequestBody String name){
        GameClient gameClient = new Gson().fromJson(name, GameClient.class);
        gameHandler.registerGameClient(gameClient);
        bool k= gameHandler.checkIfPossibleOpponentExists(gameClient);
        log.info("GameClient Name: " + gameClient.getName());
    }
}

