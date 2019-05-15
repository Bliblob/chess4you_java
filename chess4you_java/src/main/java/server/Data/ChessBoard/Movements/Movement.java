package server.Data.ChessBoard.Movements;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import server.Data.ChessBoard.Board.ChessEnum;

@Getter @Setter
@AllArgsConstructor
public class Movement {
    public Position newPosition;
    public Position oldPosition;
    public ChessEnum.Direction direction;
}
