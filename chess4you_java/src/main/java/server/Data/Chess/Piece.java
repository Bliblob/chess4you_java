package server.Data.Chess;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public abstract class Piece {

    @Getter @Setter
    public UUID Uuid;
    @Getter
    public String name;
    @Getter
    public Position position;
    @Getter
    public e.Color color;

    public Piece(Position position, e.Color color){
        this.position = position;
        this.color = color;
        name = this.getClass().getName() + color.name();
    }

    public Piece move(Movement movement) {
        position.setPosX(movement.position.getPosX());
        position.setPosY(movement.position.getPosY());
        return this;
    }
    public static class Builder {
    }

    public static class Mover {

    }

}

