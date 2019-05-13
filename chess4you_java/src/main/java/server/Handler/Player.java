package server.Handler;

import lombok.Data;

@Data
public class Player {

    public String Name;

    public Player(String Name){
        this.Name = Name;
    }
}
