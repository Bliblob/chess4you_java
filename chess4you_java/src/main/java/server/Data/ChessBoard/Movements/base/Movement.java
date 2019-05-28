package server.Data.ChessBoard.Movements.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import server.Data.ChessBoard.Board.ChessEnum;

@Getter @Setter
@AllArgsConstructor
public class Movement {
    private Position newPosition;
    private Position oldPosition;
    private ChessEnum.Direction direction;
}
