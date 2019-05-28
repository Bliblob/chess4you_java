package server.Data.Game;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Info {
    public Player currentPlayer;
    public Date timeStamp;
}
