package server.GameHandler;

import lombok.Data;

@Data
public class Player {

    public String Name;

    public Player(String Name){
        this.Name = Name;
    }
}
