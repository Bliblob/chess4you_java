package server.Controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.Data.ChessBoard.Movements.base.Movement;
import server.Data.ChessBoard.Movements.base.Position;
import server.Handler.MainHandler;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PlayRoundController {

    private MainHandler mainHandler;

    @Autowired
    public PlayRoundController(MainHandler mainHandler) {
        this.mainHandler = mainHandler;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/startGame/{lobbyUuid}")
    String startGame(@PathVariable("lobbyUuid") String lobbyUuid) {
        return mainHandler.startGame(lobbyUuid);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getInfo/{lobbyUuid}")
    String getInfo(@PathVariable("lobbyUuid") String lobbyUuid){
        return mainHandler.getInfo(lobbyUuid);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getBoard/{lobbyUuid}/")
    String getBoard(@PathVariable("lobbyUuid") String lobbyUuid){
        return mainHandler.getBoard(lobbyUuid);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getTurn")
    String getTurn(@RequestParam("lobbyUuid") String lobbyUuid,
                   @RequestParam("playerUuid") String playerUuid,
                   @RequestParam("position")String position){
        try {
            return mainHandler.getTurn(lobbyUuid, playerUuid, position);
        } catch (Exception e) {
           return e.toString();
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/doTurn")
    @ResponseBody
    String doTurn(@RequestParam("lobbyUuid") String lobbyUuid,
                  @RequestParam("playerUuid") String playerUuid,
                  @RequestParam("movement") Movement movement) {
        return mainHandler.doTurn(lobbyUuid, playerUuid, movement);
    }

}