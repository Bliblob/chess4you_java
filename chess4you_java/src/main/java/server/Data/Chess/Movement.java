package server.Data.Chess;

import lombok.Getter;
import lombok.Setter;

public class Movement {
    @Getter
    public Position position;
    @Getter @Setter
    public e.Direction direction;
}
