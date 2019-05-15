package server.Data.Game;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "players")
public class Player {
    @Id
    private String Id;
    private String Name;
    private boolean Color;

    public Player(String Name){
        this.Name = Name;
    }

    public String getName() {
        return Name;
    }

    public boolean isColor() {
        return Color;
    }

    public void setColor(boolean color) {
        Color = color;
    }
}
