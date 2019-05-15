package server.Controller;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.Data.ChessBoard.Board.ChessBoard;
import server.Game.Turn;
import server.Handler.GameHandler;

@Slf4j
@RestController
public class GameController {
    private Gson gson;
    private GameHandler gameHandler;

    @Autowired
    GameController(GameHandler gameHandler, Gson gson) {
        this.gameHandler = gameHandler;
        this.gson = gson;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/hasPlayerChanged/{lobbyUuid}")
    String getPlayerState(@PathVariable("lobbyUuid") String lobbyUuid){
        return gson.toJson(gameHandler.getGame(lobbyUuid).getTurn());
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/hasBoardChanged/{lobbyUuid}")
    String getBoardState(@PathVariable("lobbyUuid") String lobbyUuid){
        return gson.toJson(new ChessBoard());
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/doTurn/{lobbyUuid}")
    String doTurn(@PathVariable("lobbyUuid") String lobbyUuid, @RequestBody Turn turn){
        return gson.toJson(gameHandler.getGame(lobbyUuid).doTurn(turn));
    }

}
