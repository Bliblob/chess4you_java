package server.Controller;


import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.Data.ChessBoard.Movements.base.Movement;
import server.Handler.MainHandler;

@Slf4j
@RestController
@Api(description = "Controller for start a game, get info, get chessboard, get possible turns or do a turn")
public class PlayRoundController {

    private MainHandler mainHandler;

    @Autowired
    public PlayRoundController(MainHandler mainHandler) {
        this.mainHandler = mainHandler;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/startGame/{lobbyUuid}")
    @ApiOperation("Start a Game by their specific uuid from the lobby")
    String startGame(@ApiParam("The uuid of the Lobby. Cannot be null!") @PathVariable("lobbyUuid") String lobbyUuid) {
        return mainHandler.startGame(lobbyUuid);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getInfo/{lobbyUuid}")
    @ApiOperation("Get a Info Object by their specific uuid from the lobby")
    String getInfo(@ApiParam("The uuid of the Lobby. Cannot be null!") @PathVariable("lobbyUuid") String lobbyUuid){
        return mainHandler.getInfo(lobbyUuid);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getBoard")
    @ResponseBody
    @ApiOperation("Get a specific 2 dimensional Array of the fields for the player by the their uuid from the lobby and player")
    String getBoard(@ApiParam("The uuid of the Lobby. Cannot be null!") @RequestParam("lobbyUuid") String lobbyUuid,
                    @ApiParam("The uuid of the Player. Cannot be null!") @RequestParam("playerUuid") String playerUuid){
        return mainHandler.getBoard(lobbyUuid, playerUuid);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getTurn")
    @ResponseBody
    @ApiOperation("Get a List of possible Movements by the uuid from the Lobby and Player and the Position")
    String getTurn(@ApiParam("The uuid of the Lobby. Cannot be null!") @RequestParam("lobbyUuid") String lobbyUuid,
                   @ApiParam("The uuid of the Lobby. Cannot be null!") @RequestParam("playerUuid") String playerUuid,
                   @ApiParam("The serialized Position Object. Cannot be null!") @RequestParam("position")String position){
        try {
            return mainHandler.getTurn(lobbyUuid, playerUuid, position);
        } catch (Exception e) {
           return e.toString();
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/doTurn")
    @ResponseBody
    @ApiOperation("Do the Turn from his TurnData")
    String doTurn(@ApiParam("The serialized TurnData. Cannot be null!") @RequestBody String data) {
        Gson gson = new Gson();
        DataTurn object = gson.fromJson(data, DataTurn.class);
        return mainHandler.doTurn(object.lobbyUuid, object.playerUuid, object.movement);
    }
}
@Data
class DataTurn{
    String lobbyUuid;
    String playerUuid;
    Movement movement;
}