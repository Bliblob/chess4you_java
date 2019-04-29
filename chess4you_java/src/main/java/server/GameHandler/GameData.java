package server.GameHandler;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
public class GameData {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy =  "uuid2")
    public String UUID;
    public Player PlayerOne;
    public Player PlayerTwo;

    public GameData(Player PlayerOne, Player PlayerTwo){
        this.PlayerOne = PlayerOne;
        this.PlayerTwo = PlayerTwo;
    }
}
